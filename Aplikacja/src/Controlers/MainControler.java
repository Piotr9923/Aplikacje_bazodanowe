package Controlers;

import View.MainView;
import aplikacja.TableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControler {

    private MainView view;

    private TableMenuControler tableControler;
    
    
    public MainControler() {

        view = new MainView();
        
        tableControler = new TableMenuControler(this);
        
        setButtonActions();
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
