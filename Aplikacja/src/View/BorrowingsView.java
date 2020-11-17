package View;

import filters.BookFilter;
import filters.BorrowingFilter;


public class BorrowingsView {

    private BorrowingsTable table;
    private BorrowingsTableMenuPanel menuPanel;
    private BorrowingFilter filter;
    
    public BorrowingsView(){
        
        table = new BorrowingsTable();
        menuPanel = new BorrowingsTableMenuPanel();
        filter = new BorrowingFilter();
        
        filter.setLocation(0, 60);
        table.setLocation(0, 120);
        menuPanel.setLocation(1100, 60);
        
    }

    public BorrowingsTable getTable() {
        return table;
    }

    public BorrowingsTableMenuPanel getMenuPanel() {
        return menuPanel;
    }

    public BorrowingFilter getFilter() {
        return filter;
    }
    
}
