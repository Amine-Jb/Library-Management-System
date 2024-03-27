package medias;
import main.*;
import java.util.GregorianCalendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Represents a video file with additional properties such as resolution and duration.
 * Extends the Media_File class to include video-specific functionality.
 *
 * 
 */
public class Video extends Media_File
{
    private String resolution;
    private int duration;
    private boolean isMuted;
    private boolean isPlaying;
    
    /**
     * Constructs a new Video instance.
     * 
     * @param id        The unique identifier for the video.
     * @param name      The name of the video.
     * @param file_type The type of the media file.
     * @param owner_id  The identifier of the owner of the video.
     * @param date      The date when the video was created or uploaded.
     * @param resol     The resolution of the video.
     * @param duration  The duration of the video in seconds.
     */
    public Video(int id, String name, File_type file_type, String owner_id, GregorianCalendar date,String resol,int duration) {
        super(id, name, file_type, date);
        this.resolution=resol;
        this.duration=duration;
        this.isMuted = false;
        this.isPlaying = false;
    }
/**
     * Plays the video.
     * 
     * @param name The name of the video to be played.
     * @return A string message indicating that the video is playing.
     */
    public String play(String name) {
        isPlaying = true;
        return "Playing: " + name + "!";
    }

 /**
     * Pauses the video.
     * 
     * @param name The name of the video to be paused.
     * @return A string message indicating that the video is paused.
     */
    public String pause(String name) {
        isPlaying = false;
        return "Pausing: " + name + "!";
    }

 /**
     * Rewinds the video.
     * 
     * @param name The name of the video to be rewound.
     * @return A string message indicating that the video is rewinding.
     */
    public String rewind(String name) {
        return "Rewinding: " + name + "!";
    }

    /**
     * Fast forwards the video.
     * 
     * @param name     The name of the video to be fast-forwarded.
     * @param duration The duration in seconds to fast forward.
     * @return A string message indicating that the video is fast forwarding.
     */
    public String fastForward(String name, int duration) {
        return "Fast forwarding " + name + " by " + duration + " seconds!";
    }
 /**
     * Mutes the video.
     * 
     * @param name The name of the video to be muted.
     * @return A string message indicating that the video is muted.
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
     * Unmutes the video.
     * 
     * @param name The name of the video to be unmuted.
     * @return A string message indicating that the video is unmuted.
     */
    public String unMute(String name) {
        if(isMuted==true)
        {
        isMuted = false;
        return "Unmuted: " + name + "!";
    }
        return"The video:"+ name +"is already unsmuted!";
    }

   
    public int getDuration() {
        return duration;
    }


    public String getResolution() {
        return resolution;
    }

 
    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    
    public boolean isVideoPlaying() {
        return isPlaying;
    }
    
    
}
