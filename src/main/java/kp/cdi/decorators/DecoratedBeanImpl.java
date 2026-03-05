package kp.cdi.decorators;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Decorated implementation of the {@link PlainBean} interface.
 * <p>
 * CDI decorators are enabled in the file 'beans.xml'.
 * </p>
 */
@Decorator
public class DecoratedBeanImpl implements PlainBean {
    private final Logger logger;
    private final List<List<String>> report;
    private final PlainBean plainBean;

    private static final String CLASS_NAME = DecoratedBeanImpl.class.getSimpleName();

    /**
     * Parameterized constructor.
     *
     * @param logger    the {@link Logger} to use
     * @param report    the report list
     * @param plainBean the delegate {@link PlainBean}
     */
    @Inject
    public DecoratedBeanImpl(Logger logger, List<List<String>> report,
                             @Delegate @Any PlainBean plainBean) {
        this.logger = logger;
        this.report = report;
        this.plainBean = plainBean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show(String content) {

        report.add(List.of(CLASS_NAME, "show", "before plain bean calls"));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("show(): before plain bean calls");
        }

        plainBean.show(content);
        report.add(List.of(CLASS_NAME, "show", "after 1st plain bean call (content unchanged)"));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("show(): after 1st plain bean call");
        }

        plainBean.show(new StringBuilder(content).reverse().toString());
        report.add(List.of(CLASS_NAME, "show", "after 2nd plain bean call (content reversed)"));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("show(): after 2nd plain bean call");
        }
        if (logger.isLoggable(Level.FINEST)) {
            logger.finest("show(): is instance of PlainBeanImpl[%b]".formatted(plainBean instanceof PlainBeanImpl));
        }
    }
}