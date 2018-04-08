/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import billzz.Lists.ProductList1;
import javax.swing.WindowConstants;

/**
 *
 * @author sonu
 */
public class HomePage {
    public HomePage(){
        ProductList1 list = new ProductList1();
        list.fillProductList();
        list.fillCustomerList();
//        list.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        list.setVisible(true); 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
