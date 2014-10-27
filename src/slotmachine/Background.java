/*
 * This Class is the one put the images in the client area. Backgroung, driver´s
 * images, and so forth.
 * Each of those images is a panel.
 *
 *      Developed by: Santiago De La Torre
 * Last Modification: Dec-2-2010
 * Educationa Center: Bunker Hill Community College.
 */
package slotmachine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {

    BufferedImage image = null;
    int x, y;

    public Background(BufferedImage image2, int x, int y) {
        this.x = x;
        this.y = y;
        image = image2;
    }

    public void setBackground(String file) throws IOException {
        image = ImageIO.read(new File(file));
        repaint();
    }

    public void setBackground(BufferedImage image2) {
        image = image2;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, x, y, this);
        }
    }
}
