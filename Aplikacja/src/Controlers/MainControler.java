package Controlers;

import View.MainView;
import aplikacja.TableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControler {

    private MainView view;

    private BooksTableControler booksControler;
    private ReadersTableControler readersControler;
    private BorrowingsTableControler borrowingControler;
    
    public MainControler() {

        view = new MainView();
        
        booksControler = new BooksTableControler(this);
        readersControler = new ReadersTableControler(this);
        borrowingControler = new BorrowingsTableControler(this);
        
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
                view.showBookWindow();
            }
        });

        view.getMainMenuPanel().getCzytelnicy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.showReaderWindow();
            }
        });
        
         view.getMainMenuPanel().getWypozyczenia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
