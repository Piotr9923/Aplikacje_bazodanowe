package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RaportsWindow extends JPanel {

    private JButton readersRanking, tooLongBorrowing;

    public RaportsWindow() {

        this.setSize(1100, 600);
        this.setLayout(null);

        this.setVisible(true);

        readersRanking = new JButton("Ranking czytelnictwa");
        readersRanking.setBounds(425, 0, 250, 50);
        readersRanking.setBackground(Color.yellow);
        this.add(readersRanking);

        tooLongBorrowing = new JButton("Zbyt długie wypożyczenia");
        tooLongBorrowing.setBounds(425, 110, 250, 50);
        tooLongBorrowing.setBackground(Color.yellow);
        this.add(tooLongBorrowing);

    }

    public JButton getReadersRanking() {
        return readersRanking;
    }

    public JButton getTooLongBorrowing() {
        return tooLongBorrowing;
    }

    
}
