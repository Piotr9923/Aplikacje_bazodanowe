package View;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JPanel {
    
    private JTable table;
    private JScrollPane scroll;
    
    
    public TablePanel() {

        this.setSize(1100, 600);
        this.setLayout(null);
      
        this.setBackground(Color.green);
        
         String[][] rec = {
            {"1", "Steve", "AUS"},
            {"2", "Virat", "IND"},
            {"3", "Kane", "NZ"},
            {"4", "David", "AUS"},
            {"5", "Ben", "ENG"},
            {"6", "Eion", "ENG"},};

        String[] header = {"Rank", "Player", "Country"};
        
        table = new JTable(rec, header);
        table.setSize(1100, 600);
        table.setGridColor(Color.black);
        table.setDefaultEditor(Object.class, null);
        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        
        scroll = new JScrollPane(table);
        
        scroll.setSize(1100, 600);
        scroll.setLocation(0, 0);
        this.add(scroll);
        
    }

}
