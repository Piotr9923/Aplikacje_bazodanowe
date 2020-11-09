package SQL;

import model.Adress;
import model.Author;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Reader;
import model.Book;
import model.Borrowing;
import model.RankingPerson;
import model.TooLongRecord;

public class SQLConnector {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void connect() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteka?useUnicode=yes&characterEncoding=UTF-8", "root", "haslo");

            statement = connection.createStatement();

        } catch (Exception e) {

            e.printStackTrace();
        }

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

    public void loadBooksList(ArrayList<Book> books) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Ksiazki` Inner JOIN Autorzy ON Ksiazki.id_autora=Autorzy.id ORDER BY Ksiazki.tytul");

            while (resultSet.next()) {

                books.add(new Book(resultSet.getInt("id"), resultSet.getString("tytul"), (resultSet.getString("imie") + " " + resultSet.getString("nazwisko")), resultSet.getString("gatunek"), resultSet.getBoolean("dostepna")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadAvailableBooksList(ArrayList<Book> books) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Ksiazki` Inner JOIN Autorzy ON Ksiazki.id_autora=Autorzy.id WHERE Ksiazki.dostepna=true ORDER BY Ksiazki.tytul");

            while (resultSet.next()) {

                books.add(new Book(resultSet.getInt("id"), resultSet.getString("tytul"), (resultSet.getString("imie") + " " + resultSet.getString("nazwisko")), resultSet.getString("gatunek"), resultSet.getBoolean("dostepna")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadAuthorsList(ArrayList<Author> authors) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Autorzy` ORDER BY Autorzy.imie");

            while (resultSet.next()) {

                authors.add(new Author(resultSet.getInt("id"), resultSet.getString("imie"), resultSet.getString("nazwisko")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadBorrowingList(ArrayList<Borrowing> borrowing) {

        try {
            resultSet = statement.executeQuery("SELECT Wypozyczenia.*, Ksiazki.tytul, Czytelnicy.imie, Czytelnicy.nazwisko FROM Wypozyczenia INNER JOIN Ksiazki ON Ksiazki.id = Wypozyczenia.id_ksiazki INNER JOIN Czytelnicy ON Czytelnicy.id=Wypozyczenia.id_czytelnika WHERE Wypozyczenia.data_zwrotu IS NULL ORDER BY Wypozyczenia.data_wypozyczenia");

            while (resultSet.next()) {

                borrowing.add(new Borrowing(resultSet.getInt("id"), resultSet.getInt("id_czytelnika"),
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
                    + "VALUES (NULL,'" + title + "', '" + authorId + "', '" + type + "', '1')");
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

    public void addBorrowing(int bookId, int readerId, Date date) {

        try {
            statement.execute("INSERT INTO `Wypozyczenia` (`id`, `id_czytelnika`, `id_ksiazki`, `data_wypozyczenia`, `data_zwrotu`) "
                    + "VALUES (NULL, '" + readerId + "', '" + bookId + "', '" + date + "', NULL)");

            statement.execute("UPDATE `Ksiazki` SET `dostepna` = '0' WHERE `Ksiazki`.`id` = " + bookId);

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void returnBook(int borrowingId, int bookId, Date date) {

        try {
            statement.execute("UPDATE `Wypozyczenia` SET `data_zwrotu` = '" + date + "' WHERE `Wypozyczenia`.`id` =" + borrowingId);
            statement.execute("UPDATE `Ksiazki` SET `dostepna` = '1' WHERE `Ksiazki`.`id` =" + bookId);

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getRanking(ArrayList<RankingPerson> rankingData) {

        try {
            resultSet = statement.executeQuery("SELECT Czytelnicy.id, Czytelnicy.imie, Czytelnicy.nazwisko, COUNT(*) as ilosc "
                    + "FROM Czytelnicy JOIN Wypozyczenia ON (Czytelnicy.id=Wypozyczenia.id_czytelnika) "
                    + "GROUP BY Czytelnicy.id ORDER BY ilosc DESC");

            while (resultSet.next()) {
                rankingData.add(new RankingPerson(resultSet.getInt("id"), resultSet.getString("imie"), resultSet.getString("nazwisko"), resultSet.getInt("ilosc")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getBorrowingTooLongTime(ArrayList<TooLongRecord> tooLongData) {

        String date = (LocalDateTime.now().getYear()+ "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth());

        try {
            resultSet = statement.executeQuery("SELECT Wypozyczenia.id_czytelnika,Czytelnicy.imie, Czytelnicy.nazwisko, Wypozyczenia.id_ksiazki, Ksiazki.tytul, Wypozyczenia.data_wypozyczenia, DATEDIFF(\""+date+"\",Wypozyczenia.data_wypozyczenia) as czas\n"
                    + " FROM Wypozyczenia JOIN Czytelnicy ON Czytelnicy.id=Wypozyczenia.id_czytelnika\n"
                    + " JOIN Ksiazki ON Wypozyczenia.id_ksiazki=Ksiazki.id"
                    + " WHERE Wypozyczenia.data_zwrotu IS NULL AND DATEDIFF(\""+date+"\",Wypozyczenia.data_wypozyczenia)>14 ORDER BY Wypozyczenia.data_wypozyczenia");

            while (resultSet.next()) {
                tooLongData.add(new TooLongRecord(resultSet.getInt("id_czytelnika"),
                        resultSet.getString("imie"), resultSet.getString("nazwisko"), resultSet.getInt("id_ksiazki"),
                        resultSet.getString("tytul"), resultSet.getString("data_wypozyczenia"), resultSet.getInt("czas")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getBookTypes(ArrayList<String> types) {

        try {

            resultSet = statement.executeQuery("SELECT DISTINCT Ksiazki.gatunek FROM Ksiazki ORDER BY Ksiazki.gatunek");

            while (resultSet.next()) {

                types.add(resultSet.getString("gatunek"));

            }
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

    public boolean canBeBookDeleted(int id) {

        boolean canBe = true;
        try {
            resultSet = statement.executeQuery("SELECT * FROM Wypozyczenia INNER JOIN Ksiazki ON Ksiazki.id=Wypozyczenia.id_ksiazki WHERE Ksiazki.id=" + id);

            while (resultSet.next()) {
                canBe = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return canBe;
    }

    public void deleteBook(int id) {

        try {
            statement.execute("DELETE FROM Ksiazki WHERE Ksiazki.id=" + id);
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
    
    public void getFilteredBooks(ArrayList<Book> books, String title,String author, String type, String available){
        
        try {
            resultSet = statement.executeQuery("SELECT * FROM `Ksiazki` Inner JOIN Autorzy ON Ksiazki.id_autora=Autorzy.id "
                    + "WHERE Ksiazki.tytul Like '%"+title+"%' AND"
                            + " CONCAT(Autorzy.imie,\" \", Autorzy.nazwisko) LIKE '%"+author+"%' AND "
                                    + "Ksiazki.gatunek LIKE '%"+type+"%' AND "
                                            + "Ksiazki.dostepna Like '%"+available+"%' ORDER BY Ksiazki.tytul");

            while (resultSet.next()) {

                books.add(new Book(resultSet.getInt("id"), resultSet.getString("tytul"), (resultSet.getString("imie") + " " + resultSet.getString("nazwisko")), resultSet.getString("gatunek"), resultSet.getBoolean("dostepna")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void getFilteredReaders(ArrayList<Reader> readers, String name, String surname, String city){
        
        try {
            resultSet = statement.executeQuery("SELECT * FROM Czytelnicy JOIN Adresy ON Czytelnicy.id_adresu = Adresy.id "
                    + "WHERE Czytelnicy.imie LIKE '%"+name+"%' AND Czytelnicy.nazwisko LIKE '%"+surname+"%' AND "
                            + "Adresy.miejscowosc LIKE '%"+city+"%' ORDER BY Czytelnicy.nazwisko, Czytelnicy.imie");

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

}
