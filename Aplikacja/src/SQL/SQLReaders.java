package SQL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Adress;
import model.Reader;

public class SQLReaders extends SQLConnector{

    
    public SQLReaders(){
        super();
    }
    
        public void loadReadersList(ArrayList<Reader> readers) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Czytelnicy` Inner JOIN Adresy ON Czytelnicy.id_adresu=Adresy.id ORDER BY Czytelnicy.nazwisko, Czytelnicy.imie");

            while (resultSet.next()) {

                readers.add(new Reader(resultSet.getInt("id"),
                        resultSet.getString("imie"), resultSet.getString("nazwisko"),
                        resultSet.getString("nr_telefonu"),
                        resultSet.getInt("rok_urodzenia"),
                        new Adress(resultSet.getString("kod"), resultSet.getString("miejscowosc"), resultSet.getString("ulica"), resultSet.getInt("nr_domu"))));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

        public int getAdressId(String code, String town, String street, String number) {

        int id = -1;

        try {
            resultSet = statement.executeQuery("SELECT * FROM Adresy WHERE kod='" + code + "' AND miejscowosc='"
                    + town + "' AND ulica='" + street + "' AND nr_domu=" + number);

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }

            if (id == -1) {

                statement.execute("INSERT INTO `Adresy` (`id`, `kod`, `miejscowosc`, `ulica`, `nr_domu`) "
                        + "VALUES (NULL, '" + code + "', '" + town + "', '" + street + "', '" + number + "')");

                resultSet = statement.executeQuery("SELECT * FROM Adresy WHERE kod='" + code + "' AND miejscowosc='"
                        + town + "' AND ulica='" + street + "' AND nr_domu=" + number);

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    public void addReadear(String firstname, String lastname, int adress, String phone, int year) {

        try {
            statement.execute("INSERT INTO `Czytelnicy` (`id`, `imie`, `nazwisko`, `id_adresu`, `nr_telefonu`, `rok_urodzenia`) "
                    + "VALUES (NULL, '" + firstname + "', '" + lastname + "', " + adress + ", '" + phone + "', " + year + ")");
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public boolean canBeRedaerDeleted(int id) {

        boolean canBe = true;
        try {
            resultSet = statement.executeQuery("SELECT * FROM Wypozyczenia INNER JOIN Czytelnicy ON Czytelnicy.id=Wypozyczenia.id_czytelnika WHERE Czytelnicy.id=" + id);

            while (resultSet.next()) {
                canBe = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return canBe;
    }
    public void getFilteredReaders(ArrayList<Reader> readers, String name, String surname, String city) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM Czytelnicy JOIN Adresy ON Czytelnicy.id_adresu = Adresy.id "
                    + "WHERE Czytelnicy.imie LIKE '%" + name + "%' AND Czytelnicy.nazwisko LIKE '%" + surname + "%' AND "
                    + "Adresy.miejscowosc LIKE '%" + city + "%' ORDER BY Czytelnicy.nazwisko, Czytelnicy.imie");

            while (resultSet.next()) {

                readers.add(new Reader(resultSet.getInt("id"),
                        resultSet.getString("imie"), resultSet.getString("nazwisko"),
                        resultSet.getString("nr_telefonu"),
                        resultSet.getInt("rok_urodzenia"),
                        new Adress(resultSet.getString("kod"), resultSet.getString("miejscowosc"), resultSet.getString("ulica"), resultSet.getInt("nr_domu"))));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

        public void deleteReader(int id) {

        try {
            statement.execute("DELETE FROM Czytelnicy WHERE Czytelnicy.id=" + id);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        
        
        
        
        
    
}
