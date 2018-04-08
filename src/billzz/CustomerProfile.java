/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import Avator.CreateAvator;
import GenerateQR.GenerateQR;
import billzz.Database.SqlConnection;
import billzz.Lists.ProductPanel1;
import billzz.Model.Bill;
import billzz.Model.Customer;
import billzz.Model.User;
import java.awt.image.BufferedImage;
import java.io.File;
import billzz.Model.Product;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author sonu
 */
public class CustomerProfile extends javax.swing.JFrame {

    /**
     * Creates new form CustomerProfile
     */
    private Double totalBill;
    public CustomerProfile() {
        initComponents();
        GenerateQR.GenerateQRC(Customer.id+Customer.customerName);
        fillProducts();
        myInit();
     
    }
    public void myInit()  {
        try{
            System.out.print("QR/"+Customer.id+Customer.customerName);
            BufferedImage myPicture = ImageIO.read(new File("QR/"+Customer.id+Customer.customerName+".png"));
            qrCodeLabel.setIcon(new ImageIcon(myPicture));
            BufferedImage avator = CreateAvator.createImageWithText(Customer.customerName.charAt(0)+"");
            imageLabel.setIcon(new ImageIcon(avator));

            Statement stmt = SqlConnection.getStat();
            String sql = "select * from customer where id = '"+Customer.id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                customerName.setText(rs.getString("full_name"));
                customerAddress.setText(rs.getString("billing_address"));
                customerEmail.setText(rs.getString("email"));
                customerMobile.setText(rs.getString("mobile"));
                customerLastPayed.setText("Last Payed : "+rs.getString("last_bill_amount"));
                cutomerLastPaidDate.setText("Last Payed Date : "+rs.getString("last_bill_date"));
                String lastBillDate = rs.getString("last_bill_date");
                Double unBilled = rs.getDouble("unbilled_amount");
                
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                String todayDate = dateFormat.format(date);
                
                Date firstDate = dateFormat.parse(lastBillDate);
                Date secondDate = dateFormat.parse(todayDate);
                
                long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                String sql1 = "select sum(B.product_rate * A.qty) from subscription A , product B where A.customer_id = '"+Customer.id+"'\n"
                        + "and A.product_id = B.id";
                ResultSet rs1 = stmt.executeQuery(sql1);
                totalBill = 0.0;
                if(rs1.next()){
                    totalBill = rs1.getDouble(1);
                }
                totalBill*=diff;
                totalBill += unBilled;
                customerNewBill.setText("New Bill : " + totalBill);
            }
        }catch(Exception e) {
               System.out.print(e.toString());
        }  
    }
    public void fillProducts() {
        DefaultListModel<Product> defaultListModel = new DefaultListModel<>();
        try{
            Statement stmt = SqlConnection.getStat();
            String sql = "select P.id , P.product_name from subscription S, product  P where S.customer_id = '"+Customer.id+"'\n "
                    + " and P.id = S.product_id";
            ResultSet rs = stmt.executeQuery(sql);
            int flag = 0;
            while(rs.next()){
                String productName = rs.getString("product_name");
                int productId = rs.getInt("id");
                BufferedImage bi = CreateAvator.createImageWithText(productName.charAt(0) +"");
                defaultListModel.addElement(new Product(productName ,productId+"",bi)); 
                flag = 1;
            }
            if(flag == 0){
               BufferedImage bi = CreateAvator.createImageWithText("N");
               defaultListModel.addElement(new Product("No Data" ,"",bi));  
            }
        }catch(Exception e) {
             BufferedImage bi = CreateAvator.createImageWithText("N");
             defaultListModel.addElement(new Product("No Data" ,"",bi)); 
             System.out.print(e.toString());
        }
        myProductsList.setModel(defaultListModel);
        myProductsList.setCellRenderer(new ProductPanel1());
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

        imageLabel = new javax.swing.JLabel();
        qrCodeLabel = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        customerAddress = new javax.swing.JLabel();
        customerEmail = new javax.swing.JLabel();
        customerMobile = new javax.swing.JLabel();
        customerLastPayed = new javax.swing.JLabel();
        cutomerLastPaidDate = new javax.swing.JLabel();
        customerNewBill = new javax.swing.JLabel();
        addProductsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        myProductsList = new javax.swing.JList<>();
        refresh = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        payHistoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customerName.setText("Name");

        customerAddress.setText("Address");

        customerEmail.setText("Email");

        customerMobile.setText("Mobile");

        customerLastPayed.setText("Lat payed");

        cutomerLastPaidDate.setText("Date");

        customerNewBill.setText("New Bill");

        addProductsButton.setText("Add Products");
        addProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductsButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(myProductsList);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jButton1.setText("Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        payHistoryButton.setText("Pay History");
        payHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payHistoryButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("My Products");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerName)
                            .addComponent(customerNewBill)
                            .addComponent(customerAddress)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customerEmail)
                                .addGap(18, 18, 18)
                                .addComponent(customerMobile))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customerLastPayed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cutomerLastPaidDate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addProductsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(payHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addComponent(qrCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(customerNewBill))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerName)
                            .addComponent(addProductsButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerAddress)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerEmail)
                            .addComponent(customerMobile)
                            .addComponent(payHistoryButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(customerLastPayed)
                                .addComponent(cutomerLastPaidDate))
                            .addComponent(refresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(qrCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductsButtonActionPerformed
        // TODO add your handling code here:
        SubscribeProducts s = new SubscribeProducts();
        s.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        s.setVisible(true);
    }//GEN-LAST:event_addProductsButtonActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        fillProducts();
        myInit();
    }//GEN-LAST:event_refreshActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Bill.totalBill = totalBill;
        RecordPayment s = new RecordPayment();
        s.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void payHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payHistoryButtonActionPerformed
        // TODO add your handling code here:
        PayHistory s = new PayHistory();
        s.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        s.setVisible(true);
    }//GEN-LAST:event_payHistoryButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductsButton;
    private javax.swing.JLabel customerAddress;
    private javax.swing.JLabel customerEmail;
    private javax.swing.JLabel customerLastPayed;
    private javax.swing.JLabel customerMobile;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel customerNewBill;
    private javax.swing.JLabel cutomerLastPaidDate;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Product> myProductsList;
    private javax.swing.JButton payHistoryButton;
    private javax.swing.JLabel qrCodeLabel;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
