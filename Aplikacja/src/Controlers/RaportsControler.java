package Controlers;

import SQL.SQLConnector;
import View.MyFileChooser;
import View.RaportsWindow;
import PDFCreator.PDFCreator;
import View.RaportsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import model.RankingPerson;
import model.TooLongRecord;

public class RaportsControler {

    private RaportsWindow window;
    private MyFileChooser fileChooser;
    private PDFCreator pdfCreator;

    private ArrayList<RankingPerson> rankingData;
    private ArrayList<TooLongRecord> tooLongDate;
    private SQLConnector sql;
    
    private RaportsView view;
    

    public RaportsControler(MainControler controler) {

        fileChooser = new MyFileChooser(controler.getView().getFrame());
        
        view = controler.getView().getRaportsView();

        window = view.getWindow();
                
                
        rankingData = new ArrayList();
        tooLongDate = new ArrayList();

        sql = new SQLConnector();
        sql.connect();

        sql.getRanking(rankingData);
        sql.getBorrowingTooLongTime(tooLongDate);

        pdfCreator = new PDFCreator(rankingData, tooLongDate);

        window.getReadersRanking().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                updateRanking();

                fileChooser.showFileChooser();
                if (fileChooser.isChoosen() == true) {
                    pdfCreator.createRanking(fileChooser.getPath());
                }

            }
        });

        window.getTooLongBorrowing().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                updateTooLong();

                fileChooser.showFileChooser();
                if (fileChooser.isChoosen() == true) {
                    pdfCreator.createTooLong(fileChooser.getPath());
                }

            }
        });

    }

    private void updateRanking() {

        rankingData.removeAll(rankingData);
        sql.getRanking(rankingData);

    }

    private void updateTooLong() {

        tooLongDate.removeAll(tooLongDate);
        sql.getBorrowingTooLongTime(tooLongDate);

    }

}
