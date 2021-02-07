package view;

import filters.BookFilter;


public class BooksView {

    private BooksTable table;
    private BooksTableMenuPanel menuPanel;
    private BookFilter filter;
    
    public BooksView(){
        
        table = new BooksTable();
        menuPanel = new BooksTableMenuPanel();
        filter = new BookFilter();
        
        filter.setLocation(0, 60);
        table.setLocation(0, 120);
        menuPanel.setLocation(1100, 60);
        
    }

    public BooksTable getTable() {
        return table;
    }

    public BooksTableMenuPanel getMenuPanel() {
        return menuPanel;
    }

    public BookFilter getFilter() {
        return filter;
    }
    
}
