package View;

import filters.BookFilter;
import filters.BorrowingFilter;
import filters.ReaderFilter;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {

    private JFrame frame;
    private MainMenuPanel menu;

    private BooksTableMenuPanel booksMenu;
    private ReadersTableMenuPanel readersMenu;
    private BorrowingsTableMenuPanel borrowingsMenu;
    private RaportsMenuPanel raportsMenu;

    private RaportsWindow raportsWindow;
    private BooksTable books;
    private ReadersTable readers;
    private BorrowingsTable borrowings;

    private BookFilter bookFilter;
    private ReaderFilter readerFilter;
    private BorrowingFilter borrowingFilter;

    private JPanel actualTable, actualMenu, actualFilter;

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

        initFilters();

        initTable();

    }

    private void initFilters() {

        bookFilter = new BookFilter();
        bookFilter.setLocation(0, 60);
        actualFilter = bookFilter;
        frame.add(actualFilter);
        bookFilter.setVisible(true);

        readerFilter = new ReaderFilter();
        readerFilter.setLocation(0, 60);

        borrowingFilter = new BorrowingFilter();
        borrowingFilter.setLocation(0, 60);

    }

    private void initTable() {

        raportsWindow = new RaportsWindow();
        raportsWindow.setLocation(0, 120);

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

        raportsMenu = new RaportsMenuPanel();
        raportsMenu.setLocation(1100, 60);

        booksMenu = new BooksTableMenuPanel();
        booksMenu.setLocation(1100, 60);

        actualMenu = booksMenu;

        readersMenu = new ReadersTableMenuPanel();
        readersMenu.setLocation(1100, 60);

        borrowingsMenu = new BorrowingsTableMenuPanel();
        borrowingsMenu.setLocation(1100, 60);

        frame.add(actualMenu);

    }

    public BorrowingFilter getBorrowingFilter() {
        return borrowingFilter;
    }

    public ReaderFilter getReaderFilter() {
        return readerFilter;
    }

    public BookFilter getBookFilter() {
        return bookFilter;
    }

    public JFrame getFrame() {
        return frame;
    }

    public RaportsWindow getRaportsWindow() {
        return raportsWindow;
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

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = books;
        frame.add(books);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);
        actualFilter = bookFilter;
        frame.add(actualFilter);
        actualFilter.setVisible(true);

    }

    public void showReaderWindow() {

        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = readersMenu;
        frame.add(actualMenu);
        actualMenu.setVisible(true);

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = readers;
        frame.add(readers);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);
        actualFilter = readerFilter;
        frame.add(actualFilter);
        actualFilter.setVisible(true);

    }

    public void showBorrowingsWindow() {

        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = borrowingsMenu;
        frame.add(actualMenu);
        actualMenu.setVisible(true);

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = borrowings;
        frame.add(borrowings);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);
        actualFilter = borrowingFilter;
        frame.add(actualFilter);
        actualFilter.setVisible(true);

    }

    public void showRaportWindow() {

        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = raportsMenu;
        frame.add(actualMenu);
        actualMenu.setVisible(true);

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = raportsWindow;
        frame.add(raportsWindow);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);

    }

}
