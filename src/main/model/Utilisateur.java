package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import service.DBConnection;

public class Utilisateur {
    private int id;
    private String login;
    private String password;
    private String role;

    public Utilisateur() {
    }

    public Utilisateur(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Utilisateur checkLogin(String login, String password) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Utilisateur utilisateur = new Utilisateur();

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM utilisateur WHERE login = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                utilisateur.id = rs.getInt("id");
                utilisateur.login = rs.getString("login");
                utilisateur.password = rs.getString("password");
                utilisateur.role = rs.getString("role");
            } else {
                throw new Exception("Invalid login or password");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return utilisateur;
    }
}