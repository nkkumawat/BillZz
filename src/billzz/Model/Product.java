/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz.Model;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author sonu
 */
public class Product {
    public String name;
    public String id;
    public BufferedImage icon;

    public Product(String name, String id, BufferedImage icon) {
        this.name = name;
        this.id = id;
        this.icon = icon;
    }
    public String getname(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
}
