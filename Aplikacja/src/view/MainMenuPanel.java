package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {

    private JButton books, readers, exit, borrowings, raports;

    public MainMenuPanel() {

        
        this.setSize(1366, 60);
        this.setLayout(null);
        books = new JButton("Książki");
        books.setBounds(50, 10, 100, 40);
        books.setBackground(Color.white);
        this.add(books);
        this.setBackground(Color.gray);
        
        readers = new JButton("Czytelnicy");
        readers.setBounds(200, 10, 120, 40);
        readers.setBackground(Color.white);
        this.add(readers);
        
        raports = new JButton("Raporty");
        raports.setBounds(560, 10, 120, 40);
        raports.setBackground(Color.white);
        this.add(raports);
        
        borrowings = new JButton("Wypożyczenia");
        borrowings.setBounds(370, 10, 140, 40);
        borrowings.setBackground(Color.white);
        this.add(borrowings);
        
        exit = new JButton("Wyjście");
        exit.setBounds(1150, 10, 100, 40);
        exit.setBackground(Color.RED);
        this.add(exit);

    }

    public JButton getWypozyczenia() {
        return borrowings;
    }

    public JButton getRaporty() {
        return raports;
    }

    public JButton getKsiazki() {
        return books;
    }

    public JButton getCzytelnicy() {
        return readers;
    }

    public JButton getWyjscie() {
        return exit;
    }

    
    
    
}
