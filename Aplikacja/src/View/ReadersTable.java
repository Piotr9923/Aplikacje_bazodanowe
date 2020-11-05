package View;

import models.MReaders;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import iteams.Czytelnik;

public class ReadersTable extends JPanel {

    private JTable table;
    private JScrollPane scroll;

    private DefaultTableModel tableModel;

    private MReaders data;

    public ReadersTable() {

        this.setSize(1100, 600);
        this.setLayout(null);

        this.setBackground(Color.green);

        String[] headers = {"ID", "Imię", "Nazwisko", "Nr telefonu", "Adres", "Rok urodzenia"};
        tableModel = new DefaultTableModel(headers, 0);

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

    }

    public void updateTable() {

        for (int i = 0; i < data.getReaders().size(); i++) {
            
            Czytelnik czytelnik = data.getReaders().get(i);
            
            Object[] objs = {czytelnik.getId(), czytelnik.getImie(), czytelnik.getNazwisko(),
                czytelnik.getNrTelefonu(), czytelnik.getAdres().adresToString(), czytelnik.getRokUrodzenia()};

            tableModel.addRow(objs);
        }

    }

    public void setData(MReaders data) {
        this.data = data;
    }

    public void removeRow() {
        System.out.println(table.getValueAt(table.getSelectedRow(), 0));
        if (table.getSelectedRow() >= 0) {
            tableModel.removeRow(table.getSelectedRow());
        }

    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

}
