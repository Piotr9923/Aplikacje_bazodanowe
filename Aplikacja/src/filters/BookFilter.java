package filters;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mdata.MBooks;

public class BookFilter extends JPanel {

    private JLabel title, author, type, available;

    private JTextField titleTF, authorTF;

    private JComboBox typeBox, availableBox;
    
    private JButton search;
    
    private MBooks data;

    public BookFilter() {
        this.setSize(1100, 60);
        this.setLayout(null);

        this.setVisible(true);
        
        this.setBackground(Color.LIGHT_GRAY);

        initLabels();
        initTF();
        initCB();
        initButton();

    }
    
    private void initButton(){
        
        search = new JButton("Szukaj");
        search.setBounds(920, 10, 100, 30);
        this.add(search);
    }

    private void initLabels() {

        title = new JLabel("Tytuł:");
        title.setBounds(100, 15, 60, 20);
        this.add(title);

        author = new JLabel("Autor:");
        author.setBounds(270, 15, 60, 20);
        this.add(author);

        type = new JLabel("Gatunek:");
        type.setBounds(440, 15, 100, 20);
        this.add(type);

        available = new JLabel("Status:");
        available.setBounds(700, 15, 100, 20);
        this.add(available);

    }

    private void initTF() {

        titleTF = new JTextField();
        titleTF.setBounds(140, 15, 100, 20);
        this.add(titleTF);

        authorTF = new JTextField();
        authorTF.setBounds(315, 15, 100, 20);
        this.add(authorTF);

    }

    private void initCB() {

        typeBox = new JComboBox();
        typeBox.setBounds(510, 15, 180, 20);
        this.add(typeBox);
        
        typeBox.addItem("");

        availableBox = new JComboBox();
        availableBox.setBounds(760, 15, 130, 20);
        this.add(availableBox);
        
        availableBox.addItem("");
        availableBox.addItem("Dostępna");
        availableBox.addItem("Wypożyczona");
        
    }
    
    public void setData(MBooks data){
    
        this.data = data;
        
        updateComboBoxes();
    
}
    
    private void updateComboBoxes(){
        
       for(int i=0;i<data.getBookTypes().size();i++){
           
           typeBox.addItem(data.getBookTypes().get(i));
       }
        
        
    }

    public JButton getSearch() {
        return search;
    }
    
    public void filterBookList(){    
        
        String availableString="";
        if(availableBox.getSelectedItem()=="Dostępna") availableString="1";
        else if(availableBox.getSelectedItem()=="Wypożyczona") availableString="0";
        
        
        data.filter(titleTF.getText(), authorTF.getText(), typeBox.getSelectedItem().toString(), availableString);
    
    }

    
}
