
package Controlers;

import View.BooksTableMenuPanel;
import View.BooksTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BooksTableControler {
    
    
    private BooksTableMenuPanel panel;
    private BooksTable table;
    
    
    public BooksTableControler(MainControler controler){
          
        
        controler.getView().getBooksMenu().getDodaj().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }      
        });
        
        controler.getView().getBooksMenu().getUsun().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
  
            }      
        });
        
    }
    
    
}
