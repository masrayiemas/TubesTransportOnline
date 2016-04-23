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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Marwah
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setFrameToCenter();
    }
    
    public void setFrameToCenter() {
        Dimension scrnSize = Toolkit.getDefaultToolkit( ).getScreenSize();
        int w = getSize( ).width+900;
        int h = getSize( ).height;
        int x = ((scrnSize.width-w));
        int y = ((scrnSize.height-h+10) / 2);
        setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelNama = new javax.swing.JLabel();
        jLabelNoTelp = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtNotelp = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelLogin.setText("Aplikasi Pemesanan Transportasi Online");

        jLabelNama.setText("Nama                                : ");

        jLabelNoTelp.setText("No. Telepon                      :");

        jButtonLogin.setText("Login");

        jButtonBack.setText("Back");

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabelNama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabelLogin))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonLogin)
                            .addComponent(jLabelNoTelp))
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButtonBack)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelLogin)
                .addGap(25, 25, 25)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNoTelp)
                    .addComponent(txtNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonBack))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getjButtonLogin() {
        return jButtonLogin;
    }

    public void setjButtonLogin(JButton jButtonLogin) {
        this.jButtonLogin = jButtonLogin;
    }

    public JLabel getjLabelLogin() {
        return jLabelLogin;
    }

    public void setjLabelLogin(JLabel jLabelLogin) {
        this.jLabelLogin = jLabelLogin;
    }

    public JLabel getjLabelNama() {
        return jLabelNama;
    }

    public void setjLabelNama(JLabel jLabelNama) {
        this.jLabelNama = jLabelNama;
    }

    public JLabel getjLabelNoTelp() {
        return jLabelNoTelp;
    }

    public void setjLabelNoTelp(JLabel jLabelNoTelp) {
        this.jLabelNoTelp = jLabelNoTelp;
    }

    public JPanel getjPanelLogin() {
        return jPanelLogin;
    }

    public void setjPanelLogin(JPanel jPanelLogin) {
        this.jPanelLogin = jPanelLogin;
    }

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    public void setjButtonBack(JButton jButtonBack) {
        this.jButtonBack = jButtonBack;
    }

    public JTextField getTxtNama() {
        return txtNama;
    }

    public void setTxtNama(JTextField txtNama) {
        this.txtNama = txtNama;
    }

    public JTextField getTxtNotelp() {
        return txtNotelp;
    }

    public void setTxtNotelp(JTextField txtNotelp) {
        this.txtNotelp = txtNotelp;
    }

    public void addListener(ActionListener e){
        jButtonLogin.addActionListener(e);
        jButtonBack.addActionListener(e);
    }
    
     public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void showMessage(String message, String title, int type){
        JOptionPane.showMessageDialog(null, message, title, type);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelNoTelp;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNotelp;
    // End of variables declaration//GEN-END:variables
}
