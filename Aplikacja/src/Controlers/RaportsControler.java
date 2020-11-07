package Controlers;

import SQL.SQLConnector;
import View.MyFileChooser;
import View.RaportsWindow;
import aplikacja.PDFCreator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import model.RankingElement;

public class RaportsControler {

    private RaportsWindow window;
    private MainControler controler;
    private MyFileChooser fileChooser;
    private PDFCreator pdfCreator;

    private ArrayList<RankingElement> rankingData;
    private SQLConnector sql;

    public RaportsControler(MainControler controler) {

        this.controler = controler;
        fileChooser = new MyFileChooser(controler.getView().getFrame());

        window = controler.getView().getRaportsWindow();

        rankingData = new ArrayList();
        
        sql = new SQLConnector();
        sql.connect();
        
        sql.getRanking(rankingData);

        pdfCreator = new PDFCreator(rankingData);
        

        window.getReadersRanking().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                fileChooser.showFileChooser();
                if (fileChooser.isChoosen() == true) {
                    pdfCreator.createRanking(fileChooser.getPath());
                }

            }
        });

        window.getTooLongBorrowing().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

    }
}
