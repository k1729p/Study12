package kp.cdi.producers;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

/**
 * The producers for CDI research.
 *
 */
class Producers {

	/**
	 * The constructor.
	 */
	Producers() {
		super();
	}

	/**
	 * Produces the logger.
	 * 
	 * @param injectionPoint the injection point
	 * @return the logger
	 */
	@Produces
	public Logger getLogger(InjectionPoint injectionPoint) {

		final String category = injectionPoint.getMember().getDeclaringClass().getName();
		return Logger.getLogger(category);
	}

	/**
	 * Produces the report.
	 */
	@Produces
	protected static final List<List<String>> report = new ArrayList<>();

	/**
	 * Produces the formatted foreseeable date.
	 * 
	 * @param injectionPoint the injection point
	 * @return the foreseeable date
	 */
	@Produces
	@Foreseeable
	@Dependent
	public String getForeseeable(InjectionPoint injectionPoint) {

		final Foreseeable foreseeable = injectionPoint.getAnnotated().getAnnotation(Foreseeable.class);
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(foreseeable.pattern());
		return foreseeable.value().localDateTime.format(formatter);
	}
}