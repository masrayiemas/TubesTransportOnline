/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Database;
import config.UserSession;
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
    private Database db;

    public Application() {
        db = new Database();
    }

    public void loadData() {
        pelanggan = new ArrayList<>();
        pengemudi = new ArrayList<>();
        pesanan = new ArrayList<>();
        ResultSet hslPelanggan = null;
        ResultSet hslPengemudi = null;
        ResultSet hslPesanan = null;
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
                        + "'" + x.getIdPelanggan() + "'";
                hslPesanan = db.getData(qPesanan);
                while (hslPesanan.next()) {
                    x.createPesanan(hslPesanan.getString(1), hslPesanan.getString(2),
                            hslPesanan.getString(3), hslPesanan.getString(4),
                            hslPesanan.getInt(5), hslPesanan.getInt(7),
                            hslPesanan.getBoolean(8), p.getJenKel());
                    pesanan.add(x.getPesanan(hslPesanan.getString(1)));
                }
            }
            
            for(Pesanan x : pesanan){
                System.out.println(x.getIdTrans());
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
        String query = "delete from Pesanan where idTrans = '" + ps.getIdTrans() + "'";
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
    
    public boolean cekLoginPelanggan(Pelanggan p) throws SQLException {
        db.connect();
        String query = "select * from t_pelanggan where nama_pelanggan = '"
                + p.getNama() + "' and no_telp = '" + p.getNoTelp() + "'";
        ResultSet hasil = db.getData(query);
        if (hasil.next()) {
            UserSession.setId_ss(hasil.getString("id_pelanggan"));
            UserSession.setNama_ss(hasil.getString("nama_pelanggan"));
            UserSession.setJenkel_ss(hasil.getString("jenis_kelamin"));
            UserSession.setNotelp_ss(hasil.getString("no_telp"));
            db.disconnect();
            System.out.println("Login Sukses");
            return true;
        } else {
            db.disconnect();
            System.out.println("Gagal Login");
            return false;
        }
    }

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

    public boolean updatePesanan(Pesanan t, String idPelanggan) throws SQLException {
        db.connect();
        String query = "update t_pesanan set jenis_pesanan = '" + t.getJenisPesanan() + "', '"
                + "set alamat = '" + t.getAlamat()
                + "', '" + "set tujuan ='" + t.getTujuan() + "', "
                + "set jarak = '" + t.getJarak() + ", "
                + "set tarif = '" + t.getTarif() + ", " + "set status = '" + t.getStatus()
                + "where id_transaksi = '" + t.getIdTrans() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public boolean updatePesanan(Kurir k, String idPelanggan) throws SQLException {
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
