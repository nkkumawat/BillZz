/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz.Model;

import java.awt.image.BufferedImage;

/**
 *
 * @author sonu
 */
public class Payment {
    public String billAmount;
    public String billDate;
    public String mode;

    public Payment(String billAmount, String billDate, String mode) {
        this.billAmount = billAmount;
        this.billDate = billDate;
        this.mode = mode;
    }
//    public String getname(){
//        return this.name;
//    }
//    public String getId(){
//        return this.id;
//    }
}
