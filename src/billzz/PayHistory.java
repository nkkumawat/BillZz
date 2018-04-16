/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import Avator.CreateAvator;
import billzz.Database.SqlConnection;
import billzz.Lists.PayHistoryPanel;
import billzz.Lists.ProductPanel1;
import billzz.Model.Customer;
import billzz.Model.Payment;
import billzz.Model.Product;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;

/**
 *
 * @author sonu
 */
public class PayHistory extends javax.swing.JFrame {

    /**
     * Creates new form PayHistory
     */
    public PayHistory() {
        initComponents();
        myInits();
         pack();
        setLocationRelativeTo(null);
    }
    public  void myInits(){
        DefaultListModel<Payment> defaultListModel = new DefaultListModel<>();
        try{
            Statement stmt = SqlConnection.getStat();
            String sql = "select * from payment where customer_id = '"+Customer.id+"' order by id desc";
            ResultSet rs = stmt.executeQuery(sql);
            int flag = 0;
            while(rs.next()){
                String billAmount = rs.getString("paid_amount");
                String billDte = rs.getString("record_time");
                String mode = rs.getString("mode");
                defaultListModel.addElement(new Payment(billAmount ,billDte,mode)); 
                flag = 1;
            }
            if(flag == 0){
             defaultListModel.addElement(new Payment("No Data" ,"",""));  
            }
        }catch(Exception e) {
             defaultListModel.addElement(new Payment("No Data" ,"",""));
        }
        paymentHistoryList.setModel(defaultListModel);
        paymentHistoryList.setCellRenderer(new PayHistoryPanel());
        pHistoryLabel.setForeground(Color.WHITE);
        getContentPane().setBackground(new java.awt.Color(100, 181, 246));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        paymentHistoryList = new javax.swing.JList<>();
        pHistoryLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(paymentHistoryList);

        pHistoryLabel.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        pHistoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pHistoryLabel.setText("PAY HISTORY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addComponent(pHistoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pHistoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PayHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pHistoryLabel;
    private javax.swing.JList<Payment> paymentHistoryList;
    // End of variables declaration//GEN-END:variables
}
