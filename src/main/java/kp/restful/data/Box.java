package kp.restful.data;

import jakarta.validation.constraints.Pattern;

import java.io.Serial;
import java.io.Serializable;

/**
 * Box with the id and the text.
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
     * Default constructor.
     */
    public Box() {
    }

    /**
     * Parameterized constructor.
     *
     * @param text the text
     */
    public Box(String text) {
        this.text = text;
    }

    /**
     * Parameterized constructor.
     *
     * @param id   the id
     * @param text the text
     */
    public Box(int id, String text) {
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