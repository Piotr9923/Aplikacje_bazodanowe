package models;

import SQL.SQLConnector;
import iteams.Ksiazka;
import iteams.Wypozyczenie;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void updateBorrowingList() {
        borrowing.removeAll(borrowing);
        sql.loadBorrowingList(borrowing);
    }

    public void addNewBorrowing(int bookId, int readerId, String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = formatter.parse(date);
        java.sql.Date borrowingDate = new java.sql.Date(myDate.getTime());

        sql.addBorrowing(bookId, readerId, borrowingDate);
    }

}
