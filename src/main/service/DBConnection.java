package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    // -- Paramètres de connexion --
    private static final String URL      = "jdbc:postgresql://localhost:5432/premservlet";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "1234"; 

    private static Connection connexion = null;


    public static Connection getConnection() throws SQLException {
        if (connexion == null || connexion.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                connexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connexion;
    }
}
