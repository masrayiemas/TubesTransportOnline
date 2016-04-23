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
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSignUp = new javax.swing.JPanel();
        jLabelNama = new javax.swing.JLabel();
        jLabelJk = new javax.swing.JLabel();
        jLabelNoTelp = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtJenkel = new javax.swing.JTextField();
        txtNotelp = new javax.swing.JTextField();
        jButtonSignUp = new javax.swing.JButton();
        jLabelSignUp = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNama.setText("Nama                           : ");

        jLabelJk.setText("Jenis Kelamin               :");

        jLabelNoTelp.setText("No. Telepon                 :");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        jButtonSignUp.setText("Sign Up");

        jLabelSignUp.setText("Aplikasi Pemesanan Transportasi Online");

        jButtonBack.setText("Back");

        javax.swing.GroupLayout jPanelSignUpLayout = new javax.swing.GroupLayout(jPanelSignUp);
        jPanelSignUp.setLayout(jPanelSignUpLayout);
        jPanelSignUpLayout.setHorizontalGroup(
            jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSignUpLayout.createSequentialGroup()
                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSignUpLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelSignUpLayout.createSequentialGroup()
                                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNama)
                                    .addComponent(jLabelJk))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJenkel, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(txtNama)))
                            .addGroup(jPanelSignUpLayout.createSequentialGroup()
                                .addComponent(jLabelNoTelp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelSignUpLayout.createSequentialGroup()
                                        .addComponent(jButtonSignUp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBack)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtNotelp, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
                    .addGroup(jPanelSignUpLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabelSignUp)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanelSignUpLayout.setVerticalGroup(
            jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSignUpLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelSignUp)
                .addGap(34, 34, 34)
                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJk)
                    .addComponent(txtJenkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNoTelp)
                    .addComponent(txtNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanelSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSignUp)
                    .addComponent(jButtonBack))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    /**
     * @param args the command line arguments
     */

    public JButton getjButtonSignUp() {
        return jButtonSignUp;
    }

    public void setjButtonSignUp(JButton jButtonSignUp) {
        this.jButtonSignUp = jButtonSignUp;
    }

    public JLabel getjLabelJk() {
        return jLabelJk;
    }

    public void setjLabelJk(JLabel jLabelJk) {
        this.jLabelJk = jLabelJk;
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

    public JLabel getjLabelSignUp() {
        return jLabelSignUp;
    }

    public void setjLabelSignUp(JLabel jLabelSignUp) {
        this.jLabelSignUp = jLabelSignUp;
    }

    public JPanel getjPanelSignUp() {
        return jPanelSignUp;
    }

    public void setjPanelSignUp(JPanel jPanelSignUp) {
        this.jPanelSignUp = jPanelSignUp;
    }

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    public void setjButtonBack(JButton jButtonBack) {
        this.jButtonBack = jButtonBack;
    }

    public JTextField getTxtJenkel() {
        return txtJenkel;
    }

    public void setTxtJenkel(JTextField txtJenkel) {
        this.txtJenkel = txtJenkel;
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

    public void AddListener(ActionListener e){
        jButtonSignUp.addActionListener(e);
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
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JLabel jLabelJk;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelNoTelp;
    private javax.swing.JLabel jLabelSignUp;
    private javax.swing.JPanel jPanelSignUp;
    private javax.swing.JTextField txtJenkel;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNotelp;
    // End of variables declaration//GEN-END:variables
}
