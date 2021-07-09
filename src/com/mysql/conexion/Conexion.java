
package com.mysql.conexion;


import javax.swing.JOptionPane;
import java.sql.*;

public class Conexion {
        public static final String URL ="jdbc:mysql://localhost:3306/sofka?useSSL=false&serverTimezone=UTC";
    public static final String Usuario ="root";
    public static final String Password ="toor";
    
    public static Connection getConnection() throws ClassNotFoundException{
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, Usuario, Password);
            JOptionPane.showMessageDialog(null, "te has conectado exitosamente");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "no se ha podido conectar a la base de datos");
        }
        
        return con;
    }
  
}