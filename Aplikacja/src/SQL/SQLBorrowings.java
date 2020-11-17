package SQL;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Borrowing;


public class SQLBorrowings extends SQLConnector{
    
    public SQLBorrowings(){
        super();
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

     public void getFilteredBorrowing(ArrayList<Borrowing> borrowing, String name, String title) {

        
        
        try {
            resultSet = statement.executeQuery("SELECT Wypozyczenia.*, Ksiazki.tytul, Czytelnicy.imie, Czytelnicy.nazwisko FROM Wypozyczenia INNER JOIN Ksiazki ON Ksiazki.id = Wypozyczenia.id_ksiazki INNER JOIN Czytelnicy ON Czytelnicy.id=Wypozyczenia.id_czytelnika "
                    + "WHERE Wypozyczenia.data_zwrotu IS NULL AND Ksiazki.tytul Like '%" + title + "%' AND "+
                    "CONCAT(Czytelnicy.imie,\" \", Czytelnicy.nazwisko) LIKE '%" + name + "%'  ORDER BY Wypozyczenia.data_wypozyczenia");

            while (resultSet.next()) {

                borrowing.add(new Borrowing(resultSet.getInt("id"), resultSet.getInt("id_czytelnika"),
                        resultSet.getString("imie"), resultSet.getString("nazwisko"), resultSet.getInt("id_ksiazki"),
                        resultSet.getString("tytul"), resultSet.getDate("data_wypozyczenia")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
