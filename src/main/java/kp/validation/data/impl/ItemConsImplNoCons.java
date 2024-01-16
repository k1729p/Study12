package kp.validation.data.impl;

import kp.validation.data.ItemCons;

/**
 * The implementation without any constraints.
 *
 */
public class ItemConsImplNoCons implements ItemCons {

	private String val;

	/**
	 * The constructor.
	 */
	public ItemConsImplNoCons() {
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
	public String getVal() {
		return val;
	}
}