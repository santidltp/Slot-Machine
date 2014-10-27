/*******************************************************************************
 * This program is a slot machine simulation, in which you press a button
 * and three images change randomly. You have a $1000 when you start the program
 * and everytime you hit play, you pay a dollar. To win you need to match three
 * of the images. Depending on which image you match your price is going
 * to be different. There are eight different images and eight different prices.
 * This program is a multiplethread application, which allows you  to
 * perform more than one action at the same time.
 * This program shares a lot of similarities with the one that was witten by
 * Diana Esteves. But for this program I chose the topic I like the most, which
 * is the Formula 1. The pictures that are going to be displayed are Formula 1
 * drivers. The relationship driver-price depends on the results of the 2010
 * season of the Formula 1.
 * Sounds and music play a very important role in this game. What kind of game
 * would this program be without any sound or music. All sounds and music that
 * is used in this program is not self-made. In the following list I´m attaching
 * the resources where all the audio comes from:
 *******************************************************************************
 *
 *   Resource: Youtube.com
 *        URL: http://www.youtube.com/watch?v=-f5HtTBh9EY
 *  File Name: F1 pre-season testing Barcelona.wav
 *  Play Role: Intro.
 *
 *   Resource: Youtube.com
 *        URL: http://www.youtube.com/watch?v=I1xXV1R4yVY
 *  File Name: ferrari - Michael Schumacher F1 Tecno Racing Sounds.wav
 *  Play Role: While play is in action.
 *
 *   Resource: Youtube.com
 *        URL: http://www.youtube.com/watch?v=I1xXV1R4yVY
 *  File Name: ferrari - Michael Schumacher F1 Tecno Racing Sounds_1.wav
 *  Play Role: options.
 *
 *   Resource: Youtube.com
 *        URL: http://www.youtube.com/watch?v=NASwiFe8UqQ
 *  File Name: Simplex 4090-1 Bell Test.wav
 *  Play Role: Winner bell.
 *
 *   Resource: Youtube.com
 *        URL: http://www.youtube.com/watch?v=l70yarlcd-I
 *  File Name: Louisville fire truck siren.wav
 *  Play Role: Winner bell.
 *
 *  This Program is not to be commercialized or to get money out of it.
 *  No copyright infringement intended
 *
 *      Developed by: Santiago De La Torre
 * Last Modification: Dec-2-2010
 * Educationa Center: Bunker Hill Community College.
 ******************************************************************************
 */

package slotmachine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new frame();//new instance of the program.
    }
}
