package Controlers;

import View.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControler {

    private MainView view;

    public MainControler() {

        view = new MainView();

        setButtonActions();
    }

    private void setButtonActions() {

        view.getMenuPanel().getKsiazki().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.showBookWindow();
            }
        });

        view.getMenuPanel().getCzytelnicy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.showReaderWindow();
            }
        });

         view.getMenuPanel().getRaporty().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.showRaportWindow();
            }
        });
        
        view.getMenuPanel().getWyjscie().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
      

    }

}
