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
public class TransportOnline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pelanggan p1 = new Pelanggan("Rayie", "L", "085258382648");
        Pelanggan p2 = new Pelanggan("Susi", "P", "081258238248");
        Pengemudi d1 = new Pengemudi("Sukiman", "L", "081546259325");
        Pengemudi d2 = new Pengemudi("Mawari", "P", "081546259325");
        
        p1.createPesanan("T001", "Transportasi", "Buahbatu", "Dago", 20, 15000);
        p1.createPesanan("T002", "Transportasi", "Bandara", "ITB", 25, 18000);
        p1.createPesananKurir("K001", "Kurir", "Antapani", "Buah Batu", 25, 18000, "Makanan");
        p2.createPesanan("T003", "Transportasi", "Stasiun Kiaracondong", "Telkom Univ", 10, 13000);
        p2.createPesananKurir("K002", "Kurir", "PBB", "PBR", 5, 5000, "Pakaian");
        
        d1.addPesanan(p1.getPesanan(0));
        d1.addPesanan(p2.getPesanan(1));
        d2.addPesanan(p1.getPesanan(1));
        d2.addPesanan(p2.getPesanan(0));
        
        System.out.println(p1.getPesanan(0).getStatus());
        p1.removePesanan("T002");
        d1.removePesanan("T002");
        
    }
    
}
