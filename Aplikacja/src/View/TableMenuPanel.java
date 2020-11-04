
package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class TableMenuPanel extends JPanel{
    
    private JButton ksiazki, czytelnicy, wypozyczenia, raporty;

    public TableMenuPanel() {

        
        this.setSize(200, 700);
        this.setLayout(null);
        ksiazki = new JButton("Książki");
        ksiazki.setBounds(50, 50, 100, 40);
        this.add(ksiazki);
        this.setBackground(Color.darkGray);
        
        czytelnicy = new JButton("Czytelnicy");
            czytelnicy.setBounds(50, 150, 120, 40);
        this.add(czytelnicy);
        
        raporty = new JButton("Raporty");
        raporty.setBounds(50, 250, 120, 40);
        this.add(raporty);
        
        wypozyczenia = new JButton("Wypożyczenia");
        wypozyczenia.setBounds(50, 350, 140, 40);
        this.add(wypozyczenia);
        

    }
    
}
