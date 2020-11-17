package mdata;

import SQL.SQLBorrowings;
import model.Borrowing;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;

public class MBorrowing {

    private SQLBorrowings sql;
    private ArrayList<Borrowing> borrowing;

    public MBorrowing() {

        sql = new SQLBorrowings();

        borrowing = new ArrayList();

        sql.connect();

        sql.loadBorrowingList(borrowing);

    }

    public ArrayList<Borrowing> getBorrowings() {
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
    
    public void returnBook(int borrowingId, int bookId) throws ParseException{
        
       String date = (LocalDateTime.now().getYear() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth());

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = formatter.parse(date);
        java.sql.Date returnDate = new java.sql.Date(myDate.getTime());
        
        sql.returnBook(borrowingId, bookId, returnDate);
        
    }
    
     public void filter(String name, String title){
        
        borrowing.removeAll(borrowing);
        
        sql.getFilteredBorrowing(borrowing,name,title);    
    }

}
