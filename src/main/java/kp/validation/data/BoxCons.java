package kp.validation.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * BoxCons - contains a list with validation cascading.
 */
public class BoxCons {

    @NotNull
    @Valid
    final List<ItemCons> list;

    @DecimalMin("10.00")
    @DecimalMax("100.00")
    final BigDecimal decimal;

    /**
     * Default constructor.
     */
    public BoxCons() {
        this.list = new ArrayList<>();
        this.decimal = BigDecimal.TEN;
    }

    /**
     * Parameterized constructor.
     *
     * @param list    the list of items
     * @param decimal the decimal value
     */
    public BoxCons(List<ItemCons> list, BigDecimal decimal) {
        this.list = list;
        this.decimal = decimal;
    }
}