package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {

    private JFrame frame;
    private MainMenuPanel menu;
    private TableMenuPanel tableMenu;
    private TablePanel table, actualTable, table2;
    
    

    public MainView() {
        frame = new JFrame();

        frame.setTitle("Biblioteka");
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
        
        menu = new MainMenuPanel();

        frame.getContentPane().setLayout(null);

        frame.add(menu);
        
        initTableMenu();
        
        initTable();

    }
    
    private void initTable(){
        
        String[] headers = {"aa","bb","cc"};
        
        table = new TablePanel(headers);
        table.setLocation(0, 120);
        
        
        String []head={"zz","xx","yy","bb"};
        table2 = new TablePanel(head);
        table2.setLocation(0, 120);
    
        actualTable = table;
        
        
        frame.add(actualTable);
        
    }
    
    
    private void initTableMenu(){
        
        tableMenu = new TableMenuPanel();
        
        tableMenu.setLocation(1100, 60);
        
        frame.add(tableMenu);
    }

    public TableMenuPanel getTableMenuPanel() {
        return tableMenu;
    }

    public TablePanel getTable() {
        return actualTable;
    }
    
    

    public MainMenuPanel getMainMenuPanel(){
        
        return menu;
    }
    
    public void showBookWindow(){
        
         frame.remove(actualTable);
        actualTable = table2;
        
        frame.add(actualTable);
    
        
    }
    
    public void showReaderWindow(){
        
         frame.remove(actualTable);
        actualTable = table;
        
        frame.add(actualTable);
        
        
    }
    
    public void showRaportWindow(){
        


        
    }
    
    

}
