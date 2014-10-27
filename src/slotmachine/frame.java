/******************************************************************************
 * The frame class is the main interface of the game, where the user can either
 * hit the play or options buttons.
 * The play button is going to start the game. Three images are going to change
 * randomly in parallel with a song. When the song stops, all of the images
 * stop from changing. If all images have the same driver you will get a reward 
 * depending on the 2010 season of the Formula 1.
 * Hit to option button if you want to know the relationship driver-price.
 * If you either win or lose your money is going to change. I decided to put
 * the current money that you have in a JLabel. In the real life, if you go to
 * Las Vegas and you play with the slot machines you are going to have all your
 * coins in a plastic cup. If you win, you are going to put all you coins in
 * that cup.
 * 
 *      Developed by: Santiago De La Torre
 * Last Modification: Dec-2-2010
 * Educationa Center: Bunker Hill Community College.
 ****************************************************************************** 
 */
package slotmachine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class frame extends JFrame {

    BufferedImage img, rightImage, centralImage, leftImage, temp, win;
    int width = 400, height = 400, iTime = 0, iWait = 100,
            iRnd = 0, iTemp = 0, iLeft = 0, iRight, iCenter, iRnd2 = 0,
            iRnd3 = 0, iTemp2 = 0, iTemp3 = 0, iScore = 0, iMoney = 0;
    //current amount of money("the cup").
    JLabel score = new JLabel("1000");
    //Buttons Play and Options.
    JButton play = new JButton("Play");
    JButton options = new JButton("Options");
//Intance of the loadmusic class
    LoadMusic loadMusic = new LoadMusic("ferrari - Michael Schumacher F1 Tecno Racing Sounds.wav");
//instance of the Background class.
    Background DisplayLeft, DisplayRight, DisplayCenter, winner;
    // Instance of random
    Random gen = new Random();
//boolean used to print...
    boolean flag = false;
    Runnable run = new Runnable() {

        public void run() {
            //set the pictures visible while they role
            DisplayLeft.setVisible(true);
            DisplayCenter.setVisible(true);
            DisplayRight.setVisible(true);
            //This round cost you a dollar.
            iScore = Integer.parseInt(score.getText());
            iScore--;
            score.setText(Integer.toString(iScore));
            //Let's wait 2 seconds to match the music
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (iTime < 20000) {
                //Random number from 0-7
                iRnd = gen.nextInt(8);
                iRnd2 = gen.nextInt(8);
                iRnd3 = gen.nextInt(8);

                //Avoid two pictures to be repeated.
                while (iRnd == iTemp) {
                    iRnd = gen.nextInt(8);
                }

                while (iRnd2 == iTemp2) {
                    iRnd2 = gen.nextInt(8);
                }

                while (iRnd3 == iTemp3) {
                    iRnd3 = gen.nextInt(8);
                }

                iTemp2 = iRnd2;
                iTemp3 = iRnd3;
                iTemp = iRnd;

                /* Display the picture according to the number auto-generated
                 * Note: If you want to see how the program behaves when the
                 *       the user wins. Change all parameters of the
                 *       imageDetermination function to the same random variable
                 * Ex:
                 *  DisplayLeft.setBackground(imageDetermination(iRnd,0));
                 *  DisplayCenter.setBackground(imageDetermination(iRnd,1));
                 *  DisplayRight.setBackground(imageDetermination(iRnd,2));
                 */
                DisplayLeft.setBackground(imageDetermination(iRnd, 0));
                DisplayCenter.setBackground(imageDetermination(iRnd2, 1));
                DisplayRight.setBackground(imageDetermination(iRnd3, 2));

                iTime += 110;
                //Let's wait a little before the next image gets displayed
                try {
                    Thread.sleep(iWait);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                }



            }
            iTime = 0;
            //If you win.
            if (isWinner()) {
                //Set the you win image visible
                winner.setVisible(true);
                //Let's make noise.
                new Wave("Louisville fire truck siren.wav").play();
                new Wave("Simplex 4090-1 Bell Test.wav").play();

                /* The next algorythm is the one that puts the "You win!" banner
                 * with the ligths-effect
                 */
                while (iTime < 15000) {
                    if (flag) {
                        try {
                            winner.setBackground("youwin.JPG");
                        } catch (IOException ex) {
                            Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            winner.setBackground("youwin2.JPG");
                        } catch (IOException ex) {
                            Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    flag = !flag;
                    iTime += 100;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //set the winner banner to default
                winner.setVisible(false);
                iTime = 0;
                iScore = Integer.parseInt(score.getText());
                iMoney = 100 - (iRnd * 10);
                //Congratulations! get the prize.
                while (iMoney > 0) {
                    iMoney--;
                    iScore++;
                    score.setText(Integer.toString(iScore));
                    new Wave("Super Mario Bros.-Coin Sound Effect.wav").play();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }


            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //If you don't have money... Game Over
            if (iScore > 0) {
                play.setEnabled(true);
            }
            //Everything set to default
            options.setEnabled(true);
            DisplayLeft.setVisible(false);
            DisplayCenter.setVisible(false);
            DisplayRight.setVisible(false);
        }
    };

    public frame() throws IOException {

        img = rightImage = centralImage = leftImage = temp = win = null;
        img = ImageIO.read(new File("formula1.jpg"));
        win = ImageIO.read(new File("youwin.JPG"));

        setTitle("Formula 1");
        setSize(width, height);
        setLocation(width, height / 2);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Background bck = new Background(img, width, height);
        bck.setBounds(0, 0, width, height);

        play.setBounds(320, 20, 70, 20);
        options.setBounds(240, 20, 80, 20);
        score.setForeground(Color.white);
        score.setBounds(340, 40, 70, 20);

        DisplayLeft = new Background(leftImage, 100, 150);
        DisplayLeft.setBounds(50, 120, 100, 150);

        DisplayCenter = new Background(centralImage, 100, 150);
        DisplayCenter.setBounds(155, 120, 100, 150);

        DisplayRight = new Background(rightImage, 100, 150);
        DisplayRight.setBounds(260, 120, 100, 150);

        winner = new Background(win, 100, 20);
        winner.setBounds(155, 100, 100, 20);
        winner.setVisible(false);

        DisplayLeft.setVisible(false);
        DisplayCenter.setVisible(false);
        DisplayRight.setVisible(false);

        play.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                play.setEnabled(false);
                options.setEnabled(false);

                ExecutorService threxe = Executors.newFixedThreadPool(2);

                threxe.execute(loadMusic);
                threxe.execute(run);

                threxe.shutdown();
            }
        });


        options.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    new options().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });



        add(play);
        add(options);
        add(winner);
        add(score);
        add(DisplayRight);
        add(DisplayCenter);
        add(DisplayLeft);
        add(bck);
        setVisible(true);
        new Wave("F1 pre-season testing Barcelona.wav").play();



    }
    /* The next function is the one who determines the image according to the
     * random number.
     */

    public BufferedImage imageDetermination(int rnd, int iImage) {

        try {
            switch (rnd) {
                case 0:
                    temp = ImageIO.read(new File("sebastianvettel.jpg"));
                    break;
                case 1:
                    temp = ImageIO.read(new File("fernandoalonso.jpg"));
                    break;
                case 2:
                    temp = ImageIO.read(new File("markwebber.jpg"));
                    break;
                case 3:
                    temp = ImageIO.read(new File("lewishamilton.jpg"));
                    break;
                case 4:
                    temp = ImageIO.read(new File("jensonbutton.jpg"));
                    break;
                case 5:
                    temp = ImageIO.read(new File("felipemassa.jpg"));
                    break;
                case 6:
                    temp = ImageIO.read(new File("nicorosberg.jpg"));
                    break;
                case 7:
                    temp = ImageIO.read(new File("michaelschumacher.jpg"));
                    break;
            }
            switch (iImage) {
                case 0:
                    iLeft = rnd;
                    break;
                case 1:
                    iCenter = rnd;
                    break;
                case 2:
                    iRight = rnd;
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public boolean isWinner() {
        if (iLeft == iRight && iLeft == iCenter) {
            return true;
        }
        return false;
    }
}
