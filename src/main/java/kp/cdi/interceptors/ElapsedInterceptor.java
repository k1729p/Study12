package kp.cdi.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interceptor to measure elapsed execution time.
 * <p>
 * CDI interceptors are enabled in the file 'beans.xml'.
 * </p>
 */
@Elapsed
@Interceptor
public class ElapsedInterceptor {
    private final Logger logger;
    private final List<List<String>> report;

    private static final int REFERENCE_PAUSE = 1;

    /**
     * Parameterized constructor.
     *
     * @param logger the {@link Logger}
     * @param report the report list
     */
    @Inject
    public ElapsedInterceptor(Logger logger, List<List<String>> report) {
        this.logger = logger;
        this.report = report;
    }

    /**
     * Measure the elapsed execution time.
     * <p>
     * Interceptor method.
     * </p>
     *
     * @param invocationContext the {@link InvocationContext}
     * @return the result
     */
    @AroundInvoke
    public Object measure(InvocationContext invocationContext) {

        Object result = null;
        final long start = System.nanoTime();
        try {
            result = invocationContext.proceed();
        } catch (Exception e) {
            logger.severe("measure(): exception[%s]".formatted(e.getMessage()));
            System.exit(1);
        }
        final long diff = System.nanoTime() - start;

        final String message = "method[%11s], %s".formatted(invocationContext.getMethod().getName(),
                formatElapsed(diff));
        report.add(List.of(ElapsedInterceptor.class.getSimpleName(), "measure", message));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("measure(): Method[%s], time elapsed [%d]ns (reference), [%d]ns (after invoke)".formatted(
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
            return "elapsed[%3dms %3dμs %3dns]".formatted(millis, micros, nanos);
        } else if (micros > 0) {
            return "elapsed[      %3dμs %3dns]".formatted(micros, nanos);
        } else {
            return "elapsed[            %3dns]".formatted(nanos);
        }
    }
}