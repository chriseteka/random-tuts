
package testproject.scannerLib;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.digitalpersona.uareu.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import testproject.mainPage;
import testproject.mySQLconnect;

public class Capture 
	extends JPanel
	implements ActionListener
{
	private static final long serialVersionUID = 2;
	private static final String ACT_BACK = "back";
	private static final String ACT_SAVE = "save";

	private JDialog       m_dlgParent;
	private CaptureThread m_capture;
	private Reader        m_reader;
	private ImagePanel    m_image;
	private boolean       m_bStreaming;
	
	private Capture(Reader reader, boolean bStreaming){
		m_reader = reader;
		m_bStreaming = bStreaming;
		
		m_capture = new CaptureThread(m_reader, m_bStreaming, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);

		final int vgap = 5;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		m_image = new ImagePanel();
		Dimension dm = new Dimension(380, 380);
		m_image.setPreferredSize(dm);
		add(m_image);
		add(Box.createVerticalStrut(vgap));
		
		JButton btnBack = new JButton("Back");
		btnBack.setActionCommand(ACT_BACK);
		btnBack.addActionListener(this);
		add(btnBack);
		add(Box.createVerticalStrut(vgap));
                
                JButton btnSave = new JButton("Save");
		btnSave.setActionCommand(ACT_SAVE);
		btnSave.addActionListener(this);
		add(btnSave);
		add(Box.createHorizontalStrut(vgap));
	}
	
	private void StartCaptureThread(){
		m_capture = new CaptureThread(m_reader, m_bStreaming, Fid.Format.ANSI_381_2004, Reader.ImageProcessing.IMG_PROC_DEFAULT);
		m_capture.start(this);
	}

	private void StopCaptureThread(){
		if(null != m_capture) m_capture.cancel();
	}
	
	private void WaitForCaptureThread(){
		if(null != m_capture) m_capture.join(1000);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(ACT_BACK)){
			//event from "back" button
			//cancel capture
			StopCaptureThread();
		}
		else if(e.getActionCommand().equals(CaptureThread.ACT_CAPTURE)){
			//event from capture thread
			CaptureThread.CaptureEvent evt = (CaptureThread.CaptureEvent)e;
			boolean bCanceled = false;
			
			if(null != evt.capture_result){
				if(null != evt.capture_result.image && Reader.CaptureQuality.GOOD == evt.capture_result.quality){
					//display image
					m_image.showImage(evt.capture_result.image);
				}
				else if(Reader.CaptureQuality.CANCELED == evt.capture_result.quality){
					//capture or streaming was canceled, just quit
					bCanceled = true;
				}
				else{
					//bad quality
					MessageBox.BadQuality(evt.capture_result.quality);
				}
			}
			else if(null != evt.exception){
				//exception during capture
				MessageBox.DpError("Capture",  evt.exception);
				bCanceled = true;
			}
			else if(null != evt.reader_status){
				MessageBox.BadStatus(evt.reader_status);
				bCanceled = true;
			}
			
			if(!bCanceled){
				if(!m_bStreaming){
					//restart capture thread
					WaitForCaptureThread();
					StartCaptureThread();
				}
			}
			else{
				//destroy dialog
				m_dlgParent.setVisible(false);
			}
		}else if(e.getActionCommand().equals(ACT_SAVE)){
                    
                    //Confirm than an image is displayed
                    if (m_image.m_image != null){
                        
                        try {
                            BufferedImage imageToSave = m_image.m_image;
                            ImageIcon imageIcon = new ImageIcon(mainPage.scaleImage(108, 104, imageToSave));
                            if (mainPage.getFingerScanned().equalsIgnoreCase("RIGHT THUMB")){
                                
                                String response = updateStaffUpload(mainPage.getStaffId(), imageToSave);
                                
                                if ("success".equalsIgnoreCase(response)){
                                    mainPage.rightThumb.setIcon(imageIcon);
                                }
                            }else{
                                
                                String response = updateStaffUpload(mainPage.getStaffId(), imageToSave);
                                
                                if ("success".equalsIgnoreCase(response)){
                                    mainPage.leftThumb.setIcon(imageIcon);
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "No finger print detected to save", "Notice", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
	}

	private void doModal(JDialog dlgParent){
		//open reader
		try{
                    m_reader.Open(Reader.Priority.COOPERATIVE);
		}
		catch(UareUException e){ MessageBox.DpError("Reader.Open()", e); }
		
		boolean bOk = true;
		if(m_bStreaming){
			//check if streaming supported
			Reader.Capabilities rc = m_reader.GetCapabilities();
			if(!rc.can_stream){
				MessageBox.Warning("This reader does not support streaming");
				bOk = false;
			}
		}
		
		if(bOk){
			//start capture thread
			StartCaptureThread();
	
			//bring up modal dialog
			m_dlgParent = dlgParent;
			m_dlgParent.setContentPane(this);
			m_dlgParent.pack();
			m_dlgParent.setLocationRelativeTo(null);
			m_dlgParent.toFront();
			m_dlgParent.setVisible(true);
			m_dlgParent.dispose();
			
			//cancel capture
			StopCaptureThread();
			
			//wait for capture thread to finish
			WaitForCaptureThread();
		}
		
		//close reader
		try{
			m_reader.Close();
		}
		catch(UareUException e){ MessageBox.DpError("Reader.Close()", e); }
	}
	
	public static void Run(Reader reader, boolean bStreaming){
    	JDialog dlg = new JDialog((JDialog)null, "Put your finger on the reader", true);
    	Capture capture = new Capture(reader, bStreaming);
    	capture.doModal(dlg);
	}

    private String updateStaffUpload(String staffId, BufferedImage imageToSave) {
        
        Connection conn = null;
        PreparedStatement pst = null;
    
        try{
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(imageToSave, "jpg", baos);
                byte[] imageInByte = baos.toByteArray();
                String sqlR = "UPDATE `uploads` SET `rightThumbPrint` = ? WHERE `staffid` = ?";
                String sqlL = "UPDATE `uploads` SET `leftThumbPrint` = ? WHERE `staffid` = ?";

                conn = mySQLconnect.connectDb();
                if (mainPage.getFingerScanned().equalsIgnoreCase("RIGHT THUMB")){
                    pst = conn.prepareStatement(sqlR);
                }else{
                    pst = conn.prepareStatement(sqlL);
                }
//                Blob blob = conn.createBlob();
//                blob.setBytes(1, imageInByte);
                pst.setBytes(1, imageInByte);
                pst.setString(2, staffId);
                pst.executeUpdate();
                conn.close();
                JOptionPane.showMessageDialog(null, "FINGER PRINT UPLOADED SUCCESSFULLY");
                return "success";
            }catch(Exception ex){
                
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "NOT UPLOADED", "ERROR WHILE UPLOADING", JOptionPane.ERROR_MESSAGE);
                return "failure";
            }
    }
}

