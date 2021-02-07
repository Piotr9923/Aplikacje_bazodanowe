
package controlers;

import addformdata.AddReaderForm;
import mdata.MReaders;
import view.ReadersTable;
import view.ReadersTableMenuPanel;
import view.ReadersView;
import filters.ReaderFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReadersTableControler {
    
    
    private ReadersTableMenuPanel panel;
    private ReadersTable table;
    private MReaders mReaders;
    private AddReaderForm form;
    
    private ReaderFilter readerFilter;
    
    private ReadersView view;
    
    
    public ReadersTableControler(MainControler controler){
                
        mReaders = new MReaders();
        
        view = controler.getView().getReadersView();
     
        table = view.getTable();
        table.setData(mReaders);
        
        table.updateTable();
        
        form = new AddReaderForm(mReaders);
        
        readerFilter = view.getFilter();
        readerFilter.setData(mReaders);
        
        view.getFilter().getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                readerFilter.filterReaderList();
                table.updateTable();
            }
        });

        
        view.getMenuPanel().getAddButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                form.show();
                
            }      
        });
        
        view.getMenuPanel().getRemoveButton().addActionListener(new ActionListener(){
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
