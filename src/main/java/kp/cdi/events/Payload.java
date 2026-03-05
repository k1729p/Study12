package kp.cdi.events;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a payload with content.
 */
public class Payload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The content of the payload.
     */
    private String content;

    /**
     * Parameterized constructor.
     *
     * @param content the content of the payload
     */
    public Payload(String content) {
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