package AddDataForm;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mdata.MBooks;
import mdata.MBorrowing;
import mdata.MReaders;

public class AddBorrowingForm {

    private JFrame frame;

    private JLabel bookTitle, readerName, date;

    private JTextField dateTF;

    private JButton save, cancel;

    private JComboBox bookBox, readerBox;

    private MBorrowing data;
    private MBooks books;
    private MReaders readers;

    public AddBorrowingForm(MBorrowing data, MBooks books, MReaders readers) {

        frame = new JFrame();

        frame.setTitle("Dodaj wypożyczenie");
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

        createTextField();

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

    private void updateComboBox() {

        bookBox.removeAllItems();

        for (int i = 0; i < books.getAvailableBooks().size(); i++) {

            bookBox.addItem(books.getAvailableBooks().get(i).getBook());
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

        date = new JLabel("Data(RRRR-MM-DD):");
        date.setBounds(10, 110, 200, 20);
        frame.add(date);

    }

    private void createTextField() {

        dateTF = new JTextField(LocalDateTime.now().getYear() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth());

        dateTF.setBounds(10, 130, 200, 20);
        frame.add(dateTF);

    }

    private void resetDate() {

        dateTF.setText(LocalDateTime.now().getYear() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth());

    }

    public void show() {

        updateComboBox();
        frame.show();

    }

    public void hide() {

        frame.hide();
        resetDate();

    }

    public void addBorrowing() {

        if (bookBox.getSelectedIndex() >= 0) {

            try {
                int bookId = books.getAvailableBooks().get(bookBox.getSelectedIndex()).getId();
                int readerId = readers.getReaders().get(readerBox.getSelectedIndex()).getId();

                data.addNewBorrowing(bookId, readerId, dateTF.getText());
            } catch (ParseException ex) {
                Logger.getLogger(AddBorrowingForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
