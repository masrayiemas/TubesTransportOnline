/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marwah
 */
public class MenuPengemudi extends javax.swing.JFrame {

    /**
     * Creates new form MenuDriver
     */
    public MenuPengemudi() {
        initComponents();
        setFrameToCenter();
    }

    public void setFrameToCenter() {
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width + 90;
        int h = getSize().height;
        int x = ((scrnSize.width - w));
        int y = ((scrnSize.height - h + 10) / 2);
        setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAmbilPesanan = new javax.swing.JButton();
        jButtonRiwayatPesanan = new javax.swing.JButton();
        jLabelMenuDriver = new javax.swing.JLabel();
        jLabelDriver = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAmbilPesanan.setText("Ambil Pesanan");

        jButtonRiwayatPesanan.setText("Riwayat Pesanan");

        jLabelMenuDriver.setText("Aplikasi Pemesanan Transportasi Online");

        jLabelDriver.setText("Driver");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButtonAmbilPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jButtonRiwayatPesanan)
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabelDriver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabelMenuDriver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabelMenuDriver)
                .addGap(18, 18, 18)
                .addComponent(jLabelDriver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAmbilPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRiwayatPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public JButton getjButtonAmbilPesanan() {
        return jButtonAmbilPesanan;
    }

    public void setjButtonAmbilPesanan(JButton jButtonAmbilPesanan) {
        this.jButtonAmbilPesanan = jButtonAmbilPesanan;
    }

    public JButton getjButtonRiwayatPesanan() {
        return jButtonRiwayatPesanan;
    }

    public void setjButtonRiwayatPesanan(JButton jButtonRiwayatPesanan) {
        this.jButtonRiwayatPesanan = jButtonRiwayatPesanan;
    }

    public JLabel getjLabelDriver() {
        return jLabelDriver;
    }

    public void setjLabelDriver(JLabel jLabelDriver) {
        this.jLabelDriver = jLabelDriver;
    }

    public JLabel getjLabelMenuDriver() {
        return jLabelMenuDriver;
    }

    public void setjLabelMenuDriver(JLabel jLabelMenuDriver) {
        this.jLabelMenuDriver = jLabelMenuDriver;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public void AddListener(ActionListener e) {
        jButtonAmbilPesanan.addActionListener(e);
        jButtonRiwayatPesanan.addActionListener(e);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAmbilPesanan;
    private javax.swing.JButton jButtonRiwayatPesanan;
    private javax.swing.JLabel jLabelDriver;
    private javax.swing.JLabel jLabelMenuDriver;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}