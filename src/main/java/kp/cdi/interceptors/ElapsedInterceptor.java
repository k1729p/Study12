package kp.cdi.interceptors;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

/**
 * The elapsed time interceptor.
 * <p>
 * The CDI interceptors are enabled in the file 'beans.xml'.
 */
@Elapsed
@Interceptor
public class ElapsedInterceptor {
	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	private static final String CLASS_NAME = ElapsedInterceptor.class.getSimpleName();
	private static final int REFERENCE_PAUSE = 1;

	/**
	 * The constructor.
	 */
	public ElapsedInterceptor() {
		super();
	}

	/**
	 * The interceptor method. Measures the elapsed execution time.
	 * 
	 * @param invocationContext the invocation context
	 * @return the result
	 */
	@AroundInvoke
	public Object measure(InvocationContext invocationContext) {

		Object result = null;
		final long start = System.nanoTime();
		try {
			result = invocationContext.proceed();
		} catch (Exception e) {
			logger.severe(String.format("measure(): exception[%s]", e.getMessage()));
			System.exit(1);
		}
		final long diff = System.nanoTime() - start;

		final String message = String.format("method[%11s], %s", invocationContext.getMethod().getName(),
				formatElapsed(diff));
		report.add(List.of(CLASS_NAME, "measure", message));
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("measure(): Method[%s], time elapsed [%d]ns (reference), [%d]ns (after invoke)",
					invocationContext.getMethod().getName(), getReference(), diff));
		}
		return result;
	}

	/**
	 * Gets reference measure with minimal one nanosecond pause.
	 * 
	 * @return the difference
	 */
	private long getReference() {

		long start = System.nanoTime();
		long diff;
		do {
			diff = System.nanoTime() - start;
		} while (diff < REFERENCE_PAUSE);
		return diff;
	}

	/**
	 * Formats the elapsed time.
	 * 
	 * @param time the time
	 * @return the formatted elapsed time
	 */
	private String formatElapsed(long time) {

		long millis = time / 1_000_000 % 1_000;
		long micros = time / 1_000 % 1_000;
		long nanos = time % 1_000;

		if (millis > 0) {
			return String.format("elapsed[%3dms %3dμs %3dns]", millis, micros, nanos);
		} else if (micros > 0) {
			return String.format("elapsed[      %3dμs %3dns]", micros, nanos);
		} else {
			return String.format("elapsed[            %3dns]", nanos);
		}
	}
}