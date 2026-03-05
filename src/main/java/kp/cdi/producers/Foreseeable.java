package kp.cdi.producers;

import jakarta.enterprise.util.Nonbinding;
import jakarta.inject.Qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Qualifier for the formatted foreseeable date and time.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE})
public @interface Foreseeable {
    /**
     * Gets the value.
     *
     * @return the foreseeable date
     */
    @Nonbinding
    ForeseeableDate value() default ForeseeableDate.FAR;

    /**
     * Gets the pattern.
     *
     * @return the pattern
     */
    @Nonbinding
    String pattern() default "yyyy-MM-dd HH:mm:ss";
}