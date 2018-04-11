/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz.Model;

/**
 *
 * @author sonu
 */
public class PayHistory {
    public String billAmount;
    public String billDate;
    public String mode;
    public String customer;

    public PayHistory(String billAmount, String billDate, String mode , String customer) {
        this.billAmount = billAmount;
        this.billDate = billDate;
        this.mode = mode;
        this.customer = customer;
    }
}
