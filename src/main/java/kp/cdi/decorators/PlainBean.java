package kp.cdi.decorators;

/**
 * Interface representing a plain bean with content.
 */
public interface PlainBean {
    /**
     * Displays the provided content.
     *
     * @param content the content to display
     */
    void show(String content);
}