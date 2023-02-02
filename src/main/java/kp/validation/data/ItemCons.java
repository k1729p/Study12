package kp.validation.data;

import jakarta.validation.constraints.Pattern;

/**
 * The interface with one property-level constraint.
 *
 */
public interface ItemCons {

	/**
	 * Sets the value.
	 * 
	 * @param val the value
	 */
	void setVal(String val);

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	/*- property-level constraint */
	@Pattern(regexp = ".*Ret")
	String getVal();
}