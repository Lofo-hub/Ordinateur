package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


import service.DBConnection;

public class Historique {
    
    private int id_ordinateur;
    private int id_etat;
    private int date_entre;
    private String observatin;
    private int count;
    private int type;
    private int countype;


    public int getCountype() {
        return countype;
    }
    public void setCountype(int countype) {
        this.countype = countype;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    public int getCounts(){
        return count;
    }
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Historique(int count, int etat) {
        this.count = count;
        this.id_etat = etat;
    }

    public Historique() {
     
    }

    public Historique(int id, int id_etat, int date_entre, String observation) {
        this.id = id;
        this.id_etat = id_etat;
        this.date_entre = date_entre;
        this.observatin = observation;
    }

    public List<Historique> getCount(String date) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "Select count(*), id_etat from historique WHERE date_entre = ? group by id_etat";
        List<Historique> test = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            SimpleDateFormat formatteur = new SimpleDateFormat("yyyy-MM-dd");
            Date d = Date.valueOf(date);
            String dateFormatee = formatteur.format(d);
            ps.setDate(1, dateFormatee != null ? Date.valueOf(dateFormatee) : null);
            ResultSet  rs = ps.executeQuery();
            
            while (rs.next()) {
                    Historique h = new Historique(count, id_etat);
                    h.setId_etat(rs.getInt("id_etat"));
                    h.setCount(rs.getInt("count"));
                    test.add(h);
                }
                rs.close();
                ps.close();
                return test;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion dans l'historique : " + e.getMessage());
        }  
        return test;        
        }

        public List<Historique> getTypecount(String date) throws Exception {
        Connection conn = DBConnection.getConnection();
        
        String sql = "select count(*), id_type_panne from historique WHERE date_entre > ? group by id_type_panne";


        List<Historique> test = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            SimpleDateFormat formatteur = new SimpleDateFormat("yyyy-MM-dd");
            Date d = Date.valueOf(date);
            String dateFormatee = formatteur.format(d);
            ps.setDate(1, dateFormatee != null ? Date.valueOf(dateFormatee) : null);
            ResultSet  rs = ps.executeQuery();
            
            while (rs.next()) {
                    Historique h = new Historique(count, id_etat);
                    h.setType(rs.getInt("id_type_panne"));
                    h.setCountype(rs.getInt("count"));
                    test.add(h);
                }
                rs.close();
                ps.close();
                return test;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion dans l'historique : " + e.getMessage());
        }  
        return test;        
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


    public int getId_ordinateur() {
        return id_ordinateur;
    }

    public void setId_ordinateur(int id_ordinateur) {
        this.id_ordinateur = id_ordinateur;
    }

    public int getId_etat() {
        return id_etat;
    }

    public void setId_etat(int id_etat) {
        this.id_etat = id_etat;
    }

    public int getDate_entre() {
        return date_entre;
    }

    public void setDate_entre(int date_entre) {
        this.date_entre = date_entre;
    }

    public String getObservatin() {
        return observatin;
    }

    public void setObservatin(String observatin) {
        this.observatin = observatin;
    }
}
