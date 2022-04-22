
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Merik
 */


/**
 *
 * @author lalim6488
 */
//Access's gui allowing for image printing to be on gui
public class FirstRun extends JComponent{
    //Allows for the image to be stored
    private BufferedImage image;
    //places the image onto the gui
    public void setImage(BufferedImage img){
        this.image = img;
        repaint();
    }
    /**
     * Draws the image on the gui
     * @param g grabs the gui and allows us to draw stuff on it
     */
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);
}
}

 

