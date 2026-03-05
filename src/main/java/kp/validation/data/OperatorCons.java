package kp.validation.data;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * OperatorCons - interface with two constraints on the method.
 */
public interface OperatorCons {

    /**
     * Processes the value.
     *
     * @param value the value
     * @return the value
     */
    @Max(1)
    default int process(@Min(2) Integer value) {

        final Logger logger = Logger.getLogger(OperatorCons.class.getName());
        if (logger.isLoggable(Level.INFO)) {
            logger.info("process(): value[%d]".formatted(value));
        }
        return value;
    }
}