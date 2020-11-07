package Controlers;

import View.MainView;
import aplikacja.PDFCreator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControler {

    private MainView view;

    private BooksTableControler booksControler;
    private ReadersTableControler readersControler;
    private BorrowingsTableControler borrowingControler;
    private RaportsControler raportsControler;
    private PDFCreator pdf;
    
    
    public MainControler() {

        view = new MainView();
        
        booksControler = new BooksTableControler(this);
        readersControler = new ReadersTableControler(this);
        borrowingControler = new BorrowingsTableControler(this);
        raportsControler = new RaportsControler(this);
        
        setButtonActions();
    }

    public BooksTableControler getBooksControler() {
        return booksControler;
    }

    public ReadersTableControler getReadersControler() {
        return readersControler;
    }
    

    private void setButtonActions() {

        view.getMainMenuPanel().getKsiazki().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                booksControler.updateTable();
                view.showBookWindow();
            }
        });

        view.getMainMenuPanel().getCzytelnicy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                readersControler.updateTable();
                view.showReaderWindow();
            }
        });
        
         view.getMainMenuPanel().getWypozyczenia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                borrowingControler.updateTable();
                view.showBorrowingsWindow();
            }
        });
         

         view.getMainMenuPanel().getRaporty().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.showRaportWindow();
            }
        });
        
        view.getMainMenuPanel().getWyjscie().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
      
    }

    public MainView getView() {
        return view;
    }

}
