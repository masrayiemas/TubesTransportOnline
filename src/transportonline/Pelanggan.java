/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportonline;

import java.io.Serializable;

/**
 *
 * @author Rayiemas Manggala P
 */
public class Pelanggan extends Orang implements Serializable{

    private Pesanan[] pesanan;
    private String idPelanggan;
    private int jmlPesanan;
    private static int countPel;

    public Pelanggan(String nama, String jenKel, String noTelp) {
        super(nama, jenKel, noTelp);
        pesanan = new Pesanan[100];
        countPel++;
        this.setIdPelanggan(makeIdPelanggan());
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

    public String makeIdPelanggan() {
        String id = "P";
        if (Pelanggan.countPel / 10 > 9) {
            id = id + Pelanggan.countPel;
        } else if (Pelanggan.countPel / 10 > 0) {
            id = id + "0" + Pelanggan.countPel;
        } else {
            id = id + "00" + Pelanggan.countPel;
        }
        return id;
    }
    
}
