package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    private JButton ksiazki, czytelnicy, wyjscie;

    public MenuPanel(int width) {

        
        this.setSize(1366, 60);
        this.setLayout(null);
        ksiazki = new JButton("Książki");
        ksiazki.setBounds(50, 10, 100, 40);
        this.add(ksiazki);
        this.setBackground(Color.gray);
        
        czytelnicy = new JButton("Czytelnicy");
        czytelnicy.setBounds(200, 10, 120, 40);
        this.add(czytelnicy);
        
        wyjscie = new JButton("Wyjście");
        wyjscie.setBounds(1150, 10, 100, 40);
        wyjscie.setBackground(Color.RED);
        this.add(wyjscie);

    }

    public JButton getKsiazki() {
        return ksiazki;
    }

    public JButton getCzytelnicy() {
        return czytelnicy;
    }

    public JButton getWyjscie() {
        return wyjscie;
    }

    
    
    
}
