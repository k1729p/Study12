package kp.restful.data;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.Pattern;

/**
 * The box with id and text.
 *
 */
public class Box implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	private int id = 0;

	/**
	 * The text.
	 */
	@Pattern(regexp = "[A-Z]*")
	private String text = null;

	/**
	 * Constructor.
	 * 
	 */
	public Box() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param text the text
	 */
	public Box(String text) {
		super();
		this.text = text;
	}

	/**
	 * Constructor.
	 * 
	 * @param id   the id
	 * @param text the text
	 */
	public Box(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
}