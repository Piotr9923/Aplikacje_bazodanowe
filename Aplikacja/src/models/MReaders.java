package models;

import SQL.SQLConnector;
import java.util.ArrayList;
import iteams.Reader;

public class MReaders {

    private SQLConnector sql;
    private ArrayList<Reader> readers;

    public MReaders() {

        sql = new SQLConnector();

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

        if (sql.canBeRedaerDeleted(id) == true) {

            sql.deleteReader(id);
        }
    }

}
