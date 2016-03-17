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
public abstract class Orang {
    private String nama;
    private String jenKel;
    private String noTelp;
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setJenKel(String jenKel){
        this.jenKel=jenKel;
    }
    
    public String getJenKel(){
        return jenKel;
    }

    public void setNoTelp(String telp){
        this.noTelp= telp;
    }
    
    public String getNoTelp(){
        return noTelp;
    
    }
}
