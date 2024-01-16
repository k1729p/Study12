package kp.cdi.events.observers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import kp.cdi.events.Payload;

/**
 * The implementation of the {@link BasicObserver} with two new methods.
 *
 */
public class BigObserver extends BasicObserver {
	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	private static final String CLASS_NAME = BigObserver.class.getSimpleName();

	/**
	 * The constructor.
	 */
	public BigObserver() {
		super();
	}

	/**
	 * The observer method for showing the {@link Payload} list.
	 * 
	 * @param payloadList the payload list
	 */
	public void showPayloadList(@Observes List<Payload> payloadList) {

		final String message = String.format("content[%s]", payloadList.getFirst().getContent());
		report.add(List.of(CLASS_NAME, "showPayloadList", message));
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("showPayloadList(): content[%s]", payloadList.getFirst().getContent()));
		}
	}

	/**
	 * The observer method for showing the text list.
	 * 
	 * @param textList the text list
	 */
	public void showTextList(@Observes List<String> textList) {

		report.add((List.of(CLASS_NAME, "showTextList", String.format("content[%s]", textList.getFirst()))));
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("showTextList(): content[%s]", textList.getFirst()));
		}
	}
}