/*
 * This class is create very simple instances, and uses the java Audio player
 * to play the wav files.
 *
 *      Developed by: Santiago De La Torre
 * Last Modification: Dec-2-2010
 * Educationa Center: Bunker Hill Community College.
 */
package slotmachine;

import java.io.*;
import sun.audio.*;

class Wave {

    InputStream stream;
    AudioStream audio;
    String filename;

    public Wave(String fileName) {
        filename = fileName;
        try {
            stream = new FileInputStream(fileName);
            audio = new AudioStream(stream);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void play() {
        AudioPlayer.player.start(audio);
    }

    public void stop() {
        AudioPlayer.player.stop(audio);
    }
}
