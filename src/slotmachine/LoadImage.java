/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package slotmachine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Santy
 */
public class LoadImage implements Runnable{

    int iRnd = 0;
    Random gen = new Random();  
    BufferedImage image;
    JFrame frame2;



      
    
    public void run() {
    
 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    }
        public void printImage(JFrame frame)
    {
      Background bck1 = new Background(image,200,200);
      bck1.setBounds(0, 0, 100,100 );
      frame.add(bck1);
 

    }
}

