
package models;

import SQL.SQLConnector;
import iteams.Ksiazka;
import java.util.ArrayList;


public class MBooks {
    
    private SQLConnector sql;
    private ArrayList<Ksiazka> books;
    
    public MBooks(){
        
        sql = new SQLConnector();
        
        books = new ArrayList();
        
        sql.connect();

        sql.loadBooksList(books);
        

    }

    public ArrayList<Ksiazka> getBooks() {
        return books;
    }
    
}
