package kp.validation.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

/**
 * BoxCons - contains the list with validation cascading.
 *
 */
public class BoxCons {

	@NotNull
	@Valid
	private final List<ItemCons> list;

	@DecimalMin("10.00")
	@DecimalMax("100.00")
	private final BigDecimal decimal;

	/**
	 * The constructor.
	 */
	public BoxCons() {
		super();
		this.list = new ArrayList<>();
		this.decimal = BigDecimal.TEN;
	}

	/**
	 * The constructor.
	 * 
	 * @param list    the list
	 * @param decimal the decimal
	 */
	public BoxCons(List<ItemCons> list, BigDecimal decimal) {
		super();
		this.list = list;
		this.decimal = decimal;
	}
}