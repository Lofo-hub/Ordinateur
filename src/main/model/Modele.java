package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import service.DBConnection;

public class Modele {
    private int id;
    private String libelle;
    private int id_marque;
    private String reference;

    public Modele() {
    }

    public Modele(int id, String libelle, int id_marque, String reference) {
        this.id = id;
        this.libelle = libelle;
        this.id_marque = id_marque;
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Modele> getAll() throws Exception {
        String sql = "SELECT * FROM modele";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet  rs = ps.executeQuery();
        List<Modele> modeles = new ArrayList<>();
        
        while (rs.next()) {
                Modele m = new Modele();
                m.setId(rs.getInt("id"));
                m.setLibelle(rs.getString("libelle"));
                m.setId_marque(rs.getInt("id_marque"));
                m.setReference(rs.getString("reference"));
                modeles.add(m);
            }
            rs.close();
            ps.close();
            return modeles;
        }
    public Modele findById(int id) throws Exception {
        String sql = "SELECT * FROM modele WHERE id = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Modele m = null;
        if (rs.next()) {
            m = new Modele();
            m.setId(rs.getInt("id"));
            m.setLibelle(rs.getString("libelle"));
            m.setId_marque(rs.getInt("id_marque"));
            m.setReference(rs.getString("reference"));
        }
        
        rs.close();
        ps.close();
        return m;
    }
}
