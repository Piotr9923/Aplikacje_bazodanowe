package SQL;

import iteams.Adres;
import iteams.Author;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import iteams.Czytelnik;
import iteams.Ksiazka;
import iteams.Wypozyczenie;

public class SQLConnector {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void connect() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteka", "root", "haslo");

            statement = connection.createStatement();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void loadReadersList(ArrayList<Czytelnik> readers) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Czytelnicy` Inner JOIN Adresy ON Czytelnicy.id_adresu=Adresy.id");

            while (resultSet.next()) {

                readers.add(new Czytelnik(resultSet.getInt("id"),
                        resultSet.getString("imie"), resultSet.getString("nazwisko"),
                        resultSet.getString("nr_telefonu"),
                        resultSet.getInt("rok_urodzenia"),
                        new Adres(resultSet.getString("kod"), resultSet.getString("miejscowosc"), resultSet.getString("ulica"), resultSet.getInt("nr_domu"))));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadBooksList(ArrayList<Ksiazka> books) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Ksiazki` Inner JOIN Autorzy ON Ksiazki.id_autora=Autorzy.id");

            while (resultSet.next()) {

                books.add(new Ksiazka(resultSet.getInt("id"), resultSet.getString("tytul"), (resultSet.getString("imie") + " " + resultSet.getString("nazwisko")), resultSet.getString("gatunek"), resultSet.getBoolean("dostepna")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadAuthorsList(ArrayList<Author> authors) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Autorzy`");

            while (resultSet.next()) {

                authors.add(new Author(resultSet.getInt("id"), resultSet.getString("imie"), resultSet.getString("nazwisko")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadBorrowingList(ArrayList<Wypozyczenie> borrowing) {

        try {
            resultSet = statement.executeQuery("SELECT Wypozyczenia.*, Ksiazki.tytul, Czytelnicy.imie, Czytelnicy.nazwisko FROM Wypozyczenia INNER JOIN Ksiazki ON Ksiazki.id = Wypozyczenia.id_ksiazki INNER JOIN Czytelnicy ON Czytelnicy.id=Wypozyczenia.id WHERE Wypozyczenia.data_zwrotu IS NULL");

            while (resultSet.next()) {

                borrowing.add(new Wypozyczenie(resultSet.getInt("id"), resultSet.getInt("id_czytelnika"),
                        resultSet.getString("imie"), resultSet.getString("nazwisko"), resultSet.getInt("id_ksiazki"),
                        resultSet.getString("tytul"), resultSet.getDate("data_wypozyczenia")));
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

    public void addBook(String title, int authorId, String type) {

        try {
            statement.execute("INSERT INTO `Ksiazki` (`id`, `tytul`, `id_autora`, `gatunek`, `dostepna`) "
                    + "VALUES (NULL, '" + title + "', '" + authorId + "', '" + type + "', '1')");
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addAuthor(String firstname, String surname) {

        try {
            statement.execute("INSERT INTO `Autorzy` (`id`, `imie`, `nazwisko`) "
                    + "VALUES (NULL, '" + firstname + "', '" + surname + "')");
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getAuthorID(String firstname, String surname) {

        int id = 0;

        try {
            resultSet = statement.executeQuery("SELECT * FROM Autorzy WHERE imie='" + firstname + "' AND nazwisko='"
                    + surname + "'");

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }

//    public void getCar(ArrayList car, int id) {
//
//        try {
//            resultSet = statement.executeQuery("Select * FROM car WHERE id=" + id);
//            
//       
//             while(resultSet.next()){
//                 
//                car.setBrand(resultSet.getString("car_brand"));
//                car.setCarState(resultSet.getString("car_state"));
//                car.setFuelType(resultSet.getString("fuel_type"));
//                car.setModel(resultSet.getString("car_model"));
//                car.setRegistrationNumber(resultSet.getString("registration_number"));
//                car.setSerialNumber(resultSet.getString("serial_number"));
//                car.setYear(Integer.parseInt(resultSet.getString("year")));
//                
//            }
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//    
//    public void addCar(Car car){
//        
//        try {
//            statement.execute("INSERT INTO `car` (`car_brand`, `car_model`, `year`, `registration_number`, `serial_number`, `fuel_type`, `car_state`) "
//                    + "VALUES ('"+car.getBrand()+"', '"+car.getModel()+"', '"+(""+car.getYear())+"', '"+car.getRegistrationNumber()+"', '"+car.getSerialNumber()+"', '"+car.getFuelTypeToDataBase()+"', '"+car.getCarStateToDataBase()+"')");
//        } catch (SQLException ex) {
//            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    
//    public void updateCar(Car car,int id){
//         try {
//            statement.execute("UPDATE `car` SET `car_brand` = '"+car.getBrand()+"', `car_model` = '"+car.getModel()+"', `year` = '"+car.getYear()+"', `registration_number` = '"+car.getRegistrationNumber()+"', `serial_number` = '"+car.getSerialNumber()+"', `fuel_type` = '"+car.getFuelTypeToDataBase()+"', `car_state` = '"+car.getCarStateToDataBase()+"' WHERE `car`.`id` = 1 ");
//         } catch (SQLException ex) {
//            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//    }
}
