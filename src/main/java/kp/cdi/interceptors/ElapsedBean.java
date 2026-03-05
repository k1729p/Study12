package kp.cdi.interceptors;

/**
 * Bean to measure elapsed time.
 */
@Elapsed
public class ElapsedBean {
    private static final int PAUSE_NANO = 1;
    private static final int PAUSE_MICRO = 1_000;
    private static final int PAUSE_MILLI = 1_000_000;

    /**
     * No pause at all.
     */
    public void notPaused() {
        /*-
         * do not pause
         */
    }

    /**
     * Pause for one nanosecond.
     */
    public void pausedNano() {

        long start = System.nanoTime();
        long diff;
        do {
            diff = System.nanoTime() - start;
        } while (diff < PAUSE_NANO);
    }

    /**
     * Pause for one microsecond.
     */
    public void pausedMicro() {

        long start = System.nanoTime();
        long diff;
        do {
            diff = System.nanoTime() - start;
        } while (diff < PAUSE_MICRO);
    }

    /**
     * Pause for one millisecond.
     */
    public void pausedMilli() {

        long start = System.nanoTime();
        long diff;
        do {
            diff = System.nanoTime() - start;
        } while (diff < PAUSE_MILLI);
    }
}