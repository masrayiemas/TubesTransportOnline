/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportonline;

/**
 *
 * @author Rayiemas Manggala P
 */
public class Kurir extends Pesanan{
    private String namaBarang;
    
    public Kurir(String idTrans, String jenisPesanan, String alamat, String tujuan, int tarif, 
            int jarak, String namaBarang, String jk) {
        super(idTrans, jenisPesanan, alamat, tujuan, tarif, jarak, jk);
        this.namaBarang=namaBarang;
    }
    
    public void setNamaBarang(String namaBarang) {
        this.namaBarang=namaBarang;
    }
    
    public String getNamaBarang(){
        return namaBarang;
    }
}
