/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import java.io.File;

/**
 *
 * @author sonu
 */
public class Init {
    public Init() {
        File theDir = new File("./QR");
        if (!theDir.exists()) {
            try{
                theDir.mkdir();
            } 
            catch(SecurityException e){
                    javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
        theDir = new File("./Profile_Pic");
        if (!theDir.exists()) {
            try{
                theDir.mkdir();
            } 
            catch(SecurityException e){
                javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
        theDir = new File("./Database");
        if (!theDir.exists()) {
            try{
                theDir.mkdir();
            } 
            catch(SecurityException e){
                javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
