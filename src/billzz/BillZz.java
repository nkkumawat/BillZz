/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import GenerateQR.GenerateQR;
import billzz.Database.SqlConnection;

/**
 *
 * @author sonu
 */
public class BillZz {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates new tables and dummy user
        new SqlConnection();
//        start SignIn
        new SignIn().setVisible(true);
        
    }
    
}
