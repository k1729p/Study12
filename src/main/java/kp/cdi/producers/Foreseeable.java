package kp.cdi.producers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.enterprise.util.Nonbinding;
import jakarta.inject.Qualifier;

/**
 * The qualifier for formated foreseeable date and time.
 *
 */
@Qualifier
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, TYPE })
public @interface Foreseeable {
	/**
	 * The value.
	 * 
	 * @return the foreseeable date
	 */
	@Nonbinding
	public ForeseeableDate value() default ForeseeableDate.FAR;

	/**
	 * The pattern.
	 * 
	 * @return the pattern
	 */
	@Nonbinding
	public String pattern() default "yyyy-MM-dd HH:mm:ss";
}