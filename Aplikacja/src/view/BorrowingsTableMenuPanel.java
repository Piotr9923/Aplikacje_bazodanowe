package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BorrowingsTableMenuPanel extends JPanel {

    private JButton addButton, returnButton;

    public BorrowingsTableMenuPanel() {

        this.setSize(200, 700);
        this.setLayout(null);
        addButton = new JButton("Dodaj");
        addButton.setBackground(Color.green);

        addButton.setBounds(50, 50, 100, 40);
        this.add(addButton);

        returnButton = new JButton("Zwróć");
        returnButton.setBounds(50, 150, 100, 40);
                returnButton.setBackground(Color.cyan);

        this.add(returnButton);

        this.setBackground(Color.darkGray);

    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

}
