package kp.validation.data.impl;

import jakarta.validation.constraints.Pattern;
import kp.validation.data.ItemCons;

/**
 * The implementation with one field-level constraint and one property-level
 * constraint.
 *
 */
public class ItemConsImplCons implements ItemCons {

	/*- field-level constraint */
	@Pattern(regexp = "Fld.*")
	private String val;

	/**
	 * The constructor.
	 */
	public ItemConsImplCons() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void setVal(String val) {
		this.val = val;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	/*- property-level constraint */
	public @Pattern(regexp = ".*Ret") String getVal() {
		return val;
	}
}