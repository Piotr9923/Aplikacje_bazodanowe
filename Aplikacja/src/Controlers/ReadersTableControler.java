
package Controlers;

import AddDataForm.AddReaderForm;
import mdata.MReaders;
import View.ReadersTable;
import View.ReadersTableMenuPanel;
import filters.ReaderFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReadersTableControler {
    
    
    private ReadersTableMenuPanel panel;
    private ReadersTable table;
    private MReaders mReaders;
    private AddReaderForm form;
    
    private ReaderFilter readerFilter;
    
    
    public ReadersTableControler(MainControler controler){
                
        mReaders = new MReaders();
     
        table=controler.getView().getReaders();
        table.setData(mReaders);
        
        table.updateTable();
        
        form = new AddReaderForm(mReaders);
        
        readerFilter = controler.getView().getReaderFilter();
        readerFilter.setData(mReaders);
        
        controler.getView().getReaderFilter().getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                readerFilter.filterReaderList();
                table.updateTable();
            }
        });

        
        controler.getView().getReadersMenu().getDodaj().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                form.show();
                
            }      
        });
        
        controler.getView().getReadersMenu().getUsun().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                table.removeReader();
                mReaders.updateReadersList();
                table.updateTable();
  
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
