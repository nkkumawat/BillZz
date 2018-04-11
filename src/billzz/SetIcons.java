/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz;

import Avator.CreateAvator;
import billzz.Model.Customer;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sonu
 */
public class SetIcons {
    
    public static BufferedImage getIcon(String path , int side) throws IOException {
        File inputFile = new File(path);
        BufferedImage inputImage = ImageIO.read(inputFile);
        BufferedImage outputImage = new BufferedImage(side,side, inputImage.getType());
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, side, side, null);
        g2d.dispose();
        return outputImage;
    }
    
    
}
