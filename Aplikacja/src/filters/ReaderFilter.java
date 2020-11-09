package filters;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mdata.MReaders;

public class ReaderFilter extends JPanel {

    private JLabel name, surname, town;

    private JTextField nameTF, surnameTF, townTF;

    private JButton search;

    private MReaders data;

    public ReaderFilter() {
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

        name = new JLabel("Imię:");
        name.setBounds(100, 15, 60, 20);
        this.add(name);

        surname = new JLabel("Nazwisko:");
        surname.setBounds(270, 15, 100, 20);
        this.add(surname);

        town = new JLabel("Miesjcowość:");
        town.setBounds(470, 15, 100, 20);
        this.add(town);

    }

    private void initTF() {

        nameTF = new JTextField();
        nameTF.setBounds(140, 15, 100, 20);
        this.add(nameTF);

        surnameTF = new JTextField();
        surnameTF.setBounds(345, 15, 100, 20);
        this.add(surnameTF);

        townTF = new JTextField();
        townTF.setBounds(565, 15, 100, 20);
        this.add(townTF);

    }

    public void setData(MReaders data) {

        this.data = data;

    }

    public JButton getSearch() {
        return search;
    }

    public void filterReaderList() {

        data.filter(nameTF.getText(), surnameTF.getText(), townTF.getText());

    }

}
