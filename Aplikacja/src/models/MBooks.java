
package models;

import SQL.SQLConnector;
import iteams.Author;
import iteams.Ksiazka;
import java.util.ArrayList;


public class MBooks {
    
    private SQLConnector sql;
    private ArrayList<Ksiazka> books;
    private ArrayList<Ksiazka> availableBooks;
    private ArrayList<Author> authors;
    
    public MBooks(){
        
        sql = new SQLConnector();
        
        books = new ArrayList();
        availableBooks = new ArrayList();
        
        authors = new ArrayList();
        
        sql.connect();

        sql.loadBooksList(books);
        
        sql.loadAvailableBooksList(availableBooks);
        
        sql.loadAuthorsList(authors);
        

    }

    public ArrayList<Ksiazka> getAvailableBooks() {
        return availableBooks;
    }
    
    public void updateBooksList(){
        books.removeAll(books);
        sql.loadBooksList(books);
    }
    
    public void updateAvailableBooksList(){
        availableBooks.removeAll(availableBooks);
        sql.loadBooksList(availableBooks);
    }
    
    public void updateAuthorsList(){
        authors.removeAll(authors);
        sql.loadAuthorsList(authors);
    }

    public ArrayList<Ksiazka> getBooks() {
        return books;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
    
    
    
    public void addNewBook(String[] data){
        
      // int adressId = sql.getAdressId(data[4],data[5],data[6],data[7]);
              
       //sql.addReadear(data[0], data[1], adressId, data[2], Integer.parseInt(data[3]));
            
       
       sql.addAuthor(data[1],data[2]);
       int authorId = sql.getAuthorID(data[1], data[2]);
       
       sql.addBook(data[0], authorId, data[3]);
       
    }
    
    public void addNewBook(String[] data, int authorId){
        
      sql.addBook(data[0], authors.get(authorId).getId(), data[1]);
    }
    
}
