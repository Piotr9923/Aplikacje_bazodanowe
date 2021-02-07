package view;

import filters.ReaderFilter;


public class ReadersView {

    private ReadersTable table;
    private ReadersTableMenuPanel menuPanel;
    private ReaderFilter filter;
    
    public ReadersView(){
        
        table = new ReadersTable();
        menuPanel = new ReadersTableMenuPanel();
        filter = new ReaderFilter();
        
        filter.setLocation(0, 60);
        table.setLocation(0, 120);
        menuPanel.setLocation(1100, 60);
        
    }

    public ReadersTable getTable() {
        return table;
    }

    public ReadersTableMenuPanel getMenuPanel() {
        return menuPanel;
    }

    public ReaderFilter getFilter() {
        return filter;
    }
    
  
    
    

    
}
