package kp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * The logging formatter.
 * 
 */
public class LoggingFormatter extends Formatter {

	private static final boolean SHOW_CLASS = true;
	private static final boolean SHOW_METHOD = false;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm:ss.SSS");

	/**
	 * The constructor.
	 */
	public LoggingFormatter() {
		super();
	}

	/**
	 * Formats the log message.
	 * 
	 * @param logRecord the log record
	 * @return the formatted message
	 */
	public String format(LogRecord logRecord) {

		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(logRecord.getLevel().toString(), 0, 3);
		stringBuilder.append(" ");
		stringBuilder.append(logRecord.getLongThreadID());
		stringBuilder.append(" ");
		stringBuilder.append(dateFormat.format(new Date(logRecord.getMillis())));
		stringBuilder.append(" ");
		if (SHOW_CLASS) {
			String className = logRecord.getSourceClassName();
			className = className.substring(className.lastIndexOf('.') + 1);
			stringBuilder.append(className);
			stringBuilder.append(".");
			if (SHOW_METHOD) {
				stringBuilder.append(logRecord.getSourceMethodName());
				stringBuilder.append("(): ");
			}
		}
		stringBuilder.append(super.formatMessage(logRecord)).append(System.lineSeparator());

		Throwable thr1 = logRecord.getThrown();
		if (thr1 != null) {
			// going to the bottom of the stack
			Throwable thr2 = thr1.getCause();
			while (thr2 != null) {
				thr1 = thr2;
				thr2 = thr2.getCause();
			}
			stringBuilder.append("   ");
			stringBuilder.append(thr1).append(System.lineSeparator());
			final StackTraceElement[] stTrElem = thr1.getStackTrace();
			for (StackTraceElement stackTraceElement : stTrElem) {
				stringBuilder.append("      ");
				stringBuilder.append(stackTraceElement.toString()).append(System.lineSeparator());
			}
		}
		return stringBuilder.toString();
	}
}