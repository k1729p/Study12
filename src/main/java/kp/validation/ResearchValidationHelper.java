package kp.validation;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static kp.Constants.*;

/**
 * A helper class for validation research.
 */
public class ResearchValidationHelper {

    /**
     * The list of menu labels.
     */
    protected static final List<String> MENU_LIST =
            List.of("Validate Item", "Validate Box of Items", "Validate Method", GO_BACK_LABEL);
    private static final Color DIALOG_COLOR = new ColorUIResource(176, 224, 230);
    private static final String[] COLUMN_NAMES = {"No.", "Validated Value"};

    /**
     * Displays the buttons and returns the user's choice.
     *
     * @return the index of the chosen option
     */
    public int showButtons() {

        final Object originalOptionPaneBackground = UIManager.get(OPTION_PANE_BACKGROUND);
        final Object originalPanelBackground = UIManager.get(PANEL_BACKGROUND);
        UIManager.put(OPTION_PANE_BACKGROUND, DIALOG_COLOR);
        UIManager.put(PANEL_BACKGROUND, DIALOG_COLOR);
        final int chosenOption = JOptionPane.showOptionDialog(null, null,
                "Bean Validation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, MENU_LIST.toArray(), MENU_LIST.getLast());
        UIManager.put(OPTION_PANE_BACKGROUND, originalOptionPaneBackground);
        UIManager.put(PANEL_BACKGROUND, originalPanelBackground);
        return chosenOption;
    }

    /**
     * Displays the validation results in a table.
     *
     * @param rowData      the data to display in the table
     * @param headersArray the column headers
     * @param colWidthArr  the column widths
     * @param dimension    the preferred size of the viewport
     * @param title        the title of the dialog
     */
    public void showValidationResults(List<String[]> rowData, String[] headersArray, int[] colWidthArr,
                                      Dimension dimension, String title) {

        final JTable resultsTable = createTable(rowData, headersArray, colWidthArr, dimension);
        JOptionPane.showMessageDialog(null, new JScrollPane(resultsTable), title, JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Displays the validation results and values to be validated in separate tabs.
     *
     * @param rowData          the data to display in the table
     * @param headersArray     the column headers
     * @param colWidthArr      the column widths
     * @param dimension        the preferred size of the viewport
     * @param title            the title of the dialog
     * @param valuesToValidate the values to be validated
     */
    public void showValidationResults(List<String[]> rowData, String[] headersArray, int[] colWidthArr,
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
     * @param dimension    the {@link Dimension}.
     * @param tabbedPane   the {@link JTabbedPane}.
     */
    private void addResultsTab(List<String[]> rowData, String[] headersArray, int[] colWidthArr,
                               Dimension dimension, JTabbedPane tabbedPane) {

        final JTable resultsTable = createTable(rowData, headersArray, colWidthArr, dimension);
        final JScrollPane scrollPane = new JScrollPane(resultsTable);
        tabbedPane.addTab("Validation Results", null, scrollPane, null);
    }

    /**
     * Adds values tab.
     *
     * @param dimension        the {@link Dimension}.
     * @param valuesToValidate the valuesToValidate
     * @param tabbedPane       the {@link JTabbedPane}.
     */
    private void addValuesTab(Dimension dimension, String[] valuesToValidate, JTabbedPane tabbedPane) {

        final List<String[]> rowData = new ArrayList<>();
        for (int i = 0; i < valuesToValidate.length; i++) {
            rowData.add(new String[]{String.valueOf(i + 1), valuesToValidate[i]});
        }
        final JTable valuesTable = createTable(rowData, COLUMN_NAMES, new int[]{50, 200}, dimension);
        final JScrollPane scrollPane = new JScrollPane(valuesTable);
        tabbedPane.addTab("Validated Values", null, scrollPane, null);
    }

    /**
     * Creates the {@link JTable}.
     *
     * @param rowData      the row data
     * @param headersArray the headers array
     * @param colWidthArr  the column width array
     * @param dimension    the {@link Dimension}.
     * @return the {@link JTable}
     */
    private JTable createTable(List<String[]> rowData, String[] headersArray, int[] colWidthArr, Dimension dimension) {

        final JTable table = new JTable(rowData.toArray(new String[0][]), headersArray);
        for (int i = 0; i < colWidthArr.length; i++) {
            table.getColumnModel().getColumn(i).setMinWidth(colWidthArr[i]);
            table.getColumnModel().getColumn(i).setMaxWidth(colWidthArr[i]);
        }
        table.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        table.setPreferredScrollableViewportSize(dimension);
        return table;
    }

}
