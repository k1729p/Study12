package kp.cdi;

import static kp.Constants.GO_BACK_LABEL;
import static kp.Constants.OPTION_PANE_BACKGROUND;
import static kp.Constants.PANEL_BACKGROUND;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import jakarta.inject.Inject;

/**
 * The helper for CDI research.
 *
 */
public class ResearchCDIHelper {

	/**
	 * The menu labels.
	 */
	protected static final String[] MENU_ARR = { /*-*/
			"Alternative & Qualified Beans", "Decorated Beans", /*-*/
			"Intercepted Beans", "Events", GO_BACK_LABEL/*-*/
	};

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	private static final Color DIALOG_COLOR = new ColorUIResource(255, 228, 225);
	private static final String TITLE = "CDI using Weld SE Container";
	private static final String[] HEADERS = { "Class Name", "Method Name", "Message" };
	private static final int[] COL_WIDTH = { 200, 160, 475 };
	private static final Dimension DIM = new Dimension(840, 120);

	/**
	 * The constructor.
	 */
	public ResearchCDIHelper() {
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
		final int result = JOptionPane.showOptionDialog(null, null, TITLE, JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, MENU_ARR, MENU_ARR[MENU_ARR.length - 1]);
		UIManager.put(OPTION_PANE_BACKGROUND, optionPaneBackground);
		UIManager.put(PANEL_BACKGROUND, panelBackground);
		return result;
	}

	/**
	 * Shows results.
	 * 
	 * @param title the title
	 */
	public void showResults(String title) {

		final String[][] rowData = report.stream().map(row -> row.toArray(new String[0])).toList()
				.toArray(new String[0][]);
		final JTable tableRes = new JTable(rowData, HEADERS);
		for (int i = 0; i < COL_WIDTH.length; i++) {
			tableRes.getColumnModel().getColumn(i).setMinWidth(COL_WIDTH[i]);
			tableRes.getColumnModel().getColumn(i).setMaxWidth(COL_WIDTH[i]);
		}
		tableRes.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		tableRes.setPreferredScrollableViewportSize(DIM);
		JOptionPane.showMessageDialog(null, new JScrollPane(tableRes), title, JOptionPane.PLAIN_MESSAGE);
	}
}