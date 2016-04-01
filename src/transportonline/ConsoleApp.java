/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportonline;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rayiemas Manggala P
 */
public class ConsoleApp {

    Scanner in = new Scanner(System.in);
    boolean ex = false;
    ArrayList<Pelanggan> pelanggan = new ArrayList<>();
    ArrayList<Pengemudi> pengemudi = new ArrayList<>();

//---------------------------LOGIN------------------------------
    public void loginPel() {
        boolean cek = false;
        Pelanggan p = null;
        System.out.println("Nama        : ");
        String nama = in.next();
        System.out.println("No. Telp    : ");
        String notelp = in.next();
        for (Pelanggan x : this.pelanggan) {
            if ((x.getNama().equals(nama)) && (x.getNoTelp().equals(notelp))) {
                cek = true;
                p = x;
                break;
            }
        }
        if (cek) {
            this.menuPelanggan(p);
        } else {
            System.out.println("Data Tidak Ditemukan.");
        }
    }

    public void loginPeng() {
        boolean cek = false;
        Pengemudi p = null;
        System.out.println("Nama        : ");
        String nama = in.next();
        System.out.println("No. Telp    : ");
        String notelp = in.next();
        for (Pengemudi x : this.pengemudi) {
            if ((x.getNama().equals(nama)) && (x.getNoTelp().equals(notelp))) {
                cek = true;
                p = x;
                break;
            }
        }
        if (cek) {
            this.menuPengemudi(p);
        } else {
            System.out.println("Data Tidak Ditemukan.");
        }
    }

//---------------------------MENU-------------------------------
    public void menuAdmin() {
        int a;
        System.out.println("1. Add Pelanggan");
        System.out.println("2. Add Pengemudi");
        System.out.println("3. Pesan");
        System.out.println("4. Ambil Pesanan");
        System.out.println("5. Remove Pelanggan");
        System.out.println("6. Remove Pengemudi");
        System.out.println("7. Data Pesanan");
        System.out.println("8. Exit");
        System.out.println("Masukkan Pilihan : ");
        a = in.nextInt();
        this.pilihanAdmin(a);
    }

    public void menuPelanggan(Pelanggan p) {
        int a;
        System.out.println("MENU PELANGGAN");
        System.out.println("1. Pesan Transportasi");
        System.out.println("2. Kurir");
        System.out.println("3. Riwayat Pemesanan");
        System.out.println("Masukkan Pilihan : ");
        a = in.nextInt();
        this.pilihanPel(a, p);
    }

    public void menuPengemudi(Pengemudi p) {
        int a;
        System.out.println("MENU PENGEMUDI");
        System.out.println("1. Ambil Pesanan");
        System.out.println("2. Riwayat Pemesanan");
        System.out.println("Masukkan Pilihan : ");
        a = in.nextInt();
        this.pilihanPeng(a, p);
    }

    public void pilihanAdmin(int a) {
        switch (a) {
            case 1:
                inputPlg();
                break;
            case 2:
                inputPng();
                break;
            case 3:
                loginPel();
                break;
            case 4:
                loginPeng();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                viewPesanan();
                break;
            case 8:
                ex = true;
                break;
        }
    }

    public void pilihanPel(int a, Pelanggan p) {
        switch (a) {
            case 1:
                transPesanan(p);
                break;
            case 2:
                transKurir(p);
                break;
            case 3:
                viewPesanan(p);
                break;
        }
    }

    public void pilihanPeng(int a, Pengemudi p) {
        switch (a) {
            case 1:
                ambilPesanan(p);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

//----------------------OPERASI----------------------------------
    //view Pesanan All
    public void viewPesanan(Pengemudi p) {
        this.pelanggan.stream().forEach((x) -> {
            for (int i = 0; i < x.getJmlPesanan(); i++) {
                if ((x.getJenKel().equals(p.getJenKel()))
                        && (x.getPesanan(i).getStatus())) {
                    System.out.println(x.getPesanan(i).getIdTrans());
                    System.out.println(x.getPesanan(i).getAlamat());
                    System.out.println(x.getPesanan(i).getJarak());
                    System.out.println(x.getPesanan(i).getStatus());
                }
            }
        });
    }

    //View Pesanan Pengemudi
    public void viewPesanan(Pelanggan p) {
        for (int i = 0; i < p.getJmlPesanan(); i++) {
            System.out.println(p.getPesanan(i).getIdTrans());
            System.out.println(p.getPesanan(i).getAlamat());
            System.out.println(p.getPesanan(i).getJarak());
            System.out.println(p.getPesanan(i).getStatus());
        }
    }

    public void viewPesanan() {
        this.pelanggan.stream().forEach((x) -> {
            for (int i = 0; i < x.getJmlPesanan(); i++) {
                System.out.println(x.getPesanan(i).getIdTrans());
                System.out.println(x.getPesanan(i).getAlamat());
                System.out.println(x.getPesanan(i).getJarak());
                System.out.println(x.getPesanan(i).getStatus());
            }
        });
    }

    //Input Pelanggan Baru
    public void inputPlg() {
        System.out.println("Nama Pelanggan : ");
        String nama = in.next();
        System.out.println("Jenis Kelamin  : ");
        String jenkel = in.next();
        System.out.println("No Telepon     : ");
        String notelp = in.next();
        try {
            this.addPelanggan(new Pelanggan(nama, jenkel, notelp));
            System.out.println("Data Berhasil Ditambahkan.");
        } catch (Exception e) {
            System.out.println("Data Tidak Berhasil Ditambahkan.");
        }
    }

    public void addPelanggan(Pelanggan p) {
        pelanggan.add(p);
    }

    //Input Pengemudi Baru
    public void inputPng() {
        System.out.println("Nama Pengemudi : ");
        String nama = in.next();
        System.out.println("Jenis Kelamin  : ");
        String jenkel = in.next();
        System.out.println("No Telepon     : ");
        String notelp = in.next();
        try {
            this.addPengemudi(new Pengemudi(nama, jenkel, notelp));
            System.out.println("Data Berhasil Ditambahkan.");
        } catch (Exception e) {
            System.out.println("Data Tidak Berhasil Ditambahkan.");
        }
    }

    public void addPengemudi(Pengemudi p) {
        pengemudi.add(p);
    }

    //Buat Pesanan Baru
    public void transPesanan(Pelanggan p) {
        System.out.println("ID Trans    : ");
        String idtrans = in.next();
        System.out.println("Alamat      : ");
        String alamat = in.next();
        System.out.println("Tujuan      : ");
        String tujuan = in.next();
        System.out.println("Jarak      : ");
        int jarak = in.nextInt();
        System.out.println("Harga      : ");
        int harga = in.nextInt();
        p.createPesanan(idtrans, "Transportasi", alamat,
                tujuan, jarak, harga);
    }

    public void transKurir(Pelanggan p) {
        System.out.println("ID Trans    : ");
        String idtrans = in.next();
        System.out.println("Alamat      : ");
        String alamat = in.next();
        System.out.println("Tujuan      : ");
        String tujuan = in.next();
        System.out.println("Nama Barang : ");
        String namabarang = in.next();
        System.out.println("Jarak       : ");
        int jarak = in.nextInt();
        System.out.println("Harga       : ");
        int harga = in.nextInt();
        p.createPesananKurir(idtrans, "Kurir", alamat,
                tujuan, jarak, harga, namabarang);
    }

    public void ambilPesanan(Pengemudi p) {
        viewPesanan(p);
        System.out.println("Masukkan ID Transaksi : ");
        String a = in.next();
        for (Pelanggan x : this.pelanggan) {
            if (x.getPesanan(a).getIdTrans().equals(a)) {
                p.addPesanan(x.getPesanan(a));
                break;
            }
        }
    }
    
    //Main Menu
    public void mainMenu(){
        while(!ex){
            menuAdmin();
        }
        System.out.println("Thanks");
    }
}
