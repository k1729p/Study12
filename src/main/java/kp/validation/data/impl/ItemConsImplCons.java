package kp.validation.data.impl;

import jakarta.validation.constraints.Pattern;
import kp.validation.data.ItemCons;

/**
 * Implementation with a field-level constraint.
 * <p>
 * The property-level constraint is inherited from the interface.
 * </p>
 */
public class ItemConsImplCons implements ItemCons {

    /*- field-level constraint */
    @Pattern(regexp = "Fld.*")
    private String val;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVal(String val) {
        this.val = val;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVal() {
        return val;
    }
}