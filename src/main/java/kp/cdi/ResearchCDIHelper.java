package kp.cdi;

import jakarta.inject.Inject;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.List;

import static kp.Constants.*;

/**
 * Helper for CDI research.
 */
public class ResearchCDIHelper {
    /**
     * Menu labels.
     */
    protected static final List<String> MENU_LIST =
            List.of("Alternative & Qualified Beans", "Decorated Beans", "Intercepted Beans", "Events", GO_BACK_LABEL);

    private final List<List<String>> report;

    private static final Color DIALOG_COLOR = new ColorUIResource(255, 228, 225);
    private static final String TITLE = "CDI using Weld SE Container";
    private static final String[] HEADERS = {"Class Name", "Method Name", "Message"};
    private static final int[] COL_WIDTH = {200, 160, 475};
    private static final Dimension DIM = new Dimension(840, 120);

    /**
     * Parameterized constructor.
     *
     * @param report the report list
     */
    @Inject
    public ResearchCDIHelper(List<List<String>> report) {
        this.report = report;
    }

    /**
     * Shows buttons.
     *
     * @return the chosen option
     */
    public int showButtons() {

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
     * Shows results.
     *
     * @param title the title
     */
    public void showResults(String title) {

        final String[][] rowData = report.stream()
                .map(row -> row.toArray(new String[0])).toArray(String[][]::new);
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