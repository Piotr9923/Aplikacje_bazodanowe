package sql;


import java.sql.*;


public class SQLConnector {

    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;

    public void connect() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com/sql7375851?useUnicode=yes&characterEncoding=UTF-8", "sql7375851", "yV77JwPjZJ");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteka?useUnicode=yes&characterEncoding=UTF-8", "root", "haslo");
            statement = connection.createStatement();
           

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}