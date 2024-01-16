package kp.cdi.events;

import java.io.Serial;
import java.io.Serializable;

/**
 * The payload.
 *
 */
public class Payload implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * The content.
	 */
	private String content;

	/**
	 * The constructor.
	 */
	public Payload() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param content the content
	 * 
	 */
	public Payload(String content) {
		super();
		this.content = content;
	}

	/**
	 * Gets the content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 * 
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}