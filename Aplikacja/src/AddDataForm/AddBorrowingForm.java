package AddDataForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import models.MBooks;
import models.MBorrowing;
import models.MReaders;

public class AddBorrowingForm {

    private JFrame frame;

    private JLabel bookTitle, readerName;


    private JButton save, cancel;

    private JComboBox bookBox, readerBox;

    private MBorrowing data;
    private MBooks books;
    private MReaders readers;

    public AddBorrowingForm(MBorrowing data, MBooks books, MReaders readers) {

        frame = new JFrame();

        frame.setTitle("Dodaj wypozyczenie");
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setLayout(null);

        this.data = data;
        this.books = books;
        this.readers = readers;

        createLabels();

        createButtons();

        createComboBox();

    }

    private void createComboBox() {

        bookBox = new JComboBox();
        bookBox.setBounds(10, 30, 400, 20);
        frame.add(bookBox);
        
        readerBox = new JComboBox();
        readerBox.setBounds(10, 80, 400, 20);
        frame.add(readerBox);

        updateComboBox();


    }
    
    private void updateComboBox(){
        
        bookBox.removeAllItems();
        
        for (int i = 0; i < books.getBooks().size(); i++) {

            bookBox.addItem(books.getBooks().get(i).getBook());
        }
        
        readerBox.removeAllItems();
        
        for (int i = 0; i < readers.getReaders().size(); i++) {

            readerBox.addItem(readers.getReaders().get(i).getReader());
        }

        
    }

    private void createButtons() {

        save = new JButton("Dodaj");
        save.setBounds(325, 225, 85, 30);
        frame.add(save);

        cancel = new JButton("Anuluj");
        cancel.setBounds(10, 225, 85, 30);
        frame.add(cancel);

    }

    public JButton getSave() {
        return save;
    }

    public JButton getCancel() {
        return cancel;
    }

    private void createLabels() {

        bookTitle = new JLabel("Książka:");
        bookTitle.setBounds(10, 10, 100, 20);
        frame.add(bookTitle);

        readerName = new JLabel("Wypożyczający:");
        readerName.setBounds(10, 60, 200, 20);
        frame.add(readerName);


    }


    public void show() {

        updateComboBox();
        frame.show();

    }

    public void hide() {

        frame.hide();

    }


    public void addBook() {

        int bookId = books.getBooks().get(bookBox.getSelectedIndex()).getId();
        int readerId = readers.getReaders().get(readerBox.getSelectedIndex()).getId();

        System.out.println(bookId+" - "+readerId);
        
    }
}
