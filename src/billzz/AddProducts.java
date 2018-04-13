/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import billzz.Database.SqlConnection;
import java.awt.Color;
import java.sql.Statement;

/**
 *
 * @author sonu
 */
public class AddProducts extends javax.swing.JFrame {

    /**
     * Creates new form AddProducts
     */
    public AddProducts() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 181, 246));
        LangLabel.setForeground(Color.WHITE);
        ProductInfoLabel.setForeground(Color.WHITE);
        ProductNameLabel.setForeground(Color.WHITE);
        RateLabel.setForeground(Color.WHITE);
        ProductDescLabel.setForeground(Color.WHITE);
        ProductInfoLabel.setForeground(Color.white);
        addProduct.setBackground(Color.decode("#50AF00"));
        addProduct.setForeground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productName = new javax.swing.JTextField();
        productDesc = new javax.swing.JTextField();
        productLanguage = new javax.swing.JTextField();
        productRate = new javax.swing.JTextField();
        ProductNameLabel = new javax.swing.JLabel();
        ProductDescLabel = new javax.swing.JLabel();
        LangLabel = new javax.swing.JLabel();
        RateLabel = new javax.swing.JLabel();
        addProduct = new javax.swing.JButton();
        ProductInfoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productName.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        productName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameActionPerformed(evt);
            }
        });

        productDesc.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N

        productLanguage.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        productLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productLanguageActionPerformed(evt);
            }
        });

        productRate.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N

        ProductNameLabel.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        ProductNameLabel.setText("ProductName");

        ProductDescLabel.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        ProductDescLabel.setText("Product Desc");

        LangLabel.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        LangLabel.setText("Language");

        RateLabel.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        RateLabel.setText("Rate");

        addProduct.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        addProduct.setText("Add");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });

        ProductInfoLabel.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        ProductInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductInfoLabel.setText("PRODUCT INFORMATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProductInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProductNameLabel)
                            .addComponent(ProductDescLabel)
                            .addComponent(LangLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productName, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(productDesc)
                            .addComponent(productLanguage)
                            .addComponent(productRate)))
                    .addComponent(RateLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(ProductInfoLabel)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductDescLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LangLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RateLabel))
                .addGap(39, 39, 39)
                .addComponent(addProduct)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productLanguageActionPerformed

    private void productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        // TODO add your handling code here:
        String product_name = productName.getText();
        String product_desc = productDesc.getText();
        String product_lang = productLanguage.getText();
        String product_rate = productRate.getText();

        if(product_name.equals("") || product_desc.equals("") || product_lang.equals("")|| product_rate.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Fill All Feilds", "InfoBox:",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }else {
            try{
                Statement stmt = SqlConnection.getStat();
                String insertProduct = "insert into product(product_name , product_rate , product_desc ,language)\n"
                +"values('"+product_name+"' , '"+product_rate+"' , '"+product_desc+"' , '"+product_lang+"')";
                stmt.execute(insertProduct);
                this.setVisible(false);
                javax.swing.JOptionPane.showMessageDialog(null, "Product Added Successfully", "InfoBox:",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null, e.toString(), "InfoBox:",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_addProductActionPerformed

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
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LangLabel;
    private javax.swing.JLabel ProductDescLabel;
    private javax.swing.JLabel ProductInfoLabel;
    private javax.swing.JLabel ProductNameLabel;
    private javax.swing.JLabel RateLabel;
    private javax.swing.JButton addProduct;
    private javax.swing.JTextField productDesc;
    private javax.swing.JTextField productLanguage;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField productRate;
    // End of variables declaration//GEN-END:variables
}
