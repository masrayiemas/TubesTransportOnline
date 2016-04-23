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
public class Kurir extends Pesanan implements Serializable{
    private String namaBarang;

    public Kurir(String idTrans, String jenisPesanan, 
            String alamat, String tujuan, int jarak,
            String namaBarang, int tarif, boolean status, String jk) {
        super(idTrans, jenisPesanan, alamat, tujuan, tarif, jarak, status, jk);
        this.namaBarang = namaBarang;
    }
    
    public Kurir(String jenisPesanan, String alamat, String tujuan, int jarak, 
                String namaBarang, int tarif,  String jk) {
        super(jenisPesanan, alamat, tujuan, tarif, jarak, jk);
        this.namaBarang=namaBarang;
    }
    
    public void setNamaBarang(String namaBarang) {
        this.namaBarang=namaBarang;
    }
    
    public String getNamaBarang(){
        return namaBarang;
    }
}
