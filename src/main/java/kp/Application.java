package kp;

import java.lang.invoke.MethodHandles;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import kp.cdi.ResearchCDIStarter;
import kp.restful.ResearchRestful;
import kp.util.LoggingFormatter;
import kp.validation.ResearchValidation;

/**
 * Main application.
 *
 */
public class Application {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	private static final String[] MENU_ARR = { /*-*/
			"Validation", "CDI", "RESTful Web Services", "Exit"/*-*/
	};

	/**
	 * The constructor.
	 */
	public Application() {
		super();
	}

	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {

		Locale.setDefault(Locale.ENGLISH);
		initLogging();

		final ResearchValidation researchValidation = new ResearchValidation();
		final ResearchCDIStarter researchCDIStarter = new ResearchCDIStarter();
		final ResearchRestful researchRestful = new ResearchRestful();

		boolean loopFlag = true;
		while (loopFlag) {
			int n = JOptionPane.showOptionDialog(null, null, "Study12", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, MENU_ARR, MENU_ARR[MENU_ARR.length - 1]);
			switch (n) {
			case 0:
				researchValidation.process();
				break;
			case 1:
				researchCDIStarter.startIt();
				break;
			case 2:
				researchRestful.process();
				break;
			default:
				// exit application
				loopFlag = false;
			}
		}
		System.exit(0);
	}

	/**
	 * Initializes logging.
	 * 
	 */
	private static void initLogging() {

		Logger parentLogger = logger.getParent();
		Handler[] handlers = parentLogger.getHandlers();
		while (handlers.length == 0) {
			parentLogger = parentLogger.getParent();
			if (Objects.isNull(parentLogger)) {
				logger.severe("Logging problem: handlers not found!");
				return;
			}
			handlers = parentLogger.getHandlers();
		}
		for (Handler handler : handlers) {
			handler.setFormatter(new LoggingFormatter());
		}
	}
}