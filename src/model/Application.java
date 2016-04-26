/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Database;
import controller.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import transportonline.Kurir;
import transportonline.Pelanggan;
import transportonline.Pengemudi;
import transportonline.Pesanan;

/**
 *
 * @author Rayiemas Manggala P
 */
public class Application {

    private ArrayList<Pelanggan> pelanggan;
    private ArrayList<Pengemudi> pengemudi;
    private ArrayList<Pesanan> pesanan;
    private ArrayList<Pesanan> kurir;
    private Database db;

    public Application() {
        db = new Database();
    }

    public void loadData() {
        pelanggan = new ArrayList<>();
        pengemudi = new ArrayList<>();
        pesanan = new ArrayList<>();
        kurir = new ArrayList<>();
        ResultSet hslPelanggan = null;
        ResultSet hslPengemudi = null;
        ResultSet hslPesanan = null;
        ResultSet hslPesankurir = null;
        try {
            db.connect();
            Pelanggan p = null;
            Pengemudi d = null;
            String query1 = "select * from t_pelanggan";
            String query2 = "select * from t_pengemudi";
            hslPelanggan = db.getData(query1);

            while (hslPelanggan.next()) {
                p = new Pelanggan(hslPelanggan.getString(1), hslPelanggan.getString(2),
                        hslPelanggan.getString(3), hslPelanggan.getString(4));
                pelanggan.add(p);
            }

            for (Pelanggan x : pelanggan) {
                String qPesanan = "select * from t_pesanan where id_pelanggan= "
                        + "'" + x.getIdPelanggan() + "' AND jenis_pesanan = 'Transport'";
                hslPesanan = db.getData(qPesanan);
                while (hslPesanan.next()) {
                    x.createPesanan(hslPesanan.getString(1), hslPesanan.getString(2),
                            hslPesanan.getString(3), hslPesanan.getString(4),
                            hslPesanan.getInt(5), hslPesanan.getInt(7),
                            hslPesanan.getBoolean(8), x.getJenKel());
                    pesanan.add(x.getPesanan(hslPesanan.getString(1)));
                }
            }
            
            
            for (Pelanggan x : pelanggan) {
                String qPesanan = "select * from t_pesanan where id_pelanggan= "
                        + "'" + x.getIdPelanggan() + "' AND jenis_pesanan='Kurir'";
                hslPesankurir = db.getData(qPesanan);
                while (hslPesankurir.next()) {
                    x.createPesanKurir(hslPesankurir.getString(1), hslPesankurir.getString(2),
                            hslPesankurir.getString(3), hslPesankurir.getString(4),
                            hslPesankurir.getInt(5), hslPesankurir.getString(6),
                            hslPesankurir.getInt(7), hslPesankurir.getBoolean(8), x.getJenKel());
                    kurir.add(x.getPesanan(hslPesankurir.getString(1)));
                }
            }
            

            hslPengemudi = db.getData(query2);

            while (hslPengemudi.next()) {
                d = new Pengemudi(hslPengemudi.getString(1), hslPengemudi.getString(2),
                        hslPengemudi.getString(3), hslPengemudi.getString(4));
                pengemudi.add(d);
            }

            for (Pengemudi x : pengemudi) {
                String qPesanan = "select * from t_pesanan where id_pengemudi= "
                        + "'" + x.getIdPengemudi() + "'";
                hslPesanan = db.getData(qPesanan);
                while (hslPesanan.next()) {
                    for (Pesanan y : pesanan) {
                        if (y.getIdTrans().equals(hslPesanan.getString(1))) {
                            x.loadPesanan(y);
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Load Gagal");
        }
    }
    
    public ArrayList<Pelanggan> getAllPelanggan(){
        return pelanggan;
    }
    
    public ArrayList<Pengemudi> getAllPengemudi(){
        return pengemudi;
    }

    public boolean insertPelanggan(Pelanggan p) throws SQLException {
        db.connect();
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
        db.connect();
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
        db.connect();
        String query = "insert into t_pesanan(id_transaksi, jenis_pesanan, alamat, "
                + "tujuan, jarak, tarif, status, id_pelanggan) values ('" + t.getIdTrans()
                + "', '" + t.getJenisPesanan() + "', '" + t.getAlamat()
                + "', '" + t.getTujuan() + "', " + t.getJarak() + ", "
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
        db.connect();
        String query = "insert into t_pesanan(id_transaksi, jenis_pesanan, alamat,"
                + "tujuan, jarak, nama_barang, tarif, status, id_pelanggan) "
                + "values ('" + k.getIdTrans()
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
    
    public Pesanan searchPesanan(String idTrans){
        for(Pesanan x : pesanan){
            if(x.getIdTrans().equals(idTrans)){
                return x;
            }
        }
        for(Pesanan x : kurir){
            if(x.getIdTrans().equals(idTrans)){
                return x;
            }
        }
        return null;
    }

    public boolean deletePelanggan(Pelanggan pe) throws SQLException {
        String query = "delete from Pelanggan where idPelanggan = '" + pe.getIdPelanggan() + "'";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public boolean deletePengemudi(Pengemudi pm) throws SQLException {
        String query = "delete from Pengemudi where idPengemudi= '" + pm.getIdPengemudi() + "'";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public boolean deletePesanan(Pesanan ps) throws SQLException {
        String query = "delete from t_pesanan where id_transaksi = '" + ps.getIdTrans() + "'";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public Pelanggan loginPelanggan(String nama, String no_telp){
        for(Pelanggan p : pelanggan){
            if(p.getNama().equals(nama) && p.getNoTelp().equals(no_telp)){
                return p;
            }
        }
        return null;
    }
    public Pengemudi loginPengemudi(String nama, String no_telp){
        for(Pengemudi d : pengemudi){
            System.out.println(nama);
            System.out.println(no_telp);
            System.out.println(d.getNama());
            System.out.println(d.getNoTelp());
            if(d.getNama().equals(nama) && d.getNoTelp().equals(no_telp)){
                return d;
            }
        }
        return null;
    }
    
//    public boolean cekLoginPelanggan(Pelanggan p) throws SQLException {
//        db.connect();
//        String query = "select * from t_pelanggan where nama_pelanggan = '"
//                + p.getNama() + "' and no_telp = '" + p.getNoTelp() + "'";
//        ResultSet hasil = db.getData(query);
//        if (hasil.next()) {
//            UserSession.setId_ss(hasil.getString("id_pelanggan"));
//            UserSession.setNama_ss(hasil.getString("nama_pelanggan"));
//            UserSession.setJenkel_ss(hasil.getString("jenis_kelamin"));
//            UserSession.setNotelp_ss(hasil.getString("no_telp"));
//            db.disconnect();
//            System.out.println("Login Sukses");
//            return true;
//        } else {
//            db.disconnect();
//            System.out.println("Gagal Login");
//            return false;
//        }
//    }

    public boolean updatePelanggan(Pelanggan p) throws SQLException {
        db.connect();
        String query = "update t_pelanggan set nama = '" + p.getNama() + "' ,'"
                + "set jenis_kelamin = '" + p.getJenKel() + "' ,'"
                + "set no_telp = '" + p.getNoTelp() + "' ,'"
                + "where idPelanggan = '" + p.getIdPelanggan() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }

    }

    public boolean updatePengemudi(Pengemudi d) throws SQLException {
        db.connect();
        String query = "update t_pengemudi set nama = '" + d.getNama() + "' ,'"
                + "set jenis_kelamin = '" + d.getJenKel() + "' ,'"
                + "set no_telp = '" + d.getNoTelp() + "' ,'"
                + "where idPelanggan = '" + d.getIdPengemudi() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }

    }

    public boolean updatePesanan(Pesanan t, String idPengemudi) throws SQLException {
        db.connect();
        String query = "update t_pesanan set status = " + t.getStatus()
                + ", id_pengemudi = '" + idPengemudi + "' where id_transaksi = '" 
                + t.getIdTrans() + "'";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public boolean updatePesananKurir(Kurir k, String idPelanggan) throws SQLException {
        db.connect();
        String query = "update t_pesanan set jenis_pesanan = '" + k.getJenisPesanan() + "', '"
                + "set alamat = '" + k.getAlamat()
                + "', '" + "set tujuan ='" + k.getTujuan() + "', '"
                + "set jarak = '" + k.getJarak() + ", "
                + "set tarif = '" + k.getTarif() + ", " + "set status = '" + k.getStatus() + "' ,'"
                + "set nama_barang = '" + k.getNamaBarang() + "' ,'"
                + "where id_transaksi = '" + k.getIdTrans() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }

    }
}
