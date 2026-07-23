package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import service.DBConnection;

public class Etat {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Etat() {
    }

        public List<Etat> findall() throws SQLException {
        List<Etat> ordinateurs = new ArrayList<>();
        String sql = "SELECT * FROM type_etat_panne";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Etat o = new Etat();
            o.setId(rs.getInt("id"));
            o.setType(rs.getString("type"));
            ordinateurs.add(o);
        }

        rs.close();
        ps.close();
        return ordinateurs;
    }

    }
