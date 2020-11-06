package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BooksTableMenuPanel extends JPanel {

    private JButton add, remove;

    public BooksTableMenuPanel() {

        this.setSize(200, 700);
        this.setLayout(null);
        add = new JButton("Dodaj");
        add.setBounds(50, 50, 100, 40);
        add.setBackground(Color.green);
        this.add(add);
        
        remove = new JButton("Usuń");
        remove.setBounds(50, 150, 100, 40);
        remove.setBackground(Color.yellow);
        this.add(remove);
        
        
        this.setBackground(Color.darkGray);
        
        

    }

    public JButton getRemoveButton() {
        return remove;
    }

    public JButton getAddButton() {
        return add;
    }
    
    

}
