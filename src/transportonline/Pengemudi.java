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
public class Pengemudi extends Orang implements Serializable{

  private Pesanan[] pesanan;
    private String idPengemudi;
    private int jmlPesanan;
    private static int data;

    public Pengemudi(String nama, String jenKel, String noTelp) {
        super(nama, jenKel, noTelp);
        pesanan = new Pesanan[100];
        jmlPesanan = 0;
        data++;
      try {
          this.setIdPengemudi(makeIdPengemudi());
      } catch (SQLException ex) {
          System.out.println("Make Id Failed");
      }
    }

    public Pengemudi(String idPengemudi, String nama, String jenkel, String noTelp) {
        super(nama, jenkel, noTelp);
        this.idPengemudi = idPengemudi;
        pesanan = new Pesanan[100];
        jmlPesanan = 0;
    }
    
    public String getIdPengemudi() {
        return idPengemudi;
    }

    public void setIdPengemudi(String idPengemudi) {
        this.idPengemudi = idPengemudi;
    }
    
    public void loadPesanan(Pesanan p){
        pesanan[jmlPesanan] = p;
        jmlPesanan++;
    }
    
    public void takePesanan(Pesanan p){
        pesanan[jmlPesanan] = p;
        p.setTaken();
        jmlPesanan++;
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
    
    public String makeIdPengemudi() throws SQLException {
        Database db = new Database();
        db.connect();
        int datape = 0;
        String query = "select * from counter";
        ResultSet hasil = db.getData(query);
        try {
            if (hasil.next()) {
                datape = hasil.getInt("countpelanggan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        datape++;
        String id = "D";
        if (datape / 10 > 9) {
            id = id + datape;
        } else if (datape / 10 > 0) {
            id = id + "0" + datape;
        } else {
            id = id + "00" + datape;
        }
        String queryupdate = "update counter set countpengemudi = " + data
                + " where no = 1";
        db.manipulasiData(queryupdate);
        return id;
    }
}
