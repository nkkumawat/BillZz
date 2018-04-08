/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import SendEmail.SendEmail;
import billzz.Database.SqlConnection;
import billzz.Model.Bill;
import billzz.Model.Customer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sonu
 */
public class RecordPayment extends javax.swing.JFrame {

    /**
     * Creates new form RecordPayment
     */
    public RecordPayment() {
        initComponents();
        myInits();
        getContentPane().setBackground(new java.awt.Color(100, 181, 246));
    }
    public void myInits() {
        totalBill.setText(Bill.totalBill +"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        d = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        payingAmount = new javax.swing.JTextField();
        modeCombo = new javax.swing.JComboBox<>();
        mode = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalBill = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        d.setText("Total");

        jLabel1.setText("Paying");

        modeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Cash", "Cheque" }));

        mode.setText("Mode");

        totalBill.setText("jLabel3");

        jLabel3.setText("Payment");

        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(mode)
                            .addComponent(d))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalBill)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(modeCombo, 0, 195, Short.MAX_VALUE)
                                .addComponent(payingAmount))
                            .addComponent(payButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel3)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d)
                    .addComponent(jLabel2)
                    .addComponent(totalBill))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(payingAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mode))
                .addGap(27, 27, 27)
                .addComponent(payButton)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
        String amt = payingAmount.getText();
        String mod = modeCombo. getSelectedItem().toString();
        if(amt.equals("") || mod.equals("")){
           javax.swing.JOptionPane.showMessageDialog(null, "Fill All Feilds", "InfoBox:",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }else {
            Double billAmount = Double.parseDouble(amt);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String paidDate = dateFormat.format(date);
            try{
                Statement stmt = SqlConnection.getStat();
                String sql = "insert into payment(customer_id ,paid_amount , mode , record_time) \n"
                        +" values('"+Customer.id+"' , '"+billAmount+"' , '"+mod+"' , '"+paidDate+"')";
                stmt.execute(sql);
                Double remaining = Bill.totalBill - billAmount;
                sql = "update customer set last_bill_amount = '"+billAmount+"', last_bill_date = '"+paidDate+"' , unbilled_amount = '"+remaining +"' where id = '"+Customer.id+"'";
//                System.out.print(sql);
                stmt.execute(sql);
                sql = "select email from customer where id = '"+Customer.id+"'";
//                System.out.print(sql);
                ResultSet rs = stmt.executeQuery(sql);
//                System.out.print(rs.getString("email"));
                SendEmail.send(rs.getString("email") , "Bill Paid" , "total bill paid = " + billAmount + " \n" +" Remaining is : "+remaining );
                this.setVisible(false);
                javax.swing.JOptionPane.showMessageDialog(null, "Payment Recorded Successfully \n Email sended to Customer", "InfoBox:",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                System.out.print(e.toString());
               javax.swing.JOptionPane.showMessageDialog(null, "Payment Record Error", "InfoBox:",javax.swing.JOptionPane.INFORMATION_MESSAGE); 
            }
      
            
        }
        
        
        
    }//GEN-LAST:event_payButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RecordPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecordPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecordPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecordPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel d;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mode;
    private javax.swing.JComboBox<String> modeCombo;
    private javax.swing.JButton payButton;
    private javax.swing.JTextField payingAmount;
    private javax.swing.JLabel totalBill;
    // End of variables declaration//GEN-END:variables
}
