/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author virk computerZ
 */
public class my_class {
    String name;
    String add;
    ImageIcon icon;

    public my_class(String name, String add, ImageIcon icon) {
        this.name = name;
        this.add = add;
        this.icon = icon;
    }
    
    String getname(){
        return this.name;
    }
}
