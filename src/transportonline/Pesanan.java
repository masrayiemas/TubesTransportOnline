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
public class Pesanan {

    private String idTrans;
    private String jenisPesanan;
    private String tujuan;
    private int tarif;
    private int jarak;
    private String alamat;
    private boolean status;
    private String jk;
    protected static int countTrans; 

    public Pesanan(String idTrans, String jenisPesanan, String alamat, String tujuan,
            int tarif, int jarak, String jk) {
        this.idTrans = idTrans;
        this.jenisPesanan = jenisPesanan;
        this.tujuan = tujuan;
        this.tarif = tarif;
        this.alamat = alamat;
        this.jarak = jarak;
        this.status = true;
        this.jk = jk;
        countTrans++;
    }

    public void setIdTrans(String idTrans) {
        this.idTrans = idTrans;
    }

    public String getIdTrans() {
        return idTrans;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJenisPesanan(String jenisPesanan) {
        this.jenisPesanan = jenisPesanan;
    }

    public String getJenisPesanan() {
        return jenisPesanan;
    }

    public void setTaken() {
        if(this.status){
            this.status = false;
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getTarif() {
        return tarif;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    public int getJarak() {
        return jarak;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }
    
}
