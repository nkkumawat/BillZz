/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import java.awt.Image;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author NEETU
 */
public class my_list extends javax.swing.JFrame {

    public my_list() {
        initComponents();
    }
    
    void test_list(){
              DefaultListModel<my_class> defaultListModel = new DefaultListModel<>();
        for(int i=1;i<20;i++){
            ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("profile_images/IMG1.jpg")).getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
            
            defaultListModel.addElement(new my_class("Customer " + i ,"Payment "+ i,icon));     
        }
        jList1.setModel(defaultListModel);
        jList1.setCellRenderer(new my_panel());

    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new my_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<my_class> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
