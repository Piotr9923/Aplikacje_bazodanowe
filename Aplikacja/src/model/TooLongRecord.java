
package model;


public class TooLongRecord {
    
    private int readerId;
    private String firstname;
    private String lastname;
    private int bookId;
    private String title;
    private String Date;
    private int time;

    public TooLongRecord(int readerId, String firstname, String lastname, int bookId, String title, String Date, int time) {
        this.readerId = readerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bookId = bookId;
        this.title = title;
        this.Date = Date;
        this.time = time;
    }

    public int getReaderId() {
        return readerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return Date;
    }

    public int getTime() {
        return time;
    }
    
    
    
}
