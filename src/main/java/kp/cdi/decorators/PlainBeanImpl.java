package kp.cdi.decorators;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.inject.Inject;

/**
 * The implementation of the {@link PlainBean}.
 *
 */
public class PlainBeanImpl implements PlainBean {
	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	private static final String CLASS_NAME = PlainBeanImpl.class.getSimpleName();

	/**
	 * The constructor.
	 */
	public PlainBeanImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void show(String content) {

		report.add(List.of(CLASS_NAME, "show", String.format("content[%s]", content)));
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("show(): class name[%s], content[%s]", CLASS_NAME, content));
		}
	}
}