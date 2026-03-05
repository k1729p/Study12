package kp.cdi.events.observers;

import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

/**
 * Implementation of the {@link BasicObserver} without additional methods.
 */
public class SmallObserver extends BasicObserver {
    /**
     * Parameterized constructor.
     *
     * @param logger the {@link Logger}
     * @param report the report list
     */
    @Inject
    public SmallObserver(Logger logger, List<List<String>> report) {
        super(logger, report);
    }
}