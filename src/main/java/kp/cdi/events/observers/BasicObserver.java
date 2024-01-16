package kp.cdi.events.observers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import kp.cdi.events.Payload;

/**
 * The basic observer.
 *
 */
public abstract class BasicObserver {
	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	/**
	 * The constructor.
	 */
	protected BasicObserver() {
		super();
	}

	/**
	 * The observer method for showing the {@link Payload}.
	 * 
	 * @param payload the payload
	 */
	public void showPayload(@Observes Payload payload) {

		final String className = this.getClass().getSimpleName();
		report.add(List.of(className, "showPayload", String.format("content[%s]", payload.getContent())));
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("showPayload(): content[%s]", payload.getContent()));
		}
	}
}
