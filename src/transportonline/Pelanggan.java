/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportonline;

import config.Database;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rayiemas Manggala P
 */
public class Pelanggan extends Orang implements Serializable {

    private Pesanan[] pesanan;
    private String idPelanggan;
    private int jmlPesanan;
    private static int countPel;

    public Pelanggan(String nama, String jenKel, String noTelp) {
        super(nama, jenKel, noTelp);
        pesanan = new Pesanan[100];
        countPel++;
        try {
            this.setIdPelanggan(makeIdPelanggan());
        } catch (SQLException ex) {
            System.out.println("Make Id Failed.");
        }
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void createPesanan(String jenisPesanan, String alamat,
            String tujuan, int jarak, int tarif) {
        pesanan[jmlPesanan] = new Pesanan(jenisPesanan, alamat,
                tujuan, jarak, tarif, super.getJenKel());
        jmlPesanan++;
    }

    public void createPesananKurir(String jenisPesanan, String alamat,
            String tujuan, int jarak, int tarif, String namaBarang) {
        pesanan[jmlPesanan] = new Kurir(jenisPesanan,
                alamat, tujuan, jarak, tarif, namaBarang, super.getJenKel());
        jmlPesanan++;
    }

    public void removePesanan(String idTrans) {
        boolean found = false;
        for (int i = 0; i < jmlPesanan; i++) {
            if (pesanan[i].getIdTrans().equals(idTrans)) {
                found = true;
                for (int j = i; j < jmlPesanan; j++) {
                    pesanan[j] = pesanan[j + 1];
                }
                jmlPesanan--;
                System.out.println("Data Berhasil Dihapus.");
                break;
            }
        }
        if (found == false) {
            System.out.println("Pesanan Tidak Ditemukan.");
        }
    }

    public Pesanan getPesanan(int n) {
        return pesanan[n];
    }

    public Pesanan getPesanan(String idTrans) {
        boolean found = false;
        Pesanan p = null;
        for (int i = 0; i < jmlPesanan; i++) {
            if (pesanan[i].getIdTrans().equals(idTrans)) {
                found = true;
                p = pesanan[i];
                break;
            }
        }
        return p;
    }

    public int getJmlPesanan() {
        return jmlPesanan;
    }

    public String makeIdPelanggan() throws SQLException {
        Database db = new Database();
        db.connect();
        int data = 0;
        String query = "select * from counter";
        ResultSet hasil = db.getData(query);
        try {
            if (hasil.next()) {
                data = hasil.getInt("countpelanggan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        data++;
        String id = "P";
        if (data / 10 > 9) {
            id = id + data;
        } else if (data / 10 > 0) {
            id = id + "0" + data;
        } else {
            id = id + "00" + data;
        }
        String queryupdate = "update counter set countpelanggan = " + data
                + " where no = 1";
        db.manipulasiData(queryupdate);
        return id;
    }

}
