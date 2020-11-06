package models;

import SQL.SQLConnector;
import iteams.Ksiazka;
import iteams.Wypozyczenie;
import java.util.ArrayList;

public class MBorrowing {

    private SQLConnector sql;
    private ArrayList<Wypozyczenie> borrowing;

    public MBorrowing() {

        sql = new SQLConnector();

        borrowing = new ArrayList();

        sql.connect();

        sql.loadBorrowingList(borrowing);

    }

    public ArrayList<Wypozyczenie> getBorrowings() {
        return borrowing;
    }

}
