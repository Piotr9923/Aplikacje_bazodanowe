
package model;


public class Book {
    
    private String title;
    private String author;
    private int id;
    private String type;
    private boolean available;

    public Book(int id,String title, String author, String type, boolean available) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.type = type;
        this.available = available;
    }
    

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public int getId() {
        return id;
    }


    public String getType() {
        return type;
    }


    public boolean isAvailable() {
        return available;
    }
    
    public String getBook(){
        
        return ""+id+" - "+title;
    } 
    
}
