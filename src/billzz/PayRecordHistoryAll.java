/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;
import Avator.CreateAvator;
import billzz.Database.SqlConnection;
import billzz.Lists.PayHistoryPanel;
import billzz.Lists.PayRecordHistoryPanel;
import billzz.Lists.ProductPanel1;
import billzz.Model.Customer;
import billzz.Model.PayHistory;
import billzz.Model.Payment;
import billzz.Model.Product;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author sonu
 */
public class PayRecordHistoryAll extends javax.swing.JFrame {

    /**
     * Creates new form PayRecordHistoryAll
     */
    public PayRecordHistoryAll() {
        initComponents();
        myInits();
    }
    
    
     public  void myInits(){
        DefaultListModel<PayHistory> defaultListModel = new DefaultListModel<>();
        try{
            Statement stmt = SqlConnection.getStat();
            String sql = "select * from payment P , customer C where P.customer_id = C.id order by id desc";
            ResultSet rs = stmt.executeQuery(sql);
            int flag = 0;
            while(rs.next()){
                String billAmount = rs.getString("paid_amount");
                String billDte = rs.getString("record_time");
                String mode = rs.getString("mode");
                String customer = rs.getString("full_name");
                defaultListModel.addElement(new PayHistory(billAmount ,billDte,mode ,customer )); 
                flag = 1;
            }
            if(flag == 0){
             defaultListModel.addElement(new PayHistory("No Data" ,"","" , ""));  
            }
        }catch(Exception e) {
             defaultListModel.addElement(new PayHistory("No Data" ,"","" , ""));
        }
        payRecordHistory.setModel(defaultListModel);
        payRecordHistory.setCellRenderer(new PayRecordHistoryPanel());
        payhistoryLabel.setForeground(Color.white);
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
        payRecordHistory = new javax.swing.JList<>();
        payhistoryLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(payRecordHistory);

        payhistoryLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        payhistoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payhistoryLabel.setText("Pay History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addComponent(payhistoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(payhistoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(PayRecordHistoryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayRecordHistoryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayRecordHistoryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayRecordHistoryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayRecordHistoryAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<PayHistory> payRecordHistory;
    private javax.swing.JLabel payhistoryLabel;
    // End of variables declaration//GEN-END:variables

      
}
