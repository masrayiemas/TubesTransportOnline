/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import transportonline.Kurir;
import transportonline.Pelanggan;
import transportonline.Pengemudi;
import transportonline.Pesanan;

/**
 *
 * @author Rayiemas Manggala P
 */
public class Application {

    private ArrayList<Pelanggan> pelanggan = new ArrayList<>();
    private ArrayList<Pengemudi> pengemudi = new ArrayList<>();
    private ArrayList<Pesanan> pesanan = new ArrayList<>();
    private Database db;

    public Application() {
        db = new Database();
        try {
            db.connect();
        } catch (SQLException ex) {
            System.out.println("Koneksi Gagal.");
        }
    }

    public boolean insertPelanggan(Pelanggan p) throws SQLException {
        String query = "insert into t_pelanggan values ('" + p.getIdPelanggan() 
                        + "', '" + p.getNama() + "', '" + p.getJenKel() + "', '"
                        + p.getNoTelp() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public boolean insertPengemudi(Pengemudi d) throws SQLException {
        String query = "insert into t_pelanggan values ('" + d.getIdPengemudi() 
                        + "', '" + d.getNama() + "', '" + d.getJenKel() + "', '"
                        + d.getNoTelp() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public boolean insertPesanan(Pesanan t, String idPelanggan) throws SQLException {
        String query = "insert into t_pelanggan values ('" + t.getIdTrans()
                        + "', '" + t.getJenisPesanan() + "', '" + t.getAlamat()
                        + "', '" + t.getTujuan() + "', " + t.getJarak() +", "
                        + t.getTarif() + ", " + t.getStatus() + ", '" 
                        + idPelanggan + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }
    
    public boolean insertPesanan(Kurir k, String idPelanggan) throws SQLException {
        String query = "insert into t_pelanggan values ('" + k.getIdTrans()
                        + "', '" + k.getJenisPesanan() + "', '" + k.getAlamat()
                        + "', '" + k.getTujuan() + "', " + k.getJarak() + ", '"
                        + k.getNamaBarang() + "', " + k.getTarif() + ", " 
                        + k.getStatus() + ", '" + idPelanggan + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }
    
    public boolean deletePelanggan(Pelanggan pe) throws SQLException{
        String query ="delete from Pelanggan where idPelanggan = '"+pe.getIdPelanggan()+"'";
        if (db.manipulasiData(query)){
            db.disconnect();
        }else{
            db.disconnect();
            return false;
        }
    }
    
    public boolean deletePengemudi(Pengemudi pm) throws SQLException{
        String query ="delete from Pengemudi where idPengemudi= '"+pm.getIdPengemudi()+"'";
        if(db.manipulasiData(query)){
            db.disconnect();
        }else{
            db.disconnect();
            return false;
            }
        }
    
    public boolean deletePesanan(Pesanan ps)throws SQLException{
        String query ="delete from Pesanan where idTrans = '"+ps.getIdTrans()+"'";
        if(db.manipulasiData(query)){
            db.disconnect();
        }else{
            db.disconnect();
            return false;
            }
        }
    }