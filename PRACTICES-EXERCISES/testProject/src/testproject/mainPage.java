package testproject;

import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import testproject.scannerLib.Capture;
import testproject.scannerLib.MessageBox;
import testproject.scannerLib.Selection;

/**
 *
 * @author Sir_Chris
 */
public class mainPage extends javax.swing.JFrame {

    private JTextArea m_textReader;
    private JDialog   m_dlgParent;
    private Reader           m_reader;
    private ReaderCollection m_collection;
    private static String staffId;
    private static String fingerScanned;
    private static String fName;
    
    public static void setStaffId(String staff){
        staffId = staff;
    }
    
    public static String getStaffId(){
        return staffId;
    }
    
    public static void setFingerScanned(String fiScan){
        fingerScanned = fiScan;
    }
    
    public static String getFingerScanned(){
        return fingerScanned;
    }
    
    public static void setFName(String name){
        fName = name;
    }
    
    public static String getFName(){
        return fName;
    }

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public mainPage() {
        initComponents();
    }
//    public void setStaffId (String sid){
//        this.dispStaffId.setText(sid);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backGround = new javax.swing.JPanel();
        staticTitle = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        staffName1 = new javax.swing.JLabel();
        staffPosition = new javax.swing.JLabel();
        staffAge = new javax.swing.JLabel();
        dispStaffName = new javax.swing.JTextField();
        dispStaffAge = new javax.swing.JTextField();
        dispStaffPosition = new javax.swing.JTextField();
        dispRTP = new javax.swing.JPanel();
        rightThumb = new javax.swing.JLabel();
        RTP = new javax.swing.JLabel();
        LTP = new javax.swing.JLabel();
        updateStaffDetails = new javax.swing.JButton();
        backBut = new javax.swing.JButton();
        chooseImg = new javax.swing.JButton();
        imageShw = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dispStaffId = new javax.swing.JTextField();
        uploadImg = new javax.swing.JButton();
        dispImgName = new javax.swing.JTextField();
        dispRTP1 = new javax.swing.JPanel();
        leftThumb = new javax.swing.JLabel();
        scanLeftThumb = new javax.swing.JButton();
        scanRightThumb = new javax.swing.JButton();
        connectFingerPrintReader = new javax.swing.JButton();
        saveUpDates = new javax.swing.JButton();
        cancelUpdates = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        backGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staticTitle.setEditable(false);
        staticTitle.setBackground(new java.awt.Color(51, 0, 51));
        staticTitle.setFont(new java.awt.Font("Lucida Calligraphy", 3, 10)); // NOI18N
        staticTitle.setForeground(new java.awt.Color(0, 153, 153));
        staticTitle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        staticTitle.setText("OKEKE AND SON'S COMPANY...       STAFF VERIFICATION FORM.");
        staticTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staticTitleActionPerformed(evt);
            }
        });
        backGround.add(staticTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 692, 43));

        jTextField1.setEditable(false);
        jTextField1.setText("STAFF DETAILS: ------------------------------------------------------------------------------------------------------------------------------------------------------");
        backGround.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 268, 700, 30));

        staffName1.setText("NAME:");
        backGround.add(staffName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 305, 66, 25));

        staffPosition.setText("POSITION:");
        backGround.add(staffPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 66, 25));

        staffAge.setText("AGE:");
        backGround.add(staffAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 52, 25));

        dispStaffName.setEditable(false);
        dispStaffName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backGround.add(dispStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 304, 351, 25));

        dispStaffAge.setEditable(false);
        dispStaffAge.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dispStaffAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispStaffAgeActionPerformed(evt);
            }
        });
        backGround.add(dispStaffAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 622, 24));

        dispStaffPosition.setEditable(false);
        dispStaffPosition.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backGround.add(dispStaffPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 622, 24));

        dispRTP.setBackground(new java.awt.Color(204, 204, 255));
        dispRTP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout dispRTPLayout = new javax.swing.GroupLayout(dispRTP);
        dispRTP.setLayout(dispRTPLayout);
        dispRTPLayout.setHorizontalGroup(
            dispRTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightThumb, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        dispRTPLayout.setVerticalGroup(
            dispRTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightThumb, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );

        backGround.add(dispRTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 106, 110));

        RTP.setText("RIGHT THUMB PRINT");
        backGround.add(RTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 106, 25));

        LTP.setText("LEFT THUMB PRINT");
        backGround.add(LTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 100, 25));

        updateStaffDetails.setText("UPDATE DETAILS");
        updateStaffDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStaffDetailsActionPerformed(evt);
            }
        });
        backGround.add(updateStaffDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        backBut.setText("BACK TO HOME");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });
        backGround.add(backBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 143, 28));

        chooseImg.setText("CHOOSE");
        chooseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgActionPerformed(evt);
            }
        });
        backGround.add(chooseImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 234, -1, -1));

        imageShw.setBackground(new java.awt.Color(255, 0, 204));
        imageShw.setForeground(new java.awt.Color(204, 51, 0));
        imageShw.setText("PASSPORT PHOTOGRAPH HERE");
        imageShw.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 51, 0), 3, true));
        backGround.add(imageShw, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, 162, 144));

        jLabel1.setText("STAFF ID:");
        backGround.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 310, -1, -1));

        dispStaffId.setEditable(false);
        dispStaffId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dispStaffId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispStaffIdActionPerformed(evt);
            }
        });
        backGround.add(dispStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 304, 194, 25));

        uploadImg.setText("UPLOAD");
        uploadImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImgActionPerformed(evt);
            }
        });
        backGround.add(uploadImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 234, -1, -1));

        dispImgName.setEditable(false);
        dispImgName.setText("imgName");
        backGround.add(dispImgName, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 59, 220, 27));

        dispRTP1.setBackground(new java.awt.Color(204, 204, 255));
        dispRTP1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout dispRTP1Layout = new javax.swing.GroupLayout(dispRTP1);
        dispRTP1.setLayout(dispRTP1Layout);
        dispRTP1Layout.setHorizontalGroup(
            dispRTP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftThumb, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        dispRTP1Layout.setVerticalGroup(
            dispRTP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftThumb, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );

        backGround.add(dispRTP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, 110));

        scanLeftThumb.setText("Scan Left Thumb");
        scanLeftThumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanLeftThumbActionPerformed(evt);
            }
        });
        backGround.add(scanLeftThumb, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 120, 30));

        scanRightThumb.setText("Scan Right Thumb");
        scanRightThumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanRightThumbActionPerformed(evt);
            }
        });
        backGround.add(scanRightThumb, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 120, 30));

        connectFingerPrintReader.setText("Connect Finger Reader");
        connectFingerPrintReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectFingerPrintReaderActionPerformed(evt);
            }
        });
        backGround.add(connectFingerPrintReader, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 150, -1));

        saveUpDates.setText("Save Updates");
        backGround.add(saveUpDates, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 140, -1));

        cancelUpdates.setText("cancel");
        cancelUpdates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelUpdatesActionPerformed(evt);
            }
        });
        backGround.add(cancelUpdates, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

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
        
        String imName = dispImgName.getText();
        if (imName.contains("imgName")){
            JOptionPane.showMessageDialog(null, "YOU HAVE NOT UPLOADED YOUR IMAGE, PLEASE DO SO NOW",
                            "IMAGE UPLOAD DETAIL", JOptionPane.OK_OPTION);
                
        }else{
            chooseImg.setEnabled(false);
            uploadImg.setEnabled(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void dispStaffIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispStaffIdActionPerformed

    }//GEN-LAST:event_dispStaffIdActionPerformed

    private void chooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgActionPerformed
        
        String fName = dispImgName.getText();
        if(fName.contains("imgName")){
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File f = choose.getSelectedFile();
            String fileName = f.getAbsolutePath();
            dispImgName.setText(fileName);
            try{
                ImageIcon ii = new ImageIcon(scaleImage(160, 160, ImageIO.read(new File(f.getAbsolutePath()))));
                imageShw.setIcon(ii);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "AN IMAGE ALREADY EXIST, CLICK EDIT DETAILS TO CHANGE");
        }
        
        
    }//GEN-LAST:event_chooseImgActionPerformed

    private void backButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButActionPerformed
        firstPag mainGUI = new firstPag();
        mainGUI.setVisible(true);
        this.dispose();;
    }//GEN-LAST:event_backButActionPerformed

    private void staticTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staticTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staticTitleActionPerformed

    private void uploadImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImgActionPerformed
        if(getFName().contains("imgName")){
            JOptionPane.showMessageDialog(null,"NO IMAGE HAS BEEN CHOSEN", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if(getFName().isEmpty()){
            JOptionPane.showMessageDialog(null, "THERE IS AN EXISTING IMAGE");
        }
        else{
            try{
                String staffID = dispStaffId.getText();
                String sql = "INSERT INTO uploads(staffid, staffimages) VALUES(?, ?)";
                conn=mySQLconnect.connectDb();
                pst = conn.prepareStatement(sql);
                //InputStream is = new FileInputStream(new File(fName));
                //System.out.println(is);
                //String sid = dispStaffId.getText();
                //System.out.println(fName);
                pst.setString(1, staffID);
                pst.setString(2, fName);
                //pst.setBlob(2, is);
                pst.executeUpdate();
                conn.close();
                JOptionPane.showMessageDialog(null, "IMAGE UPLOADED SUCCESSFULLY");
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "NOT UPLOADED", "ERROR WHILE UPLOADING", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_uploadImgActionPerformed

    private void dispStaffAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispStaffAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dispStaffAgeActionPerformed

    private void updateStaffDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStaffDetailsActionPerformed

        cancelUpdates.setVisible(true);
        saveUpDates.setVisible(true);
        chooseImg.setEnabled(true);
        uploadImg.setEnabled(true);
        dispImgName.setName("imgName");
        dispStaffName.setEditable(true);
        dispStaffAge.setEditable(true);
        dispStaffPosition.setEditable(true);
        updateStaffDetails.setVisible(false);
        
        connectFingerPrintReader.setVisible(true);
        scanLeftThumb.setVisible(true);
        scanRightThumb.setVisible(true);
        
        //We now write a function which shall update the database where necessary
        
    }//GEN-LAST:event_updateStaffDetailsActionPerformed

    private void scanRightThumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanRightThumbActionPerformed
        setFingerScanned("RIGHT THUMB");
        Capture.Run(m_reader, false);
    }//GEN-LAST:event_scanRightThumbActionPerformed

    private void scanLeftThumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanLeftThumbActionPerformed
        setFingerScanned("LEFT THUMB");
        Capture.Run(m_reader, false);
    }//GEN-LAST:event_scanLeftThumbActionPerformed

    private void connectFingerPrintReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectFingerPrintReaderActionPerformed
        m_reader = Selection.Select(m_collection);
        
        if(null != m_reader){
            m_textReader.setText(m_reader.GetDescription().name);
        }
        else{
                m_textReader.setText("");
        }
    }//GEN-LAST:event_connectFingerPrintReaderActionPerformed

    private void cancelUpdatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelUpdatesActionPerformed

        cancelUpdates.setVisible(false);
        saveUpDates.setVisible(false);
        chooseImg.setEnabled(false);
        uploadImg.setEnabled(false);
        dispImgName.setName(getFName());
        dispStaffName.setEditable(false);
        dispStaffAge.setEditable(false);
        dispStaffPosition.setEditable(false);
        updateStaffDetails.setVisible(true);
        
        connectFingerPrintReader.setVisible(false);
        scanLeftThumb.setVisible(false);
        scanRightThumb.setVisible(false);
        
    }//GEN-LAST:event_cancelUpdatesActionPerformed
    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception{
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D)bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }
    
    private void doModal(JDialog dlgParent){
        m_dlgParent = dlgParent;
        m_dlgParent.setContentPane(this);
        m_dlgParent.pack();
        m_dlgParent.setLocationRelativeTo(null);
        m_dlgParent.setVisible(true);
        m_dlgParent.dispose();
    }
    
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
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LTP;
    private javax.swing.JLabel RTP;
    private javax.swing.JButton backBut;
    private javax.swing.JPanel backGround;
    public static javax.swing.JButton cancelUpdates;
    private javax.swing.JButton chooseImg;
    public static javax.swing.JButton connectFingerPrintReader;
    public static javax.swing.JTextField dispImgName;
    public static javax.swing.JPanel dispRTP;
    public static javax.swing.JPanel dispRTP1;
    public static javax.swing.JTextField dispStaffAge;
    public static javax.swing.JTextField dispStaffId;
    public static javax.swing.JTextField dispStaffName;
    public static javax.swing.JTextField dispStaffPosition;
    public static javax.swing.JLabel imageShw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JLabel leftThumb;
    public static javax.swing.JLabel rightThumb;
    public static javax.swing.JButton saveUpDates;
    public static javax.swing.JButton scanLeftThumb;
    public static javax.swing.JButton scanRightThumb;
    private javax.swing.JLabel staffAge;
    private javax.swing.JLabel staffName1;
    private javax.swing.JLabel staffPosition;
    private javax.swing.JTextField staticTitle;
    private javax.swing.JButton updateStaffDetails;
    private javax.swing.JButton uploadImg;
    // End of variables declaration//GEN-END:variables
}
