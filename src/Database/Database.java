/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class Database {
    private Connection cn;
    private Statement st;
    
     public void connect()throws SQLException{
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport online/", "myproject", "transport");
            st = (Statement) cn.createStatement();
            System.out.println("sudah connect");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect()throws SQLException{
        try {
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  
    public boolean manipulasiData(String query)throws SQLException{
        try {
            if (st.executeUpdate(query) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public ResultSet getData(String query)
    {
        
        try {
            return st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
