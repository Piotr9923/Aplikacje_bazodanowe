package View;

import iteams.Wypozyczenie;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import models.MBorrowing;

public class BorrowingsTable extends JPanel{

    private JTable table;
    private JScrollPane scroll;

    private DefaultTableModel tableModel;
    
    private MBorrowing data;

    public BorrowingsTable() {

        this.setSize(1100, 600);
        this.setLayout(null);

        this.setBackground(Color.green);
        
        String[]headers={"ID","ID wypożyczającego", "Wypożyczający","ID książki", "Tytuł książki", "Data wypożyczenia"};
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
        
        
         for(int i=tableModel.getRowCount()-1;i>=0;i--){
            
            tableModel.removeRow(i);
        }
        
        for (int i = 0; i < data.getBorrowings().size(); i++) {
            
            Wypozyczenie borrwoing = data.getBorrowings().get(i);
            
            Object[] objs = {borrwoing.getId(),borrwoing.getIdCzytelnika(), (borrwoing.getImieCzytelnika()+" "+borrwoing.getNazwiskoCzytelnika()),
                borrwoing.getIdKsiazki(),borrwoing.getTytul(),borrwoing.getDataWypozyczenia()
            };
            tableModel.addRow(objs);
        }

    }
    
    
    public void setData(MBorrowing data){
        
        this.data = data;
    }


    public DefaultTableModel getTableModel() {
        return tableModel;
    }

}
