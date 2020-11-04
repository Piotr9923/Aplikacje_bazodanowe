/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Użytkownik
 */
public class TableView {
    
    public TableView(){
        
        
        
         JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createTitledBorder(
      BorderFactory.createEtchedBorder(), "ODI Rankings", TitledBorder.CENTER, TitledBorder.TOP));
      String[][] rec = {
         { "1", "Steve", "AUS" },
         { "2", "Virat", "IND" },
         { "3", "Kane", "NZ" },
         { "4", "David", "AUS" },
         { "5", "Ben", "ENG" },
         { "6", "Eion", "ENG" },
      };

      String[] header = { "Rank", "Player", "Country" };
      JTable table = new JTable(rec, header);
      table.setShowHorizontalLines(true);
      table.setGridColor(Color.orange);
      table.setRowSelectionAllowed(true);
      table.getTableHeader().setReorderingAllowed(false);
      
      
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      panel.add(new JScrollPane(table));
      frame.add(panel);
      frame.setSize(550, 400);
      frame.setVisible(true);
      
    }
    
}