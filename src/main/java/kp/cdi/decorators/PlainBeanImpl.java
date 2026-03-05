package kp.cdi.decorators;

import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the {@link PlainBean} interface.
 */
public class PlainBeanImpl implements PlainBean {
    private final Logger logger;
    private final List<List<String>> report;

    private static final String CLASS_NAME = PlainBeanImpl.class.getSimpleName();

    /**
     * Parameterized constructor.
     *
     * @param logger the {@link Logger} to use
     * @param report the report list
     */
    @Inject
    public PlainBeanImpl(Logger logger, List<List<String>> report) {
        this.logger = logger;
        this.report = report;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show(String content) {

        report.add(List.of(CLASS_NAME, "show", "content[%s]".formatted(content)));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("show(): class name[%s], content[%s]".formatted(CLASS_NAME, content));
        }
    }
}