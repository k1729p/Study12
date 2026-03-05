package kp.cdi.alternatives;

import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;

import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The alternative implementation of the {@link BasicBean}.
 * <p>
 * CDI alternatives are enabled in the 'beans.xml' file.
 * </p>
 */
@Alternative
public class BasicBeanImplAlt implements BasicBean {
    private final Logger logger;
    private final List<List<String>> report;

    private static final Function<String, List<String>> ROW_FUN = content -> List.of(
            BasicBeanImplAlt.class.getSimpleName(), "show", "content[%s] (Alternative Bean)".formatted(content));

    /**
     * Parameterized constructor.
     *
     * @param logger the {@link Logger}
     * @param report the report list
     */
    @Inject
    public BasicBeanImplAlt(Logger logger, List<List<String>> report) {
        this.logger = logger;
        this.report = report;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show(String content) {

        report.add(ROW_FUN.apply(content));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("show(): content[%s]".formatted(content));
        }
    }
}