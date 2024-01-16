package kp.cdi.alternatives;

import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;

/**
 * The alternative implementation of the {@link BasicBean}.
 * <p>
 * The CDI alternatives are enabled in the file 'beans.xml'.
 */
@Alternative
public class BasicBeanImplAlt implements BasicBean {
	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	private static final Function<String, List<String>> ROW_FUN = content -> List.of(
			BasicBeanImplAlt.class.getSimpleName(), "show", String.format("content[%s] (Alternative Bean)", content));

	/**
	 * The constructor.
	 */
	public BasicBeanImplAlt() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void show(String content) {

		report.add(ROW_FUN.apply(content));
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("show(): content[%s]", content));
		}
	}
}