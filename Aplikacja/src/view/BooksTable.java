package view;

import model.Book;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import mdata.MBooks;

public class BooksTable extends JPanel{

    private JTable table;
    private JScrollPane scroll;

    private DefaultTableModel tableModel;
    
    private MBooks data;

    public BooksTable() {

        this.setSize(1100, 600);
        this.setLayout(null);
        
        String[]headers={"ID","Tytuł","Autor","Gatunek","Status książki"};
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
        
        for (int i = 0; i < data.getBooks().size(); i++) {
            
            Book book = data.getBooks().get(i);
            String status = "Dostępna";
            if(book.isAvailable()==false) status="Wypożyczona";
            
            
            Object[] objs = {book.getId(),book.getTitle(),book.getAuthor(),book.getType(),status};
            tableModel.addRow(objs);
        }

    }
    
    public void setData(MBooks data){
        this.data = data;
    }
 
    public void removeBook(){
        
       int bookId = (int) table.getValueAt(table.getSelectedRow(), 0);
       
       data.deleteBook(bookId);
        
    }


    public DefaultTableModel getTableModel() {
        return tableModel;
    }

}
