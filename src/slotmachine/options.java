/*
 * This class creates another window to check the relationship between
 * drivers-price.
 */
package slotmachine;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class options extends JFrame {

    Wave sound;
    BufferedImage img;
    int x = 440, y = 400, iTime = 0;
    Background fAlonso, fMassa, jButton, lHamilton, nRosberg, mSchumacher, sVettel, mWebber;
    JLabel sVet = new JLabel("= 100");
    JLabel fAl = new JLabel("= 90");
    JLabel mWeb = new JLabel("= 80");
    JLabel lHam = new JLabel("= 70");
    JLabel jBut = new JLabel("= 60");
    JLabel fMas = new JLabel("= 50");
    JLabel nRos = new JLabel("= 40");
    JLabel mSchu = new JLabel("= 30");
    JPanel panel = new JPanel();
    boolean flag = true;
    Runnable music = new Runnable() {

        public void run() {


            while (flag) {


                sound = new Wave("ferrari - Michael Schumacher F1 Tecno Racing Sounds_1.wav");
                sound.play();
                while (iTime < 10500) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(options.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    iTime += 100;

                    if (!flag) {
                        sound.stop();
                        break;
                    }

                }
                iTime = 0;

            }


        }
    };

    public options() throws IOException {
        setTitle("Options");
        setSize(x, y);
        setLocation(x, y / 2);
        setResizable(false);
        panel.setBounds(0, 0, x, y);
        panel.setBackground(Color.black);



        addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
                flag = true;
                ExecutorService newone = Executors.newFixedThreadPool(1);
                newone.execute(music);
                newone.shutdown();
            }

            public void windowDeactivated(WindowEvent e) {
                flag = false;
            }
        });

        img = ImageIO.read(new File("sebastianvettel.jpg"));
        sVettel = new Background(img, 75, 100);
        sVettel.setBounds(10, 10, 75, 100);

        img = ImageIO.read(new File("fernandoalonso.jpg"));
        fAlonso = new Background(img, 75, 100);
        fAlonso.setBounds(10, 120, 75, 100);

        img = ImageIO.read(new File("markwebber.jpg"));
        mWebber = new Background(img, 75, 100);
        mWebber.setBounds(10, 230, 75, 100);


        img = ImageIO.read(new File("lewishamilton.jpg"));
        lHamilton = new Background(img, 75, 100);
        lHamilton.setBounds(150, 10, 75, 100);

        img = ImageIO.read(new File("jensonbutton.jpg"));
        jButton = new Background(img, 75, 100);
        jButton.setBounds(150, 120, 75, 100);

        img = ImageIO.read(new File("felipemassa.jpg"));
        fMassa = new Background(img, 75, 100);
        fMassa.setBounds(150, 230, 75, 100);


        img = ImageIO.read(new File("nicorosberg.jpg"));
        nRosberg = new Background(img, 75, 100);
        nRosberg.setBounds(290, 10, 75, 100);

        img = ImageIO.read(new File("michaelschumacher.jpg"));
        mSchumacher = new Background(img, 75, 100);
        mSchumacher.setBounds(290, 120, 75, 100);

        sVet.setForeground(Color.white);
        sVet.setBounds(100, 10, 75, 100);

        fAl.setForeground(Color.white);
        fAl.setBounds(100, 120, 75, 100);

        mWeb.setForeground(Color.white);
        mWeb.setBounds(100, 230, 75, 100);

        lHam.setForeground(Color.white);
        lHam.setBounds(240, 10, 75, 100);

        jBut.setForeground(Color.white);
        jBut.setBounds(240, 120, 75, 100);

        fMas.setForeground(Color.white);
        fMas.setBackground(Color.black);
        fMas.setBounds(240, 230, 75, 100);

        nRos.setForeground(Color.white);
        nRos.setBounds(380, 10, 75, 100);

        mSchu.setForeground(Color.white);
        mSchu.setBounds(380, 120, 75, 100);



        add(sVet);
        add(fAl);
        add(mWeb);
        add(lHam);
        add(jBut);
        add(fMas);
        add(nRos);
        add(mSchu);

        add(mSchumacher);
        add(nRosberg);
        add(fMassa);
        add(jButton);
        add(lHamilton);
        add(mWebber);
        add(fAlonso);
        add(sVettel);
        add(panel);





    }

    public void setVisible(boolean visibility) {

        super.setVisible(visibility);
    }
}
