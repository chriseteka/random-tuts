
package testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class actionRoom {
    Scanner input = new Scanner(System.in);
    
    //HERE I TRY TO FIX THE ISSUES I HAD WITH MY DATABASE FETCHING, EDITING AND DELETING.
    
    //SQL STATEMENTS THAT WILL BE USED ALTHROUGH TO THE END.
    String stmt1 = "SELECT * FROM staffdetails";
    String stmt2 = "DELETE FROM `staffdetails` WHERE staffid=?";
    String stmt3 = "UPDATE `staffdetails` SET`staffname`=?,`staffage`=?,`staffposition`=? WHERE `staffid`=?";
    String stmt4 = "SELECT * FROM `staffdetails` WHERE `staffid`=?";
    String stmt5 = "INSERT INTO staffdetails (staffid,staffname,staffage,staffposition) VALUES (?, ?, ?, ?)";
    
    //SOME NEEDED SHIRH
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //CONNECTING TO MY DB THROUGH MY DB CONNECTION CLASS PLAY_CON, FOR TEST PURPOSE.
    public void co(){
        conn = mySQLconnect.connectDb();
        JOptionPane.showMessageDialog(null, "Successfully connected to the DB");
    }
    
    //METHOD FOR VIEWING ALL EXISTING ELEMENTS IN TH DATABASE
    public void dataView(String stmt){
        try{
            Statement st = conn.createStatement();
            st.executeQuery(stmt1);
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                String uniID = rs.getString("staffid");
                System.out.println("STAFF ID IS: " +uniID);
                String name = rs.getString("staffname");
                System.out.println("STAFF NAME IS: " +name);
                int age = rs.getInt("staffage");
                System.out.println("STAFF AGE IS: " +age);
                String position = rs.getString("staffposition");
                System.out.println("STAFF POSITION IS: " +position);
                System.out.println();
                System.out.println("*********************************************");
            }
            
            //closing connection after this executes.
            conn.close();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //METHOD FOR DELETING AN ITEM FROM THE DATABASE
    public void delete(String stmt){
        String th;
        System.out.println("ENTER A USERNAME YOU WANT TO DELETE FROM THE DATABASE: ");
        th = input.nextLine();
        try{
            pst=conn.prepareStatement(stmt2);
            pst.setString(1, th);
            int rowsDeleted = pst.executeUpdate();
            
            if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
            }
            else{
                System.out.println("User does not exist in the database");
            }
            System.out.println("");
            System.out.println("WHAT IS LEF IS: ");
            System.out.println("********************************************");
            dataView(stmt1);
            conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //METHOD FOR UPDATING DATA IN THE DATABASE
    public void update(String stmt){
        int newAge;
        String th, newName, newPosition;
        System.out.println("ENTER USERID TO BE UPDATED: ");
        th = input.nextLine();
        check(stmt4,th);//Checks if the data exists before updating commences
        System.out.println("");
        System.out.println("*******************************");
        System.out.println("ENTER NEW USER NAME: ");
        newName = input.nextLine();
        System.out.println("ENTER NEW POSITION: ");
        newPosition = input.nextLine();
        System.out.println("ENTER NEW AGE: ");
        newAge = input.nextInt();
        System.out.println("****************************");
        try{
            pst=conn.prepareStatement(stmt3);
            pst.setString(1, newName);
            pst.setInt(2, newAge);
            pst.setString(3, newPosition);
            pst.setString(4, th);
            
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user: "+th+" was updated successfully!");
                System.out.println("");
                System.out.println("******************************************");
                System.out.println("DATA HAS BEEN UPDATED TO: ");
                specific(stmt4, th);//Prints out the new data as it is in the database
                conn.close();
            }
            else{
                System.out.println("Could not update, check the user id and try again.");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //THIS METHOD CHECKS TO KNOW IF A DATA EXISTS IN THE DATABASE
    public void check(String stmt, String id){
        try{
            pst=conn.prepareStatement(stmt4);
            pst.setString(1, id);
            rs=pst.executeQuery();
            
            if(rs.next()){
                System.out.println("");
                System.out.println(id+" EXISTS AND IS READY TO BE MODIFIED.");
            }else{
                System.out.println("");
                System.out.println(id+" DOES NOT EXIST.");
                System.exit(0);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //THIS METHOD OUTPUTS ONLY A REQUIRED DATA AT A TIME
    public void specific(String stmt, String id){
        try{
            pst=conn.prepareStatement(stmt4);
            pst.setString(1, id);
            rs=pst.executeQuery();
            
            if(rs.next()){
                String uniID = rs.getString("staffid");
                System.out.println("STAFF ID IS: " +uniID);
                String name = rs.getString("staffname");
                System.out.println("STAFF NAME IS: " +name);
                int age = rs.getInt("staffage");
                System.out.println("STAFF AGE IS: " +age);
                String position = rs.getString("staffposition");
                System.out.println("STAFF POSITION IS: " +position);
                System.out.println();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //THIS METHOD INSERTS DATA TO THE DATABASE
    public void insert(String stmt){
        System.out.println("YOU ARE ABOUT TO INSERT A NEW RECORD: ");
        System.out.println("");
        String empt = input.nextLine();
        System.out.println("Enter StaffId: ");
        String sid = input.nextLine();
        System.out.println("Enter Staff name: ");
        String sname = input.nextLine();
        System.out.println("Enter Staff position: ");
        String spos = input.nextLine();
        System.out.println("Enter Staff age: ");
        int sage = input.nextInt();
        try{
            pst=conn.prepareStatement(stmt5);
            pst.setString(1, sid);
            pst.setString(2, sname);
            pst.setInt(3, sage);
            pst.setString(4, spos);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            else{
                System.out.println("Could not add record to the data base.");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}

