package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BorrowingsTableMenuPanel extends JPanel {

    private JButton dodaj, zwroc;

    public BorrowingsTableMenuPanel() {

        this.setSize(200, 700);
        this.setLayout(null);
        dodaj = new JButton("Dodaj");
        dodaj.setBounds(50, 50, 100, 40);
        this.add(dodaj);
        
        zwroc = new JButton("Zwróć");
        zwroc.setBounds(50, 150, 100, 40);
        this.add(zwroc);
        
        
        this.setBackground(Color.darkGray);   

    }

    public JButton getZwroc() {
        return zwroc;
    }

    public JButton getDodaj() {
        return dodaj;
    }
    
    

}
