package Avator;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonu
 */
public class CreateAvator {
    private static Color colors[] = {Color.decode("#00b8d4") , Color.decode("#00695c") , Color.decode("#ab47bc") ,Color.decode("#43a047") ,Color.decode("#f57f17"), Color.decode("#d84315"),Color.decode("#546e7a")};
    public static BufferedImage createImageWithText(String charactor){ 
        int index = (int)(Math.random()*(6));
        BufferedImage bufferedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setColor(colors[index]);
        g.fillRect(0,0,50,50);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 42)); 
        g.drawString(charactor.toUpperCase(), 8, 42);
        return bufferedImage;
//        String result = "Profile_Pic"+charactor + String.valueOf(index)+".png";
//        File outputfile = new File(result);
//        try{
//            ImageIO.write(bufferedImage, "png", outputfile);
//        }catch(Exception e) {
//            System.out.print(e.toString());
//        }
//        return result;
    }
}
