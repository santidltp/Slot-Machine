/*
 * This class is used to play music while you are playing. And is written in a
 * different class so the program can consider this as one proces. In that way
 * the program can change the images and play the music at the same time.
 *
 *
 *      Developed by: Santiago De La Torre
 * Last Modification: Dec-2-2010
 * Educationa Center: Bunker Hill Community College.
 *
 */
package slotmachine;

public class LoadMusic implements Runnable {

    String file;

    public LoadMusic(String fileName) {
        file = fileName;
    }

    public void run() {
        new Wave(file).play();
    }
}
