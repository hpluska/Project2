import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The <code>Song</code> class represents a song. Each song
 * has a title, artist, play time, and file path.
 *
 * Here is an example of how a song can be created.
 * <pre>
 *     Song song = new Song("Amsterdam", "Paul Oakenfold", 318, "sounds/Amsterdam.mp3");
 * </pre>
 *
 * Here is an example of how a song can be used.
 * <pre>
 *     System.out.println("Artist: " + song.getArtist());
 *     System.out.println(song);
 * </pre>
 *
 * @author Pluska
 */
public class Song {

    private Clip clip;

    private String title;
    private String artist;
    private int playTime; // in seconds
    private String songPath;
    private File songFile;
    private int playCount;
    /**
     * Constructor: Builds a song using the given parameters.
     * @param tempTitle song title
     * @param tempArtist song artist
     * @param tempPlayTime song length in seconds
     * @param tempSongPath path to song file
     */
    public Song(String tempTitle, String tempArtist,
                int tempPlayTime, String tempSongPath){

        title = tempTitle;
        artist = tempArtist;
        playTime = tempPlayTime;

        songPath = tempSongPath;
        songFile = new File(songPath);
        playCount = 0;

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(songFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);


            try {
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(audioStream);
            } catch (LineUnavailableException ex) {

            }



        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }







        //try{
        //    clip  = AudioSystem.getClip();
        //    clip.open(AudioSystem.getAudioInputStream(songFile));
        //}catch(Exception e){

        //}

    }

    /**
     * Returns the title of this <code>Song</code>.
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     *  Returns the artist of this <code>Song</code>.
     * @return the artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     *  Returns the play time of this <code>Song</code> in seconds.
     * @return the playTime
     */
    public int getPlayTime()
    {
        return playTime;
    }


    /**
     * Returns the file path of this <code>Song</code>.
     * @return the songPath
     */
    public String getSongPath()
    {
        return songPath;
    }

    /**
     * Returns the number of times this song has been played.
     * @return the count
     */
    public int getPlayCount()
    {
        return playCount;
    }

    /**
     * Plays this song
     */
    public void playSong(){

        if(clip != null) {

            clip.start();
            playCount++;

            try {
                Thread.sleep(clip.getMicrosecondLength()/1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }

    /**
     * Stops this song from playing.
     */
    public void stop()
    {
        if(clip != null) {

            clip.stop();

        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return String.format("%-15s %-15s %-15d %15s",
                title, artist, playTime, songPath);
    }
}