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

    private BooksView booksView;
    private ReadersView readersView;
    private BorrowingsView borrowingsView;
    private RaportsView raportsView;

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
        
        initViews();
        
        showBookWindow();

    }

    private void initViews(){
        
             
        booksView = new BooksView();
        readersView = new ReadersView();
        borrowingsView = new BorrowingsView();
        raportsView = new RaportsView();
        
        actualTable = booksView.getTable();
        actualMenu = booksView.getMenuPanel();
        actualFilter = booksView.getFilter();
        frame.add(booksView.getFilter());
        frame.add(booksView.getMenuPanel());
        frame.add(booksView.getTable());
        
    }
    

     public BooksView getBooksView(){
        return booksView;
    }

    public ReadersView getReadersView() {
        return readersView;
    }

    public BorrowingsView getBorrowingsView() {
        return borrowingsView;
    }

    public RaportsView getRaportsView() {
        return raportsView;
    }
    

    public JFrame getFrame() {
        return frame;
    }

  
    public MainMenuPanel getMainMenuPanel() {
        return menu;
    }

    public void showBookWindow() {
        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = booksView.getMenuPanel();
        frame.add(actualMenu);
        actualMenu.setVisible(true);

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = booksView.getTable();
        frame.add(actualTable);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);
        actualFilter = booksView.getFilter();
        frame.add(actualFilter);
        actualFilter.setVisible(true);

    }

    public void showReaderWindow() {

        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = readersView.getMenuPanel();
        frame.add(actualMenu);
        actualMenu.setVisible(true);

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = readersView.getTable();
        frame.add(actualTable);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);
        actualFilter = readersView.getFilter();
        frame.add(actualFilter);
        actualFilter.setVisible(true);

    }

    public void showBorrowingsWindow() {

        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = borrowingsView.getMenuPanel();
        frame.add(actualMenu);
        actualMenu.setVisible(true);

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = borrowingsView.getTable();
        frame.add(actualTable);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);
        actualFilter = borrowingsView.getFilter();
        frame.add(actualFilter);
        actualFilter.setVisible(true);

    }

    public void showRaportWindow() {

        actualMenu.setVisible(false);
        frame.remove(actualMenu);
        actualMenu = raportsView.getMenuPanel();
        frame.add(actualMenu);
        actualMenu.setVisible(true);

        actualTable.setVisible(false);
        frame.remove(actualTable);
        actualTable = raportsView.getWindow();
        frame.add(actualTable);
        actualTable.setVisible(true);

        actualFilter.setVisible(false);
        frame.remove(actualFilter);

    }

}
