
package Controlers;

import AddDataForm.AddReaderForm;
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
    private AddReaderForm form;
    
    
    public ReadersTableControler(MainControler controler){
                
        mReaders = new MReaders();
     
        table=controler.getView().getReaders();
        table.setData(mReaders);
        
        table.updateTable();
        
        form = new AddReaderForm(mReaders);

        
        controler.getView().getReadersMenu().getDodaj().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                form.show();
                
            }      
        });
        
        controler.getView().getReadersMenu().getUsun().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
  
            }      
        });
        
        form.getSave().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                form.addReader();
                form.hide();
                mReaders.updateReadersList();
                table.updateTable();
  
            }      
        });
                
         form.getCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                form.hide();
  
            }      
        });
                
                
    }

    public MReaders getmReaders() {
        return mReaders;
    }
    
     public void updateTable(){
         mReaders.updateReadersList();
        table.updateTable();
    }
    
    
}
