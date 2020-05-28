
package testproject;

import java.awt.Toolkit;
import javafx.stage.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class TestProject {

   
    public static void main(String[] args) {
        
        mySQLconnect c = new mySQLconnect();
        c.connectDb();
        
        
        
        firstPag mainGUI = new firstPag();
        mainGUI.setVisible(true);
        
    //    SwingUtilities.invokeLater(new Runnable(){
    //        @Override
    //        public void run(){
    //       firstPag gui = new firstPag();
   //         JFrame frame = new JFrame();
   //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //         frame.getContentPane().add(gui);
   //         frame.pack();
   //         frame.setVisible(true);
   //         }
   //     
   //     });  
        
    } 
}
    
