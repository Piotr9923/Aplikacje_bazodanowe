
package Controlers;

import models.MReaders;
import View.BooksTableMenuPanel;
import View.BooksTable;
import View.ReadersTable;
import View.ReadersTableMenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReadersTableControler {
    
    
    private ReadersTableMenuPanel panel;
    private ReadersTable table;
    private MReaders mReaders;
    
    public ReadersTableControler(MainControler controler){
                
        mReaders = new MReaders();
     
        table=controler.getView().getReaders();
        table.setData(mReaders);
        
        table.updateTable();

        
        controler.getView().getReadersMenu().getDodaj().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }      
        });
        
        controler.getView().getReadersMenu().getUsun().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
  
            }      
        });
        
    }
    
}
