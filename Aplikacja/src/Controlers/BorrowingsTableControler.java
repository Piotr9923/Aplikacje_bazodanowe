
package Controlers;


import View.BorrowingsTable;
import View.BorrowingsTableMenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.MBorrowing;


public class BorrowingsTableControler {
    
    
    private BorrowingsTableMenuPanel panel;
    private BorrowingsTable table;
    private MBorrowing mBorrowing;
    
    public BorrowingsTableControler(MainControler controler){
          
        
        mBorrowing = new MBorrowing();
        
        table=controler.getView().getBorrowings();
        table.setData(mBorrowing);
        
        table.updateTable();
        
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
