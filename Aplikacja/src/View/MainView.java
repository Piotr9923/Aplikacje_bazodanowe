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
    private TablePanel table;
    
    

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
    
        frame.add(table);
        
        System.out.println(frame.getComponents().toString());
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
        return table;
    }
    
    

    public MainMenuPanel getMainMenuPanel(){
        
        return menu;
    }
    
    public void showBookWindow(){
    
        
    }
    
    public void showReaderWindow(){
        
        
    }
    
    public void showRaportWindow(){
        


        
    }
    
    

}
