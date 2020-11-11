package filters;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mdata.MBorrowing;
import mdata.MReaders;

public class BorrowingFilter extends JPanel {

    private JLabel name, title;

    private JTextField nameTF, titleTF;

    private JButton search;

    private MBorrowing data;

    public BorrowingFilter() {
        this.setSize(1100, 60);
        this.setLayout(null);

        this.setVisible(true);
        
        this.setBackground(Color.LIGHT_GRAY);

        initLabels();
        initTF();
        initButton();

    }

    private void initButton() {

        search = new JButton("Szukaj");
        search.setBounds(740, 10, 100, 30);
        this.add(search);
    }

    private void initLabels() {

        name = new JLabel("Wypożyczający:");
        name.setBounds(275, 15, 150, 20);
        this.add(name);

        title = new JLabel("Tytuł:");
        title.setBounds(530, 15, 100, 20);
        this.add(title);

    }

    private void initTF() {

        nameTF = new JTextField();
        nameTF.setBounds(390, 15, 100, 20);
        this.add(nameTF);

        titleTF = new JTextField();
        titleTF.setBounds(575, 15, 100, 20);
        this.add(titleTF);

    }

    public void setData(MBorrowing data) {

        this.data = data;

    }

    public JButton getSearch() {
        return search;
    }

    public void filterBorrowingBook() {

        data.filter(nameTF.getText(), titleTF.getText());

    }

}
