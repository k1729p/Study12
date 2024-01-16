package kp.cdi.alternatives;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.inject.Inject;

/**
 * The implementation of the {@link BasicBean}.
 *
 */
public class BasicBeanImpl implements BasicBean {
	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;
	private static final String CLASS_NAME = BasicBeanImpl.class.getSimpleName();

	/**
	 * The constructor.
	 */
	public BasicBeanImpl() {
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
			logger.info(String.format("show(): content[%s]", content));
		}
	}
}