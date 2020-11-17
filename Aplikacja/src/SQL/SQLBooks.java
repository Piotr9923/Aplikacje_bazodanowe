package SQL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Author;
import model.Book;


public class SQLBooks extends SQLConnector{
    
    public SQLBooks(){
        super();
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

    public void getFilteredBooks(ArrayList<Book> books, String title, String author, String type, String available) {

        try {
            resultSet = statement.executeQuery("SELECT * FROM `Ksiazki` Inner JOIN Autorzy ON Ksiazki.id_autora=Autorzy.id "
                    + "WHERE Ksiazki.tytul Like '%" + title + "%' AND"
                    + " CONCAT(Autorzy.imie,\" \", Autorzy.nazwisko) LIKE '%" + author + "%' AND "
                    + "Ksiazki.gatunek LIKE '%" + type + "%' AND "
                    + "Ksiazki.dostepna Like '%" + available + "%' ORDER BY Ksiazki.tytul");

            while (resultSet.next()) {

                books.add(new Book(resultSet.getInt("id"), resultSet.getString("tytul"), (resultSet.getString("imie") + " " + resultSet.getString("nazwisko")), resultSet.getString("gatunek"), resultSet.getBoolean("dostepna")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
