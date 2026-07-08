package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBConnection;

public class Ordinateur {

    private int id;
    private int  modelid;
    private String ram;
    private String processeur;
    private int disque_dur;

    public Ordinateur(){
    }

    public Ordinateur(int id, int modelid, String ram, String processeur, int disque_dur) {
        this.id = id;
        this.modelid = modelid;
        this.ram = ram;
        this.processeur = processeur;
        this.disque_dur = disque_dur;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getModelid() {
        return modelid;
    }
    public void setModelid(int modelid) {
        this.modelid = modelid;
    }
    public String getRam() {
        return ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }
    public String getProcesseur() {
        return processeur;
    }
    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }
    public int getDisque_dur() {
        return disque_dur;
    }
    public void setDisque_dur(int disque_dur) {
        this.disque_dur = disque_dur;
    }

      public void insert() throws SQLException {
        String sql = "INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) "
                   + "VALUES (?, ?, ?, ?)";

        Connection conn = DBConnection.getConnexion();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, this.getModelid());
        ps.setString(2, this.getRam());
        ps.setString(3, this.getProcesseur());
        ps.setInt(4, this.getDisque_dur());

        ps.executeUpdate();
        ps.close();
    }

    public List<Ordinateur> findall() throws SQLException {
        List<Ordinateur> ordinateurs = new ArrayList<>();
        String sql = "SELECT * FROM ordinateur";

        Connection conn = DBConnection.getConnexion();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Ordinateur o = new Ordinateur();
            o.setId(rs.getInt("id"));
            o.setModelid(rs.getInt("modelid"));
            o.setRam(rs.getString("ram"));
            o.setProcesseur(rs.getString("processeur"));
            o.setDisque_dur(rs.getInt("disque_dur"));
            ordinateurs.add(o);
        }

        rs.close();
        ps.close();
        return ordinateurs;
    }


    
}