package medias;
import java.util.GregorianCalendar;
import main.*;
/**
 * Represents an audio file, extending the Media_File class with audio-specific properties and methods.
 * Includes capabilities for playing, pausing, muting, and unmuting the audio.
 */
public class Audio extends Media_File {
    private int duration;
    private boolean isMuted;
    private boolean isPlaying;
    
    /**
     * Constructs a new Audio instance.
     * 
     * @param id         The unique identifier for the audio file.
     * @param name       The name of the audio file.
     * @param file_type  The type of the media file, typically indicating an audio file.
     * @param owner_id   The identifier of the owner of the audio file.
     * @param date       The date when the audio was created or uploaded.
     * @param duration   The duration of the audio in seconds.
     */
    public Audio(int id, String name, File_type file_type, String owner_id, GregorianCalendar date,int duration) {
        super(id, name, file_type, date);
        this.duration=duration;
        this.isMuted=false;
        this.isPlaying=false;
        
    }
     /**
     * Mutes the audio file.
     * 
     * @param name The name of the audio file to be muted.
     * @return     A string message indicating the mute status of the audio.
     */
     public String mute(String name) {
        if(isMuted==false)
        {
        isMuted = true;
        return "Muted: " + name + "!";
    }
        return"The video:"+ name +"is already muted!";
    }
  /**
     * Unmutes the audio file.
     * 
     * @param name The name of the audio file to be unmuted.
     * @return     A string message indicating the unmute status of the audio.
     */
    public String unMute(String name) {
        if(isMuted==true)
        {
        isMuted = false;
        return "Unmuted: " + name + "!";
    }
        return"The video:"+ name +"is already unsmuted!";
    }
      /**
     * Plays the audio file.
     * 
     * @param name The name of the audio file to be played.
     * @return     A string message indicating that the audio is playing.
     */
    public String play(String name) {
        isPlaying = true;
        return "Playing: " + name + "!";
    }
/**
     * Pauses the audio file.
     * 
     * @param name The name of the audio file to be paused.
     * @return     A string message indicating that the audio is paused.
     */

    public String pause(String name) {
        isPlaying = false;
        return "Pausing: " + name + "!";
    }
     /**
     * Sets a new duration for the audio file.
     * 
     * @param duration The new duration of the audio in seconds.
     */
    
    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    public int getDuration() {
        return duration;
    }
    
}
