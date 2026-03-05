package kp.restful;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static kp.Constants.*;

/**
 * Helper class for RESTful research.
 */
public class ResearchRestfulHelper {

    /**
     * Menu labels
     */
    protected static final List<String> MENU_LIST =
            List.of("Content GET", "Boxes CRUD (Internal Client)", "Boxes CRUD (External Client)", GO_BACK_LABEL);

    private static final List<List<String>> report = new ArrayList<>();
    private static int number = 0;

    private static final Color DIALOG_COLOR = new ColorUIResource(152, 251, 152);
    private static final String TITLE = "RESTful Web Services using HTTP Server";
    private static final String[] HEADERS = {"No.", "Class Name", "Method Name", "Response Status", "Message"};

    private static final int[] CON_COL_WIDTH = {25, 150, 220, 105, 465};
    private static final Dimension CON_DIM = new Dimension(970, 115);

    private static final int[] BOX_COL_WIDTH = {35, 120, 125, 125, 675};
    private static final Dimension BOX_DIM = new Dimension(1085, 595);

    private static final int[] BOX_EXT_COL_WIDTH = {35, 120, 125, 105, 240};
    private static final Dimension BOX_EXT_DIM = new Dimension(630, 85);

    /**
     * Private constructor to prevent instantiation.
     */
    private ResearchRestfulHelper() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Clears the report.
     */
    public static void clearReport() {
        report.clear();
    }

    /**
     * Sets the number.
     *
     * @param numberPar the number to set
     */
    public static void setNumber(int numberPar) {
        number = numberPar;
    }

    /**
     * Adds an empty line to the report.
     */
    public static void addEmptyLineToReport() {
        report.add(Arrays.asList(new String[5]));
    }

    /**
     * Adds content to the report.
     *
     * @param className  the class name
     * @param methodName the method name
     * @param message    the message
     */
    public static void addToReport(String className, String methodName, String message) {
        addToReport(className, methodName, "", message);
    }

    /**
     * Adds content to the report.
     *
     * @param className      the class name
     * @param methodName     the method name
     * @param responseStatus the response status
     * @param message        the message
     */
    public static void addToReport(String className, String methodName, String responseStatus, String message) {
        report.add(List.of(String.valueOf(number), className, methodName, responseStatus, message));
    }

    /**
     * Shows the buttons and returns the selected option.
     *
     * @return the selected option
     */
    public static int showButtons() {

        final Object optionPaneBackground = UIManager.get(OPTION_PANE_BACKGROUND);
        final Object panelBackground = UIManager.get(PANEL_BACKGROUND);
        UIManager.put(OPTION_PANE_BACKGROUND, DIALOG_COLOR);
        UIManager.put(PANEL_BACKGROUND, DIALOG_COLOR);
        final int chosenOption = JOptionPane.showOptionDialog(null, null, TITLE, JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, MENU_LIST.toArray(), MENU_LIST.getLast());
        UIManager.put(OPTION_PANE_BACKGROUND, optionPaneBackground);
        UIManager.put(PANEL_BACKGROUND, panelBackground);
        return chosenOption;
    }

    /**
     * Shows content results.
     */
    public static void showContentResults() {
        showResults(CON_COL_WIDTH, CON_DIM, 0);
    }

    /**
     * Shows box results.
     */
    public static void showBoxesResults() {
        showResults(BOX_COL_WIDTH, BOX_DIM, 1);
    }

    /**
     * Shows external box results.
     */
    public static void showBoxesExternalResults() {
        showResults(BOX_EXT_COL_WIDTH, BOX_EXT_DIM, 2);
    }

    /**
     * Shows the results in a table.
     *
     * @param colWidthArr the column width array
     * @param dimension   the dimension
     * @param menuIndex   the menu index
     */
    private static void showResults(int[] colWidthArr, Dimension dimension, int menuIndex) {

        final String[][] rowData = report.stream()
                .map(row -> row.toArray(String[]::new))
                .toArray(String[][]::new);
        final JTable tableRes = new JTable(rowData, HEADERS);
        for (int i = 0; i < colWidthArr.length; i++) {
            tableRes.getColumnModel().getColumn(i).setMinWidth(colWidthArr[i]);
            tableRes.getColumnModel().getColumn(i).setMaxWidth(colWidthArr[i]);
        }
        tableRes.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        tableRes.setPreferredScrollableViewportSize(dimension);
        JOptionPane.showMessageDialog(null, new JScrollPane(tableRes), MENU_LIST.get(menuIndex),
                JOptionPane.PLAIN_MESSAGE);
    }
}