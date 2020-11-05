
package Controlers;


import View.BorrowingsTable;
import View.BorrowingsTableMenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BorrowingsTableControler {
    
    
    private BorrowingsTableMenuPanel panel;
    private BorrowingsTable table;
    
    
    public BorrowingsTableControler(MainControler controler){
          
        
        controler.getView().getBorrowingsMenu().getDodaj().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }      
        });
        
        controler.getView().getBorrowingsMenu().getZwroc().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
  
            }      
        });
        
    }
    
    
}
