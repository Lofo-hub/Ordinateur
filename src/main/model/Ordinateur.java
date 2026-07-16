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
    private int ram;
    private String processeur;
    private int disque_dur;

    public Ordinateur(){
    }

    public Ordinateur(int id, int modelid, int ram, String processeur, int disque_dur) {
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
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
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

    public void insert(Ordinateur o) throws SQLException {
        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, o.getModelid());
            ps.setInt(2, (o.getRam()));
            ps.setString(3, o.getProcesseur());
            ps.setInt(4, o.getDisque_dur());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de l'ordinateur : " + e.getMessage());
            throw e;
        }
    }

    public void update(Ordinateur o) throws SQLException {
        Connection conn = DBConnection.getConnection();

        String sql = "UPDATE ordinateur SET id_modele = ?, ram = ?, processeur = ?, disque_dur = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, o.getModelid());
            ps.setInt(2, o.getRam());
            ps.setString(3, o.getProcesseur());
            ps.setInt(4, o.getDisque_dur());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'ordinateur : " + e.getMessage());
            throw e;
        }
    }

    public void delete(int id) throws SQLException {
        Connection conn = DBConnection.getConnection();

        String sql = "DELETE FROM ordinateur WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'ordinateur : " + e.getMessage());
            throw e;
        }
    }

    public List<Ordinateur> findall() throws SQLException {
        List<Ordinateur> ordinateurs = new ArrayList<>();
        String sql = "SELECT * FROM ordinateur";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Ordinateur o = new Ordinateur();
            o.setId(rs.getInt("id"));
            o.setModelid(rs.getInt("id_modele"));
            o.setRam(rs.getInt("ram"));
            o.setProcesseur(rs.getString("processeur"));
            o.setDisque_dur(rs.getInt("disque_dur"));
            ordinateurs.add(o);
        }

        rs.close();
        ps.close();
        return ordinateurs;
    }

    public Ordinateur findById(int id) throws SQLException {
        String sql = "SELECT * FROM ordinateur WHERE id = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Ordinateur o = null;
        if (rs.next()) {
            o = new Ordinateur();
            o.setId(rs.getInt("id"));
            o.setModelid(rs.getInt("id_modele"));
            o.setRam(rs.getInt("ram"));
            o.setProcesseur(rs.getString("processeur"));
            o.setDisque_dur(rs.getInt("disque_dur"));
        }

        rs.close();
        ps.close();
        return o;
    }


    
}