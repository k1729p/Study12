package kp.restful;

import static kp.Constants.GO_BACK_LABEL;
import static kp.Constants.OPTION_PANE_BACKGROUND;
import static kp.Constants.PANEL_BACKGROUND;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * The helper for Restful research.
 *
 */
public class ResearchRestfulHelper {

	/**
	 * The menu labels
	 */
	protected static final String[] MENU_ARR = { //
			"Content GET", "Boxes CRUD (Internal Client)", //
			"Boxes CRUD (External Client)", GO_BACK_LABEL//
	};

	private static final List<List<String>> report = new ArrayList<>();
	private static int number = 0;

	private static final Color DIALOG_COLOR = new ColorUIResource(152, 251, 152);
	private static final String TITLE = "RESTful Web Services using HTTP Server";
	private static final String[] HEADERS = { "No.", "Class Name", "Method Name", "Response Status", "Message" };

	private static final int[] CON_COL_WIDTH = { 25, 150, 220, 105, 465 };
	private static final Dimension CON_DIM = new Dimension(970, 115);

	private static final int[] BOX_COL_WIDTH = { 35, 120, 125, 125, 675 };
	private static final Dimension BOX_DIM = new Dimension(1085, 595);

	private static final int[] BOX_EXT_COL_WIDTH = { 35, 120, 125, 105, 240 };
	private static final Dimension BOX_EXT_DIM = new Dimension(630, 85);

	/**
	 * The constructor.
	 */
	private ResearchRestfulHelper() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Clears report.
	 * 
	 */
	public static void clearReport() {

		report.clear();
	}

	/**
	 * Sets number.
	 * 
	 * @param numberPar the number
	 */
	public static void setNumber(int numberPar) {

		number = numberPar;
	}

	/**
	 * Adds empty line to report.
	 * 
	 */
	public static void addEmptyLineToReport() {

		report.add(Arrays.asList(new String[5]));
	}

	/**
	 * Adds content to report.
	 * 
	 * @param className  the class name
	 * @param methodName the method name
	 * @param message    the message
	 */
	public static void addToReport(String className, String methodName, String message) {

		addToReport(className, methodName, "", message);
	}

	/**
	 * Adds content to report.
	 * 
	 * @param className      the class name
	 * @param methodName     the method name
	 * @param responseStatus the response status
	 * @param message        the message
	 */
	public static void addToReport(String className, String methodName, String responseStatus, String message) {

		final List<String> row = new ArrayList<>();
		row.add(String.valueOf(number));
		row.add(className);
		row.add(methodName);
		row.add(responseStatus);
		row.add(message);
		report.add(row);
	}

	/**
	 * Shows buttons.
	 * 
	 * @return the result
	 */
	public static int showButtons() {

		final Object optionPaneBackground = UIManager.get(OPTION_PANE_BACKGROUND);
		final Object panelBackground = UIManager.get(PANEL_BACKGROUND);
		UIManager.put(OPTION_PANE_BACKGROUND, DIALOG_COLOR);
		UIManager.put(PANEL_BACKGROUND, DIALOG_COLOR);
		final int result = JOptionPane.showOptionDialog(null, null, TITLE, JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, MENU_ARR, MENU_ARR[MENU_ARR.length - 1]);
		UIManager.put(OPTION_PANE_BACKGROUND, optionPaneBackground);
		UIManager.put(PANEL_BACKGROUND, panelBackground);
		return result;
	}

	/**
	 * Shows content results.
	 * 
	 */
	public static void showContentResults() {

		showResults(CON_COL_WIDTH, CON_DIM, 0);
	}

	/**
	 * Shows boxes results.
	 * 
	 */
	public static void showBoxesResults() {

		showResults(BOX_COL_WIDTH, BOX_DIM, 1);
	}

	/**
	 * Shows boxes external results.
	 * 
	 */
	public static void showBoxesExternalResults() {

		showResults(BOX_EXT_COL_WIDTH, BOX_EXT_DIM, 2);
	}

	/**
	 * Shows results.
	 * 
	 * @param colWidthArr the column width array
	 * @param dimension   the dimension
	 * @param menuIndex   the menu index
	 */
	private static void showResults(int[] colWidthArr, Dimension dimension, int menuIndex) {

		final String[][] rowData = report.stream().map(row -> row.toArray(new String[0])).toList()
				.toArray(new String[0][]);
		final JTable tableRes = new JTable(rowData, HEADERS);
		for (int i = 0; i < colWidthArr.length; i++) {
			tableRes.getColumnModel().getColumn(i).setMinWidth(colWidthArr[i]);
			tableRes.getColumnModel().getColumn(i).setMaxWidth(colWidthArr[i]);
		}
		tableRes.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		tableRes.setPreferredScrollableViewportSize(dimension);
		JOptionPane.showMessageDialog(null, new JScrollPane(tableRes), MENU_ARR[menuIndex], JOptionPane.PLAIN_MESSAGE);
	}
}