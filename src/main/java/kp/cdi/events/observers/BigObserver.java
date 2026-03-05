package kp.cdi.events.observers;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import kp.cdi.events.Payload;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the {@link BasicObserver} with two additional methods.
 */
public class BigObserver extends BasicObserver {
    private static final String CLASS_NAME = BigObserver.class.getSimpleName();

    /**
     * Parameterized constructor.
     *
     * @param logger the {@link Logger}
     * @param report the report list
     */
    @Inject
    public BigObserver(Logger logger, List<List<String>> report) {
        super(logger, report);
    }

    /**
     * Observer method for displaying the {@link Payload} list.
     *
     * @param payloadList the payload list
     */
    public void showPayloadList(@Observes List<Payload> payloadList) {

        final String message = "content[%s]".formatted(payloadList.getFirst().getContent());
        report.add(List.of(CLASS_NAME, "showPayloadList", message));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("showPayloadList(): content[%s]".formatted(payloadList.getFirst().getContent()));
        }
    }

    /**
     * Observer method for displaying the text list.
     *
     * @param textList the text list
     */
    public void showTextList(@Observes List<String> textList) {

        report.add((List.of(CLASS_NAME, "showTextList", "content[%s]".formatted(textList.getFirst()))));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("showTextList(): content[%s]".formatted(textList.getFirst()));
        }
    }
}