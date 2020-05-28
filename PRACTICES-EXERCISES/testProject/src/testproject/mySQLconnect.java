
package testproject;

import java.sql.*;
import javax.swing.*;

public class mySQLconnect {
    
    Connection conn = null;
    
    public static Connection connectDb(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testproject", "root", "");
            //JOptionPane.showMessageDialog(null, "connection to database established");
            return conn;
    
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, ex);
            return null;
            
        }
    }
}
