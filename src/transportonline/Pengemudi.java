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
public class Pengemudi extends Orang implements Serializable{

  private Pesanan[] pesanan;
    private String idPengemudi;
    private int jmlPesanan;
    private static int countPeng;

    public Pengemudi(String nama, String jenKel, String noTelp) {
        super(nama, jenKel, noTelp);
        pesanan = new Pesanan[100];
        jmlPesanan = 0;
        countPeng++;
        this.setIdPengemudi(makeIdPengemudi());
    }

    public String getIdPengemudi() {
        return idPengemudi;
    }

    public void setIdPengemudi(String idPengemudi) {
        this.idPengemudi = idPengemudi;
    }

    public void addPesanan(Pesanan p) {
        if (p.getJenisPesanan().equals("Kurir")) {
            pesanan[jmlPesanan] = p;
            p.setTaken();
            jmlPesanan++;
        } else if (p.getJk().equals(super.getJenKel())) {
            pesanan[jmlPesanan] = p;
            p.setTaken();
            jmlPesanan++;
        } else {
            System.out.println("Anda Tidak Bisa Mengambil Pesanan ini.");
        }
    }

    public Pesanan getPesanan(int n) {
        return pesanan[n];
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
    
    public int getJmlPesanan() {
        return jmlPesanan;
    }
    
    public String makeIdPengemudi() {
        String id = "D";
        if (Pengemudi.countPeng / 10 > 9) {
            id = id + Pengemudi.countPeng;
        } else if (Pengemudi.countPeng / 10 > 0) {
            id = id + "0" + Pengemudi.countPeng;
        } else {
            id = id + "00" + Pengemudi.countPeng;
        }
        return id;
    }
}
