/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.simple.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INT303
 */
public class BuildConnection {
    private static final String DRIVER="org.apache.derby.jdbc.ClientDriver";
    private static final String URL="jdbc:derby://localhost:1527/classicmodel";
    private static final String USERNAME="app";
    private static final String PASSWORD="app";
    private static boolean isLoad = false;
    
    public static Connection getConnection(){
        Connection conn = null;
        if(!isLoad){
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BuildConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            isLoad=true;
        }
        try{
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(SQLException ex){
            Logger.getLogger(BuildConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
       }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    
}
