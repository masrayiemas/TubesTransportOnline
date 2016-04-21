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
    }

    public void loadData() {
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
                    p.createPesanan(hslPesanan.getString(1), hslPesanan.getString(2),
                            hslPesanan.getString(3), hslPesanan.getString(4),
                            hslPesanan.getInt(5), hslPesanan.getInt(7),
                            hslPesanan.getBoolean(8), p.getJenKel());
                    pesanan.add(p.getPesanan(hslPesanan.getString(1)));
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
                //System.out.println(x.getIdPengemudi());
                String qPesanan = "select * from t_pesanan where id_pengemudi= "
                        + "'" + x.getIdPengemudi() + "'";
                hslPesanan = db.getData(qPesanan);
                System.out.print(x.getIdPengemudi() + " ");
                while (hslPesanan.next()) {
                    for (Pesanan y : pesanan) {
                        //System.out.println(y.getIdTrans());
                        //System.out.println(hslPesanan.getString(1));
                        if (y.getIdTrans().equals(hslPesanan.getString(1))) {
                            x.loadPesanan(y);
                        }
                    }
                    System.out.println(x.getPesanan(0).getIdTrans());
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
}
