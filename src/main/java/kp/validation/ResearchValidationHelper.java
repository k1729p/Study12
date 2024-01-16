package kp.validation;

import static kp.Constants.GO_BACK_LABEL;
import static kp.Constants.OPTION_PANE_BACKGROUND;
import static kp.Constants.PANEL_BACKGROUND;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * The validation research helper.
 *
 */
public class ResearchValidationHelper {

	/**
	 * The menu labels.
	 */
	protected static final String[] MENU_ARR = { /*-*/
			"Validate Item", "Validate Box of Items", /*-*/
			"Validate Method", GO_BACK_LABEL/*-*/
	};
	private static final Color DIALOG_COLOR = new ColorUIResource(176, 224, 230);
	private static final String[] COLUMN_NAMES = new String[] { "No.", "Validated Value" };

	/**
	 * The constructor.
	 */
	public ResearchValidationHelper() {
		super();
	}

	/**
	 * Shows buttons.
	 * 
	 * @return the result
	 */
	public int showButtons() {

		final Object optionPaneBackground = UIManager.get(OPTION_PANE_BACKGROUND);
		final Object panelBackground = UIManager.get(PANEL_BACKGROUND);
		UIManager.put(OPTION_PANE_BACKGROUND, DIALOG_COLOR);
		UIManager.put(PANEL_BACKGROUND, DIALOG_COLOR);
		final int result = JOptionPane.showOptionDialog(null, null, "Bean Validation", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, MENU_ARR, MENU_ARR[MENU_ARR.length - 1]);
		UIManager.put(OPTION_PANE_BACKGROUND, optionPaneBackground);
		UIManager.put(PANEL_BACKGROUND, panelBackground);
		return result;
	}

	/**
	 * Shows validate results.
	 * 
	 * @param rowData      the rowData
	 * @param headersArray the headersArray
	 * @param colWidthArr  the colWidthArr
	 * @param dimension    the dimension
	 * @param title        the title
	 */
	public void showValidateResults(List<String[]> rowData, String[] headersArray, int[] colWidthArr,
			Dimension dimension, String title) {

		final JTable tableRes = new JTable(rowData.toArray(new String[0][]), headersArray);
		for (int i = 0; i < colWidthArr.length; i++) {
			tableRes.getColumnModel().getColumn(i).setMinWidth(colWidthArr[i]);
			tableRes.getColumnModel().getColumn(i).setMaxWidth(colWidthArr[i]);
		}
		tableRes.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		tableRes.setPreferredScrollableViewportSize(dimension);
		JOptionPane.showMessageDialog(null, new JScrollPane(tableRes), title, JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Shows validate results.
	 * 
	 * @param rowData          the rowData
	 * @param headersArray     the headersArray
	 * @param colWidthArr      the colWidthArr
	 * @param dimension        the dimension
	 * @param title            the title
	 * @param valuesToValidate the valuesToValidate
	 */
	public void showValidateResults(List<String[]> rowData, String[] headersArray, int[] colWidthArr,
			Dimension dimension, String title, String[] valuesToValidate) {

		final JTabbedPane tabbedPane = new JTabbedPane();
		addResultsTab(rowData, headersArray, colWidthArr, dimension, tabbedPane);
		addValuesTab(dimension, valuesToValidate, tabbedPane);
		JOptionPane.showMessageDialog(null, tabbedPane, title, JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Adds results tab.
	 * 
	 * @param rowData      the rowData
	 * @param headersArray the headersArray
	 * @param colWidthArr  the colWidthArr
	 * @param dimension    the dimension
	 * @param tabbedPane   the tabbedPane
	 */
	private void addResultsTab(List<String[]> rowData, String[] headersArray, int[] colWidthArr, Dimension dimension,
			JTabbedPane tabbedPane) {

		final JTable tableRes = new JTable(rowData.toArray(new String[0][]), headersArray);
		for (int i = 0; i < colWidthArr.length; i++) {
			tableRes.getColumnModel().getColumn(i).setMinWidth(colWidthArr[i]);
			tableRes.getColumnModel().getColumn(i).setMaxWidth(colWidthArr[i]);
		}
		tableRes.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		tableRes.setPreferredScrollableViewportSize(dimension);
		final JScrollPane scrollPaneRes = new JScrollPane(tableRes);
		tabbedPane.addTab("Validation Results", null, scrollPaneRes, null);
	}

	/**
	 * Adds values tab.
	 * 
	 * @param dimension        the dimension
	 * @param valuesToValidate the valuesToValidate
	 * @param tabbedPane       the tabbedPane
	 */
	private void addValuesTab(Dimension dimension, String[] valuesToValidate, JTabbedPane tabbedPane) {

		final List<String[]> rowValData = new ArrayList<>();
		int number = 1;
		for (String val : valuesToValidate) {
			rowValData.add(new String[] { String.valueOf(number++), val });
		}
		final JTable tableVal = new JTable(rowValData.toArray(new String[0][]), COLUMN_NAMES);
		tableVal.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		tableVal.setPreferredScrollableViewportSize(dimension);
		final JScrollPane scrollPaneVal = new JScrollPane(tableVal);
		tabbedPane.addTab("Validated Values", null, scrollPaneVal, null);
	}
}
