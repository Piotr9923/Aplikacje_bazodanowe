
package models;

import SQL.SQLConnector;
import java.util.ArrayList;
import iteams.Czytelnik;


public class MReaders {
    
    private SQLConnector sql;
    private ArrayList<Czytelnik> readers;
    
    
    public MReaders(){
        
        sql = new SQLConnector();
        
        readers = new ArrayList();
        
        sql.connect();

        sql.loadReadersList(readers);
        

    }

    public ArrayList<Czytelnik> getReaders() {
        return readers;
    }
    
   
    
}
