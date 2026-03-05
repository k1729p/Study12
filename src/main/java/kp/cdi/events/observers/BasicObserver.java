package kp.cdi.events.observers;

import jakarta.enterprise.event.Observes;
import kp.cdi.events.Payload;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The basic observer.
 */
public abstract class BasicObserver {
    /**
     * Logger.
     */
    protected final Logger logger;
    /**
     * Report list.
     */
    protected final List<List<String>> report;

    /**
     * Parameterized constructor.
     *
     * @param logger the {@link Logger}
     * @param report the report list
     */
    protected BasicObserver(Logger logger, List<List<String>> report) {
        this.logger = logger;
        this.report = report;
    }

    /**
     * The observer method for displaying the {@link Payload}.
     *
     * @param payload the payload
     */
    public void showPayload(@Observes Payload payload) {

        final String className = this.getClass().getSimpleName();
        report.add(List.of(className, "showPayload", "content[%s]".formatted(payload.getContent())));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("showPayload(): content[%s]".formatted(payload.getContent()));
        }
    }
}
