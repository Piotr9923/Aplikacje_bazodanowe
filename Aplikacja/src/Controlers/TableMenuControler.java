
package Controlers;

import View.TableMenuPanel;
import View.TablePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TableMenuControler {
    
    
    private TableMenuPanel panel;
    private TablePanel table;
    
    
    public TableMenuControler(MainControler controler){
          
        
        controler.getView().getTableMenuPanel().getDodaj().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                controler.getView().getTable().addRow();
            }      
        });
        
        controler.getView().getTableMenuPanel().getUsun().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                controler.getView().getTable().removeRow();
            }      
        });
        
    }
    
    
}
