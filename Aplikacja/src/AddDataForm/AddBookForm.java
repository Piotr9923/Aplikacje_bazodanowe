package AddDataForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mdata.MBooks;

public class AddBookForm {

    private JFrame frame;

    private JLabel title, authorName, authorSurname, type, author;

    private JTextField titleTF, authorNameTF, authorSurnameTF, typeTF;

    private JButton save, cancel;

    private JComboBox authorBox;

    private MBooks data;

    public AddBookForm(MBooks data) {

        frame = new JFrame();

        frame.setTitle("Dodaj książkę");
        frame.setSize(220, 400);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setLayout(null);

        this.data = data;

        createLabels();

        createTextFields();

        createButtons();

        createComboBox();

    }

    private void createComboBox() {

        authorBox = new JComboBox();
        authorBox.setBounds(10, 130, 200, 20);
        frame.add(authorBox);

        updateComboBox();

        authorBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if (authorBox.getSelectedItem() == "Inny") {

                    authorSurname.setVisible(true);
                    authorName.setVisible(true);

                    authorSurnameTF.setVisible(true);
                    authorNameTF.setVisible(true);

                } else {
                    authorSurname.setVisible(false);
                    authorName.setVisible(false);

                    authorSurnameTF.setVisible(false);
                    authorNameTF.setVisible(false);
                }
            }

        });

    }
    
    private void updateComboBox(){
        
        authorBox.removeAllItems();
        
        for (int i = 0; i < data.getAuthors().size(); i++) {

            authorBox.addItem(data.getAuthors().get(i).getAuthor());
        }

        authorBox.addItem("Inny");
        
    }

    private void createButtons() {

        save = new JButton("Dodaj");
        save.setBounds(125, 325, 85, 30);
        frame.add(save);

        cancel = new JButton("Anuluj");
        cancel.setBounds(10, 325, 85, 30);
        frame.add(cancel);

    }

    public JButton getSave() {
        return save;
    }

    public JButton getCancel() {
        return cancel;
    }

    private void createLabels() {

        title = new JLabel("Tytuł:");
        title.setBounds(10, 10, 100, 20);
        frame.add(title);

        type = new JLabel("Gatunek:");
        type.setBounds(10, 60, 200, 20);
        frame.add(type);

        author = new JLabel("Autor:");
        author.setBounds(10, 110, 100, 20);
        frame.add(author);

        authorName = new JLabel("Imię autora:");
        authorName.setBounds(10, 160, 100, 20);
        frame.add(authorName);
        authorName.setVisible(false);

        authorSurname = new JLabel("Nazwisko autora:");
        authorSurname.setBounds(10, 210, 200, 20);
        frame.add(authorSurname);
        authorSurname.setVisible(false);

    }

    private void createTextFields() {

        titleTF = new JTextField();
        titleTF.setBounds(10, 30, 200, 20);
        frame.add(titleTF);

        typeTF = new JTextField();
        typeTF.setBounds(10, 80, 200, 20);
        frame.add(typeTF);

        authorNameTF = new JTextField();
        authorNameTF.setBounds(10, 180, 200, 20);
        frame.add(authorNameTF);
        authorNameTF.setVisible(false);

        authorSurnameTF = new JTextField();
        authorSurnameTF.setBounds(10, 230, 200, 20);
        frame.add(authorSurnameTF);
        authorSurnameTF.setVisible(false);

    }

    public void show() {

        updateComboBox();
        frame.show();

    }

    public void hide() {

        frame.hide();
        clearFields();
    }

    private void clearFields() {

        titleTF.setText("");
        authorNameTF.setText("");
        authorSurnameTF.setText("");
        typeTF.setText("");

    }

    public void addBook() {

        if (authorBox.getSelectedItem() == "Inny") {
            
            String[] bookData = {titleTF.getText(), authorNameTF.getText(), authorSurnameTF.getText(), typeTF.getText()};

            data.addNewBook(bookData);
            
        } else {
            
            int authorID = authorBox.getSelectedIndex();
            
            String[] bookData = {titleTF.getText(), typeTF.getText()};
            
            data.addNewBook(bookData,authorID);

        }

    }
}
