/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author virk computerZ
 */
public class CustomList extends JFrame{

    /**
     * @param args the command line arguments
     */
    /*PanelLeft pl;
    public CustomList(){
    this.setTitle("Home_Page");
    this.setResizable(true);
    this.setSize(500,500);
    this.pl=new PanelLeft(167,400,Color.PINK);
    
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(pl,BorderLayout.WEST);
    
    this.setVisible(true);
    
    }*/
    public static void main(String[] args) {
        // TODO code application logic here
    
        
        JFrame frame=new CustomList();
        
        my_list list = new my_list();
        list.test_list();
     list.setVisible(true);
  
      
    }
    
}
