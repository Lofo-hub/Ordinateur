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

    public static Connection getConnexion() throws SQLException {
        if (connexion == null || connexion.isClosed()) {
            connexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion PostgreSQL établie.");
        }
        return connexion;
    }
}
