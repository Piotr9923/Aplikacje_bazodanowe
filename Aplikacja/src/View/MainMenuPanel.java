package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {

    private JButton ksiazki, czytelnicy, wyjscie, raporty;

    public MainMenuPanel(int width) {

        
        this.setSize(1366, 60);
        this.setLayout(null);
        ksiazki = new JButton("Książki");
        ksiazki.setBounds(50, 10, 100, 40);
        this.add(ksiazki);
        this.setBackground(Color.gray);
        
        czytelnicy = new JButton("Czytelnicy");
        czytelnicy.setBounds(200, 10, 120, 40);
        this.add(czytelnicy);
        
        raporty = new JButton("Raporty");
        raporty.setBounds(370, 10, 120, 40);
        this.add(raporty);
        
        wyjscie = new JButton("Wyjście");
        wyjscie.setBounds(1150, 10, 100, 40);
        wyjscie.setBackground(Color.RED);
        this.add(wyjscie);

    }

    public JButton getRaporty() {
        return raporty;
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
