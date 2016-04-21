/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Application;
import transportonline.Pelanggan;
import view.SignUp;
import view.SignUpLogin;

/**
 *
 * @author lenovo
 */
public class Controller extends MouseAdapter implements ActionListener{

    private Application app;
    private SignUpLogin index;
    private SignUp signUp;
    private String idPelangganTemp;
    
    public Controller(){
        app = new Application();
        index = new SignUpLogin();
        signUp = new SignUp();
        index.AddListener(this);
        signUp.AddListener(this);
        index.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        //Index
        if(src.equals(index.getjButtonSignUp())){
            index.setVisible(false);
            signUp.setVisible(true);
        }
        
        //SignUp
        if(src.equals(signUp.getjButtonSignUp())){
            try {
                Pelanggan p = new Pelanggan(signUp.getTxtNama().getText(),
                        signUp.getTxtJenkel().getText(),
                        signUp.getTxtNotelp().getText());
                if (app.insertPelanggan(p))
                {
                    signUp.showMessage("Insert Berhasil !!");
                }
                else
                {
                    signUp.showMessage("Insert gagal coy !!!", "ERROR INSERT", 
                                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println("Insert Error");
            }
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
