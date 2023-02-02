package kp.validation.data;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/**
 * OperCons - interface with two constraints on method.
 *
 */
public interface OperCons {

	/**
	 * Processes the value.
	 * 
	 * @param value the value
	 * @return the value
	 */
	@Max(1)
	default int process(@Min(2) Integer value) {

		final Logger logger = Logger.getLogger(OperCons.class.getName());
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("process(): value[%d]", value));
		}
		return value;
	}
}