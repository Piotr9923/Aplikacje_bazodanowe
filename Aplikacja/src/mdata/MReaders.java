package mdata;

import sql.SQLReaders;
import java.util.ArrayList;
import model.Reader;

public class MReaders {

    private SQLReaders sql;
    private ArrayList<Reader> readers;

    public MReaders() {

        sql = new SQLReaders();

        readers = new ArrayList();

        sql.connect();

        sql.loadReadersList(readers);

    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void updateReadersList() {
        readers.removeAll(readers);
        sql.loadReadersList(readers);
    }

    public void addNewReader(String[] data) {

        int adressId = sql.getAdressId(data[4], data[5], data[6], data[7]);

        sql.addReadear(data[0], data[1], adressId, data[2], Integer.parseInt(data[3]));

    }

    public void deleteReader(int id) {

        if (sql.canBeDeleted(id) == true) {

            sql.deleteReader(id);
        }
    }
    
    public void filter(String name, String surname, String city){
        
        readers.removeAll(readers);

        sql.getFilteredReaders(readers, name, surname, city);    
    }

}
