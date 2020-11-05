package View;

import java.awt.FlowLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {

    private JFrame frame;
    private MainMenuPanel menu;

    private BooksTableMenuPanel booksMenu;
    private ReadersTableMenuPanel readersMenu;
    private BorrowingsTableMenuPanel borrowingsMenu;

    private BooksTable books;
    private ReadersTable readers;
    private BorrowingsTable borrowings;

    private JPanel actualTable, actualMenu;

    public MainView() {
        frame = new JFrame();

        frame.setTitle("Biblioteka");
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);

        menu = new MainMenuPanel();

        frame.getContentPane().setLayout(null);

        frame.add(menu);

        initTableMenu();

        initTable();

    }

    private void initTable() {

        books = new BooksTable();
        books.setLocation(0, 120);

        readers = new ReadersTable();
        readers.setLocation(0, 120);

        borrowings = new BorrowingsTable();
        borrowings.setLocation(0, 120);

        actualTable = books;

        frame.add(books);
    }

    private void initTableMenu() {

        booksMenu = new BooksTableMenuPanel();
        booksMenu.setLocation(1100, 60);

        actualMenu = booksMenu;

        readersMenu = new ReadersTableMenuPanel();
        readersMenu.setLocation(1100, 60);

        borrowingsMenu = new BorrowingsTableMenuPanel();
        borrowingsMenu.setLocation(1100, 60);

        frame.add(actualMenu);

    }

    public BooksTableMenuPanel getBooksMenu() {
        return booksMenu;
    }

    public ReadersTableMenuPanel getReadersMenu() {
        return readersMenu;
    }

    public BorrowingsTableMenuPanel getBorrowingsMenu() {
        return borrowingsMenu;
    }

    public BooksTable getBooks() {
        return books;
    }

    public ReadersTable getReaders() {
        return readers;
    }

    public BorrowingsTable getBorrowings() {
        return borrowings;
    }

    public BooksTableMenuPanel getTableMenuPanel() {
        return booksMenu;
    }

    public BooksTable getTable() {
        return books;
    }

    public MainMenuPanel getMainMenuPanel() {
        return menu;
    }
    

    public void showBookWindow() {
        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = booksMenu;

        frame.add(actualMenu);
        actualMenu.setVisible(true);
        frame.remove(actualTable);
        actualTable = books;

        frame.add(books);

    }

    public void showReaderWindow() {

        actualMenu.setVisible(false);
        frame.remove(actualMenu);

        actualMenu = readersMenu;

        frame.add(actualMenu);
        actualMenu.setVisible(true);

        frame.remove(actualTable);
        actualTable = readers;

        frame.add(readers);
    }

    public void showBorrowingsWindow() {
        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = borrowingsMenu;

        frame.add(actualMenu);
        actualMenu.setVisible(true);

        frame.remove(actualTable);
        actualTable = borrowings;

        frame.add(borrowings);

    }

    public void showRaportWindow() {

    }

    
}
