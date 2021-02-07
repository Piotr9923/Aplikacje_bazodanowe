package sql;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RankingPerson;
import model.TooLongRecord;


public class SQLPDF extends SQLConnector{
    
    public SQLPDF(){
        super();
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

        String date = (LocalDateTime.now().getYear() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth());

        try {
            resultSet = statement.executeQuery("SELECT Wypozyczenia.id_czytelnika,Czytelnicy.imie, Czytelnicy.nazwisko, Wypozyczenia.id_ksiazki, Ksiazki.tytul, Wypozyczenia.data_wypozyczenia, DATEDIFF(\"" + date + "\",Wypozyczenia.data_wypozyczenia) as czas\n"
                    + " FROM Wypozyczenia JOIN Czytelnicy ON Czytelnicy.id=Wypozyczenia.id_czytelnika\n"
                    + " JOIN Ksiazki ON Wypozyczenia.id_ksiazki=Ksiazki.id"
                    + " WHERE Wypozyczenia.data_zwrotu IS NULL AND DATEDIFF(\"" + date + "\",Wypozyczenia.data_wypozyczenia)>14 ORDER BY Wypozyczenia.data_wypozyczenia");

            while (resultSet.next()) {
                tooLongData.add(new TooLongRecord(resultSet.getInt("id_czytelnika"),
                        resultSet.getString("imie"), resultSet.getString("nazwisko"), resultSet.getInt("id_ksiazki"),
                        resultSet.getString("tytul"), resultSet.getString("data_wypozyczenia"), resultSet.getInt("czas")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    
}
