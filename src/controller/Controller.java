/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Application;
import transportonline.Kurir;
import transportonline.Pelanggan;
import transportonline.Pengemudi;
import transportonline.Pesanan;
import view.Login;
import view.LoginPengemudi;
import view.MenuPelanggan;
import view.MenuPengemudi;
import view.Pesan;
import view.PesanKurir;
import view.PesananView;
import view.RiwayatPemesanan;
import view.RiwayatPesanan;
import view.SignUp;
import view.SignUpLogin;

/**
 *
 * @author lenovo
 */
public class Controller extends MouseAdapter implements ActionListener {

    private Application app;
    private SignUpLogin index;
    private Login loginPlg;
    private LoginPengemudi loginPng;
    private SignUp signUp;
    private MenuPelanggan menupel;
    private MenuPengemudi menupeng;
    private Pesan pesan;
    private PesanKurir psnkurir;
    private RiwayatPemesanan rpms;
    private RiwayatPesanan rps;
    private PesananView psnview;
    private RiwayatPesanan rpsn;
    public static Pelanggan plgSess;
    public static Pengemudi pngSess;

    public Controller() {
        app = new Application();
        index = new SignUpLogin();
        signUp = new SignUp();
        loginPlg = new Login();
        loginPng = new LoginPengemudi();
        pesan = new Pesan();
        menupel = new MenuPelanggan();
        menupeng = new MenuPengemudi();
        rpms = new RiwayatPemesanan();
        rps = new RiwayatPesanan();
        psnview = new PesananView();
        psnkurir = new PesanKurir();
        rpsn = new RiwayatPesanan();

        app.loadData();
        loginPng.addListener(this);
        rpms.AddListener(this);
        rps.AddListener(this);
        psnview.AddListener(this);
        psnkurir.AddListener(this);
        index.AddListener(this);
        pesan.AddListener(this);
        signUp.AddListener(this);
        menupel.AddListener(this);
        menupeng.AddListener(this);
        loginPlg.addListener(this);
        index.setVisible(true);
        loginPng.setVisible(true);
        rpsn.AddListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Index
        if (src.equals(index.getjButtonSignUp())) {
            index.setVisible(false);
            signUp.setVisible(true);
        }
        if (src.equals(index.getjButtonLogin())) {
            index.setVisible(false);
            loginPlg.setVisible(true);
        }

        //SignUp
        if (src.equals(signUp.getjButtonSignUp())) {
            try {
                Pelanggan p = new Pelanggan(signUp.getTxtNama().getText(),
                        signUp.getTxtJenkel().getText(),
                        signUp.getTxtNotelp().getText());
                if (app.insertPelanggan(p)) {
                    signUp.showMessage("Insert Berhasil !!");
                    app.loadData();
                    signUp.setVisible(false);
                    index.setVisible(true);
                } else {
                    signUp.showMessage("Insert gagal coy !!!", "ERROR INSERT",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println("Insert Error");
            }
        }
        if (src.equals(signUp.getjButtonBack())) {
            try {
                signUp.setVisible(false);
                index.setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }

        //Login
        if (src.equals(loginPlg.getjButtonLogin())) {
            try {
                String nama = loginPlg.getTxtNama().getText();
                String notelp = loginPlg.getTxtNotelp().getText();
                plgSess = app.loginPelanggan(nama, notelp);
                if (plgSess != null) {
                    loginPlg.showMessage("Login Sukses");
                    loginPlg.setVisible(false);
                    menupel.setVisible(true);
                } else {
                    loginPlg.showMessage("Login Gagal");
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        if (src.equals(loginPng.getjButtonLogin())) {
            try {
                String nama = loginPng.getTxtNama().getText();
                String notelp = loginPng.getTxtNotelp().getText();
                pngSess = app.loginPengemudi(nama, notelp);
                if (pngSess != null) {
                    loginPng.showMessage("Login Sukses");
                    loginPng.setVisible(false);
                    menupeng.setVisible(true);
                } else {
                    loginPng.showMessage("Login Gagal");
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        if (src.equals(loginPlg.getjButtonBack())) {
            try {
                loginPlg.setVisible(false);
                index.setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }

        //Menu Pelanggan
        if (src.equals(menupel.getjButtonTransportasi())) {
            try {
                pesan.setVisible(true);
                menupel.setVisible(false);
            } catch (Exception ae) {
                pesan.showMessage("Gagal");
                ae.printStackTrace();
            }
        }
        if (src.equals(menupel.getjButtonRiwayatPemesanan())) {
            try {
                menupel.setVisible(false);
                addPemesananToTable(rpms.getjTableRiwayat(), plgSess);
                rpms.setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        if (src.equals(rpms.getjButtonCancelPesanan())) {
            try {
                String id_trans = rpms.getjTableRiwayat().getValueAt(
                        rpms.getjTableRiwayat().getSelectedRow(), 0).toString();
                System.out.println(id_trans);
                Pesanan p = app.searchPesanan(id_trans);
                if (p != null) {
                    plgSess.removePesanan(p.getIdTrans());
                    try {
                        if (app.deletePesanan(p)) {
                            rpms.showMessage("Pesanan Berhasil Dibatalkan");
                            app.loadData();
                            addPemesananToTable(rpms.getjTableRiwayat(), plgSess);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        if (src.equals(menupel.getjButtonKurir())) {
            try {
                menupel.setVisible(false);
                psnkurir.setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        if (src.equals(rpms.getBtnBack())) {
            menupel.setVisible(true);
            rpms.setVisible(false);
        }


        //MenuPengemudi
        if (src.equals(menupeng.getjButtonAmbilPesanan())) {
            try {
                menupeng.setVisible(false);
                addPesananToTable(psnview.getjTablePesanan(), app.getAllPelanggan(), pngSess);
                psnview.setVisible(true);
            } catch (Exception xe) {
                xe.printStackTrace();
            }
        }

        //PesanTransport
        if (src.equals(pesan.getjButtonPesan())) {
            try {
                Pesanan p = plgSess.createPesanan("Transport", pesan.getjTextFieldLokasi().getText(),
                        pesan.getjTextFieldTujuan().getText(),
                        Integer.parseInt(pesan.getjTextFieldJarak().getText()),
                        Integer.parseInt(pesan.getjTextFieldTarif().getText()));
                if (app.insertPesanan(p, plgSess.getIdPelanggan())) {
                    pesan.showMessage("Pesanan Sukses");
                    app.loadData();
                    pesan.getjTextFieldJarak().setText("");
                    pesan.getjTextFieldLokasi().setText("");
                    pesan.getjTextFieldTarif().setText("");
                    pesan.getjTextFieldTujuan().setText("");
                    menupel.setVisible(true);
                    pesan.setVisible(false);
                } else {
                    pesan.showMessage("Input Gagal");
                    pesan.getjTextFieldJarak().setText("");
                    pesan.getjTextFieldLokasi().setText("");
                    pesan.getjTextFieldTarif().setText("");
                    pesan.getjTextFieldTujuan().setText("");
                    menupel.setVisible(true);
                    pesan.setVisible(false);
                }
            } catch (Exception ea) {
                ea.printStackTrace();
                menupel.setVisible(true);
                pesan.setVisible(false);
            }
        }
        //PesananKurir
        if (src.equals(psnkurir.getjButtonPesan())) {
            try {
                Kurir k = plgSess.createPesananKurir("Kurir", psnkurir.getjTextFieldLokasi().getText(),
                        psnkurir.getjTextFieldTujuan().getText(),
                        Integer.parseInt(psnkurir.getjTextFieldJarak().getText()),
                        Integer.parseInt(psnkurir.getjTextFieldTarif().getText()),
                        psnkurir.getjTextFieldJenisBarang().getText());
                if (app.insertPesanan(k, plgSess.getIdPelanggan())) {
                    psnkurir.showMessage("Pesanan Sukses");
                    app.loadData();
                    psnkurir.getjTextFieldJarak().setText("");
                    psnkurir.getjTextFieldLokasi().setText("");
                    psnkurir.getjTextFieldTarif().setText("");
                    psnkurir.getjTextFieldTujuan().setText("");
                    menupel.setVisible(true);
                    psnkurir.setVisible(false);
                } else {
                    psnkurir.showMessage("Pesanan Sukses");
                    psnkurir.getjTextFieldJarak().setText("");
                    psnkurir.getjTextFieldLokasi().setText("");
                    psnkurir.getjTextFieldTarif().setText("");
                    psnkurir.getjTextFieldTujuan().setText("");
                    menupel.setVisible(true);
                    psnkurir.setVisible(false);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                menupel.setVisible(true);
                psnkurir.setVisible(false);
            }
        }

        //AmbilPesanan
        if (src.equals(psnview.getjButtonAmbilPesanan())) {
            String id_trans = psnview.getjTablePesanan().getValueAt(
                    psnview.getjTablePesanan().getSelectedRow(), 0).toString();
            System.out.println(id_trans);
            Pesanan p = app.searchPesanan(id_trans);
            if (p != null) {
                pngSess.takePesanan(p);
                try {
                    if (app.updatePesanan(p, pngSess.getIdPengemudi())) {
                        psnview.showMessage("Ambil Pesanan Berhasil");
                        psnview.setVisible(false);
                        menupeng.setVisible(true);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Salah ID");
            }
        }

        if (src.equals(psnview.getBnBack())) {
            try {
                psnview.setVisible(false);
                menupeng.setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        
        //Riwayat Pesanan Pengemudi 
        if(src.equals(menupeng.getjButtonRiwayatPesanan())){
            try {
                menupeng.setVisible(false);
                addRiwayatPesananToTable(rpsn.getjTableRiwayatPsn(), pngSess);
                rpsn.setVisible(true);
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
    }

    public void addPemesananToTable(JTable table, Pelanggan p) throws SQLException {
        Database db = new Database();
        db.connect();
        String[] columnPesanan = {"id_transaksi", "jenis_pesanan", "alamat",
            "tujuan", "tarif", "status", "id_pengemudi"};
        DefaultTableModel tb = new DefaultTableModel(columnPesanan, 0);
        String query = "select id_pengemudi from t_pesanan where id_pelanggan = "
                + "'" + p.getIdPelanggan() + "'";
        ResultSet hsl = db.getData(query);
        for (int i = 0; i < p.getJmlPesanan(); i++) {
            if (hsl.next()) {
                String[] data = {p.getPesanan(i).getIdTrans(), p.getPesanan(i).getJenisPesanan(),
                    p.getPesanan(i).getAlamat(), p.getPesanan(i).getTujuan(),
                    String.valueOf(p.getPesanan(i).getTarif()),
                    String.valueOf(p.getPesanan(i).getStatus()),
                    hsl.getString(1)};
                tb.addRow(data);
            }
        }
        table.setModel(tb);
    }
    
    public void addRiwayatPesananToTable(JTable table, Pengemudi p){
        String[] columnPesanan = {"id_transaksi", "jenis_pesanan", "tarif"};
        DefaultTableModel tb = new DefaultTableModel(columnPesanan, 0);
        for(int i=0; i<p.getJmlPesanan(); i++){
            String[] data = {p.getPesanan(i).getIdTrans(), p.getPesanan(i).getJenisPesanan(),
                             String.valueOf(p.getPesanan(i).getTarif())};
            tb.addRow(data);
        }
        table.setModel(tb);
    }

    public void addPesananToTable(JTable table, ArrayList<Pelanggan> p, Pengemudi d) throws SQLException {
        String[] columnPesanan = {"id_transaksi", "jenis_pesanan", "barang", "alamat",
            "tujuan", "status", "nama_pelanggan"};
        DefaultTableModel tb = new DefaultTableModel(columnPesanan, 0);
        for (Pelanggan x : p) {
            for (int i = 0; i < x.getJmlPesanan(); i++) {
                if (x.getPesanan(i).getStatus()
                        && x.getPesanan(i).getJk().equals(d.getJenKel())
                        && x.getPesanan(i).getJenisPesanan().equals("Transport")) {
                    System.out.println(x.getPesanan(i).getJk());
                    System.out.println(d.getJenKel());
                    String[] data = {x.getPesanan(i).getIdTrans(), x.getPesanan(i).getJenisPesanan(), "",
                        x.getPesanan(i).getAlamat(), x.getPesanan(i).getTujuan(),
                        String.valueOf(x.getPesanan(i).getStatus()), x.getNama()
                    };
                    tb.addRow(data);
                }
                if (x.getPesanan(i).getStatus() && x.getPesanan(i).getJenisPesanan().equals("Kurir")) {
                    String[] datab = {x.getPesanan(i).getIdTrans(), x.getPesanan(i).getJenisPesanan(), "",
                        x.getPesanan(i).getAlamat(), x.getPesanan(i).getTujuan(),
                        String.valueOf(x.getPesanan(i).getStatus()), x.getNama()
                    };
                    tb.addRow(datab);
                }
            }
        }
        table.setModel(tb);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
    }

}
