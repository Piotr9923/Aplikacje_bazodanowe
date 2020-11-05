package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TableMenuPanel extends JPanel {

    private JButton dodaj, usun;

    public TableMenuPanel() {

        this.setSize(200, 700);
        this.setLayout(null);
        dodaj = new JButton("Dodaj");
        dodaj.setBounds(50, 50, 100, 40);
        this.add(dodaj);
        
        usun = new JButton("Usuń");
        usun.setBounds(50, 150, 100, 40);
        this.add(usun);
        
        
        this.setBackground(Color.darkGray);
        
        

    }

    public JButton getUsun() {
        return usun;
    }

    public JButton getDodaj() {
        return dodaj;
    }
    
    

}
