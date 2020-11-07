
package model;

import java.util.Date;


public class Borrowing {
    
    
    private int id;
    private int readerId;
    private String ReaderFirstname;
    private String readerLastname;
    private int bookId;
    private String title;
    private Date borrowingDate;

    public Borrowing(int id, int readerId, String readerFirstname, String readerLastname, int bookId, String title, Date borrowingDate) {
        this.id = id;
        this.readerId = readerId;
        this.ReaderFirstname = readerFirstname;
        this.readerLastname = readerLastname;
        this.bookId = bookId;
        this.title = title;
        this.borrowingDate = borrowingDate;
    }
    
    
    

    public int getId() {
        return id;
    }

    public int getReaderId() {
        return readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public String getReaderFirstname() {
        return ReaderFirstname;
    }

    public String getReaderLastname() {
        return readerLastname;
    }

    public String getTitle() {
        return title;
    }

   
    
    
    
    
}
