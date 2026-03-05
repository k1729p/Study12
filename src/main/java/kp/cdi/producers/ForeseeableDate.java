package kp.cdi.producers;

import java.time.LocalDateTime;

/**
 * Enumeration of foreseeable date values.
 */
public enum ForeseeableDate {
    /**
     * The near date.
     */
    NEAR(LocalDateTime.of(2033, 3, 6, 9, 12, 24)),
    /**
     * The far away date.
     */
    FAR(LocalDateTime.of(2050, 5, 10, 15, 20, 25));

    /**
     * {@link LocalDateTime}.
     */
    final LocalDateTime localDateTime;

    /**
     * Parameterized constructor.
     *
     * @param localDateTime the local date and time
     */
    ForeseeableDate(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

}