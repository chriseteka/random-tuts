
package testproject;

import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static testproject.mainPage.getStaffId;
import static testproject.mainPage.leftThumb;
import static testproject.mainPage.rightThumb;
import static testproject.mainPage.scaleImage;
import testproject.scannerLib.MessageBox;
import testproject.scannerLib.Selection;

public class firstPag extends javax.swing.JFrame {

    private ReaderCollection m_collection;
    private Reader             m_reader;
    private JTextArea m_textReader;
        

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    public firstPag() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        checkInBtn = new javax.swing.JButton();
        inputId = new javax.swing.JTextField();
        adminPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        viewAllBut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        submitBut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(610, 530));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkInBtn.setText("CHECK IN");
        checkInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInBtnActionPerformed(evt);
            }
        });
        jPanel2.add(checkInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 433, 120, 40));

        inputId.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        inputId.setText("Enter user id here");
        jPanel2.add(inputId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 520, 50));

        adminPass.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        adminPass.setText("jPasswordField1");
        jPanel2.add(adminPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 350, 520, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/n1control panel.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 170, 40));

        viewAllBut.setBackground(java.awt.SystemColor.controlLtHighlight);
        viewAllBut.setOpaque(false);
        viewAllBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButActionPerformed(evt);
            }
        });
        jPanel2.add(viewAllBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 433, 170, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/control2 panel.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 110, 43));

        submitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButActionPerformed(evt);
            }
        });
        jPanel2.add(submitBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 110, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testproject/ncontrol panel.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        //initialize capture library by acquiring reader collection
        try{
            m_collection = UareUGlobal.GetReaderCollection();
        }
        catch(UareUException e) {
            MessageBox.DpError("UareUGlobal.getReaderCollection()", e);
            return;
        }
        
        //Show up a panel to select the finger print name
        m_reader = Selection.Select(m_collection);
        
        if(null != m_reader){
            m_textReader.setText(m_reader.GetDescription().name);
        }
        else{
                m_textReader.setText("");
        }
        
        //Connect a[pp to the database
        conn=mySQLconnect.connectDb();        
    }//GEN-LAST:event_formWindowOpened

    private void viewAllButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllButActionPerformed
        allStaffDisplay disp = new allStaffDisplay();
        disp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewAllButActionPerformed

    private void submitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButActionPerformed
        mainPage sec = new mainPage();
        sec.dispImgName.setVisible(false);
        sec.setStaffId(inputId.getText());
        sec.saveUpDates.setVisible(false);
        sec.cancelUpdates.setVisible(false);
        String response = verifyUser();
        if ("success".equalsIgnoreCase(response)){
        sec.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_submitButActionPerformed

    private void checkInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInBtnActionPerformed
        
        
    }//GEN-LAST:event_checkInBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(firstPag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(firstPag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(firstPag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(firstPag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new firstPag().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField adminPass;
    private javax.swing.JButton checkInBtn;
    private javax.swing.JTextField inputId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton submitBut;
    private javax.swing.JButton viewAllBut;
    // End of variables declaration//GEN-END:variables

    private String verifyUser() {
        
        String sql = "SELECT * FROM staffdetails WHERE staffid=?";
        String sql1 = "SELECT * FROM uploads WHERE staffid=?";
        
        try{
            conn = mySQLconnect.connectDb();
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, getStaffId());
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                String uniID = rs.getString("staffid");
                mainPage.dispStaffId.setText(uniID);
                String name = rs.getString("staffname");
                mainPage.dispStaffName.setText(name);
                int age = rs.getInt("staffage");
                mainPage.dispStaffAge.setText(""+ age);
                String position = rs.getString("staffposition");
                mainPage.dispStaffPosition.setText(position);
                
                try{
                    conn = mySQLconnect.connectDb();
                    pst = conn.prepareStatement(sql1);
                    pst.setString(1, getStaffId());
                    rs = pst.executeQuery();

                    if(rs.next()){
                        String fName = rs.getString("staffimages");
                        mainPage.dispImgName.setText(fName);
                        mainPage.setFName(fName);

                        ImageIcon ii = new ImageIcon(scaleImage(160, 160, ImageIO.read(new File(fName))));
                        mainPage.imageShw.setIcon(ii);

                        InputStream isr = rs.getBinaryStream("rightThumbPrint");

                        InputStream isl = rs.getBinaryStream("leftThumbPrint");

                        if (null != isr && null != isl){

                            ImageIcon im = new ImageIcon(scaleImage(108, 104, ImageIO.read(isr)));
                            rightThumb.setIcon(im);
                            
                            ImageIcon ik = new ImageIcon(scaleImage(108, 104, ImageIO.read(isl)));
                            leftThumb.setIcon(ik);
                            
                            mainPage.connectFingerPrintReader.setVisible(false);
                            mainPage.scanRightThumb.setVisible(false);
                            mainPage.scanLeftThumb.setVisible(false);
                        }
                    }
                    return "success";
                }catch(Exception ex){
                    ex.printStackTrace();
                    return "failure";
                }
            }else{
                JOptionPane.showMessageDialog(null, "User id not found", "Error Input", JOptionPane.ERROR_MESSAGE);
                return "failure";
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return "failure";
        }
        finally{
            try{
                conn.close();
                pst.close();
                rs.close();
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        } 
    }
}
