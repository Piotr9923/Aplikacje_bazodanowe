package view;

import filters.BookFilter;


public class RaportsView {

    private RaportsWindow window;
    private RaportsMenuPanel menuPanel;
    
    public RaportsView(){
        
        window = new RaportsWindow();
        menuPanel = new RaportsMenuPanel();
        
        window.setLocation(0, 120);
        menuPanel.setLocation(1100, 60);
        
    }

    public RaportsWindow getWindow() {
        return window;
    }

    public RaportsMenuPanel getMenuPanel() {
        return menuPanel;
    }


}
