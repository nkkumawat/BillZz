/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz.Lists;

import Avator.CreateAvator;
import billzz.AddCustomer;
import billzz.AddProducts;
import billzz.CustomerProfile;
import billzz.Database.SqlConnection;
import billzz.Model.Customer;
import billzz.Model.Product;
import billzz.Model.Products;
import billzz.ProductDetails;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author sonu
 */
public class ProductList1  extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form ProductList1
     */
    public ProductList1() {
        initComponents();
        myInits();
    }
   
    public void myInits() {
       addFocusListener(new CustomFocusListener());  
        try {
            File inputFile = new File("./QR/refresh.png");
            BufferedImage inputImage = ImageIO.read(inputFile);
            BufferedImage outputImage = new BufferedImage(50,50, inputImage.getType());
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(inputImage, 0, 0, 50, 50, null);
            g2d.dispose();
            refreshLabel.setIcon(new ImageIcon(outputImage));
            refreshLabel.setToolTipText("Refresh");
            
            
            File inputFile1 = new File("./QR/add.png");
            BufferedImage inputImage1 = ImageIO.read(inputFile1);
            BufferedImage outputImage1 = new BufferedImage(50,50, inputImage1.getType());
            Graphics2D g2d1 = outputImage1.createGraphics();
            g2d1.drawImage(inputImage1, 0, 0, 50, 50, null);
            g2d1.dispose();
            addCustomerLabel.setIcon(new ImageIcon(outputImage1));
            addCustomerLabel.setToolTipText("Add Customer");
                    
            addProductLabel.setIcon(new ImageIcon(outputImage1));
            addProductLabel.setToolTipText("Add Product");
            
            productText.setForeground(Color.white);
            customerText.setForeground(Color.white);
            productText1.setForeground(Color.white);
            customerText1.setForeground(Color.white);
            refreshText.setForeground(Color.white);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    } 
    
    class CustomFocusListener implements FocusListener{
         @Override
        public void focusGained(FocusEvent e) {
            fillProductList();
        }
        @Override
        public void focusLost(FocusEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
   }
    public void fillProductList(){
        DefaultListModel<Product> defaultListModel = new DefaultListModel<>();
        try{
            Statement stmt = SqlConnection.getStat();
            String sql = "select * from product order by id desc";
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
        }
        jList3.setModel(defaultListModel);
        jList3.setCellRenderer(new ProductPanel1());
        getContentPane().setBackground(new java.awt.Color(100, 181, 246));
    }
    public void fillCustomerList(){
        DefaultListModel<Product> defaultListModel = new DefaultListModel<>();
        try{
            Statement stmt = SqlConnection.getStat();
            String sql = "select * from customer order by id desc";
            ResultSet rs = stmt.executeQuery(sql);
            int flag = 0;
            while(rs.next()){
                String customerName = rs.getString("full_name");
                int customerId = rs.getInt("id");
                BufferedImage bi = CreateAvator.createImageWithText(customerName.charAt(0) +"");
                defaultListModel.addElement(new Product(customerName ,customerId+"",bi));  
                flag = 1;
            }
            if(flag == 0){
               BufferedImage bi = CreateAvator.createImageWithText("N");
             defaultListModel.addElement(new Product("No Data" ,"",bi));  
            }
        }catch(Exception e) {
             BufferedImage bi = CreateAvator.createImageWithText("N");
             defaultListModel.addElement(new Product("No Data" ,"",bi)); 
        }    
        jList4.setModel(defaultListModel);
        jList4.setCellRenderer(new ProductPanel1());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        productText = new javax.swing.JLabel();
        customerText = new javax.swing.JLabel();
        refreshLabel = new javax.swing.JLabel();
        customerText1 = new javax.swing.JLabel();
        addCustomerLabel = new javax.swing.JLabel();
        productText1 = new javax.swing.JLabel();
        addProductLabel = new javax.swing.JLabel();
        refreshText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList4MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList4);

        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList3);

        productText.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        productText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productText.setText("Product");

        customerText.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        customerText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerText.setText("Customers");

        refreshLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshLabelMouseClicked(evt);
            }
        });

        customerText1.setText("Customer");

        addCustomerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCustomerLabelMouseClicked(evt);
            }
        });

        productText1.setText("Product");

        addProductLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductLabelMouseClicked(evt);
            }
        });

        refreshText.setText("Refresh");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerText1)
                            .addComponent(productText1)
                            .addComponent(refreshText))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerText)
                    .addComponent(productText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerText1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCustomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productText1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addProductLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        // TODO add your handling code here:
//         Customer.customerName = ((Product)jList3.getSelectedValue()).getname();
         Products.productId = ((Product)jList3.getSelectedValue()).getId();
         ProductDetails c = new ProductDetails();
         c.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         c.setVisible(true);
    }//GEN-LAST:event_jList3MouseClicked

    private void jList4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MouseClicked
        // TODO add your handling code here:
         Customer.customerName = ((Product)jList4.getSelectedValue()).getname();
         Customer.id = ((Product)jList4.getSelectedValue()).getId();
         CustomerProfile c = new CustomerProfile();
         c.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         c.setVisible(true);
           
    }//GEN-LAST:event_jList4MouseClicked

    private void refreshLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshLabelMouseClicked
        // TODO add your handling code here:
        fillProductList();
        fillCustomerList(); 
    }//GEN-LAST:event_refreshLabelMouseClicked

    private void addCustomerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerLabelMouseClicked
        // TODO add your handling code here:
        AddCustomer a = new AddCustomer();
        a.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        a.setVisible(true);
    }//GEN-LAST:event_addCustomerLabelMouseClicked

    private void addProductLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductLabelMouseClicked
        // TODO add your handling code here:
       AddProducts a = new AddProducts();
       a.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       a.setVisible(true);
    }//GEN-LAST:event_addProductLabelMouseClicked

     
 
 
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
            java.util.logging.Logger.getLogger(ProductList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductList1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCustomerLabel;
    private javax.swing.JLabel addProductLabel;
    private javax.swing.JLabel customerText;
    private javax.swing.JLabel customerText1;
    private javax.swing.JList<Product> jList3;
    private javax.swing.JList<Product> jList4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel productText;
    private javax.swing.JLabel productText1;
    private javax.swing.JLabel refreshLabel;
    private javax.swing.JLabel refreshText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
