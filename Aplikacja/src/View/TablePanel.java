package View;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel {

    private JTable table;
    private JScrollPane scroll;

    private DefaultTableModel tableModel;

    public TablePanel(String[] header) {

        this.setSize(1100, 600);
        this.setLayout(null);

        this.setBackground(Color.green);

        tableModel = new DefaultTableModel(header, 0);

        table = new JTable(tableModel);
        table.setSize(1100, 600);
        table.setGridColor(Color.black);
        table.setDefaultEditor(Object.class, null);
        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scroll = new JScrollPane(table);

        scroll.setSize(1100, 600);
        scroll.setLocation(0, 0);
        this.add(scroll);

        addRow();
        addRow();

    }

    public void addRow() {

        Object[] objs = {1, "FCBARCA", 35};

        tableModel.addRow(objs);
    }

    public void removeRow() {
        if (table.getSelectedRow() >= 0) {
            tableModel.removeRow(table.getSelectedRow());
        }
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

}
