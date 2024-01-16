package kp.cdi.decorators;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

/**
 * The decorated implementation of the {@link PlainBean}.
 * <p>
 * The CDI decorators are enabled in the file 'beans.xml'.
 */
@Decorator
public class DecoratedBeanImpl implements PlainBean {
	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	@Delegate
	@Any
	private PlainBean plainBean;

	private static final String CLASS_NAME = DecoratedBeanImpl.class.getSimpleName();

	/**
	 * The constructor.
	 */
	public DecoratedBeanImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
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
	}
}