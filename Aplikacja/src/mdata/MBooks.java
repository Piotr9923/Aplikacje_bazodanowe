
package mdata;

import SQL.SQLBooks;
import model.Author;
import model.Book;
import java.util.ArrayList;


public class MBooks {
    
    private SQLBooks sql;
    private ArrayList<Book> books;
    private ArrayList<Book> availableBooks;
    private ArrayList<Author> authors;
    private ArrayList<String> bookTypes;
    
    public MBooks(){
        
        sql = new SQLBooks();
        
        books = new ArrayList();
        availableBooks = new ArrayList();
        bookTypes = new ArrayList();
        authors = new ArrayList();
        
        sql.connect();

        sql.loadBooksList(books);
        
        sql.loadAvailableBooksList(availableBooks);
        
        sql.loadAuthorsList(authors);
        
        sql.getBookTypes(bookTypes);

    }
    
    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }
    
    public void updateBooksList(){
        books.removeAll(books);
        sql.loadBooksList(books);
    }
    
    public void updateAvailableBooksList(){
        availableBooks.removeAll(availableBooks);
        sql.loadAvailableBooksList(availableBooks);
    }
    
    public void updateAuthorsList(){
        authors.removeAll(authors);
        sql.loadAuthorsList(authors);
    }
    
    public void updateBookTypesList(){
        bookTypes.removeAll(bookTypes);
        sql.getBookTypes(bookTypes);
        
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<String> getBookTypes() {
        return bookTypes;
    }
    
    public void filter(String title, String author, String type, String available){
        
        books.removeAll(books);
        
        sql.getFilteredBooks(books, title,author, type, available);    
    }
     
    public void addNewBook(String[] data){
        
       sql.addAuthor(data[1],data[2]);
       int authorId = sql.getAuthorID(data[1], data[2]);
       
       sql.addBook(data[0], authorId, data[3]);
       
    }
    
    public void addNewBook(String[] data, int authorId){
        
      sql.addBook(data[0], authors.get(authorId).getId(), data[1]);
    }
    
    public void deleteBook(int id){
        
       if(sql.canBeBookDeleted(id)==true){
           
         sql.deleteBook(id);
       }  
    }
    
}
