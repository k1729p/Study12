package kp.cdi.alternatives;

import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the {@link BasicBean}.
 */
public class BasicBeanImpl implements BasicBean {
    private final Logger logger;
    private final List<List<String>> report;

    /**
     * Parameterized constructor.
     *
     * @param logger the {@link Logger}
     * @param report the report list
     */
    @Inject
    public BasicBeanImpl(Logger logger, List<List<String>> report) {
        this.logger = logger;
        this.report = report;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show(String content) {

        report.add(List.of(BasicBeanImpl.class.getSimpleName(), "show", "content[%s]".formatted(content)));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("show(): content[%s]".formatted(content));
        }
    }
}