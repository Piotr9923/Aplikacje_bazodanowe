
package Controlers;

import View.BooksTableMenuPanel;
import View.BooksTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.MBooks;


public class BooksTableControler {
    
    
    private BooksTableMenuPanel panel;
    private BooksTable table;
    private MBooks mBooks;
    
    
    public BooksTableControler(MainControler controler){
        
        mBooks = new MBooks();
        
        table=controler.getView().getBooks();
        table.setData(mBooks);
        
        table.updateTable();
          
        
        controler.getView().getBooksMenu().getDodaj().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                mBooks.updateBooksList();
                table.updateTable();
                
            }      
        });
        
        controler.getView().getBooksMenu().getUsun().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
  
            }      
        });
        
    }
    
    
}
