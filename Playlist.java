package UserBelongings;

import main.*;
import java.util.List;
import java.util.GregorianCalendar;

/**
 * Represents a playlist containing a collection of media files.
 */
public class Playlist {

    // Attributes
    private String Title;
    private List<Media_File> elements;
    private String Description;
    private GregorianCalendar date;
    private int number_of_elements;

    // Constructor
    /**
     * Constructs a new Playlist with specified details.
     *
     * @param Title The title of the playlist.
     * @param elements The list of media files in the playlist.
     * @param Description The description of the playlist.
     * @param date The creation date of the playlist.
     * @param number_of_elements The number of elements in the playlist.
     */
    public Playlist(String Title, List<Media_File> elements, String Description, GregorianCalendar date, int number_of_elements) {
        this.Title = Title;
        this.elements = elements;
        this.Description = Description;
        this.date = date;
        this.number_of_elements = number_of_elements;
    }

    // Behaviors
    /**
     * Adds a media file to the playlist.
     *
     * @param ToAdd The media file to be added.
     */
    public void addMediaFile(Media_File ToAdd) {
        this.elements.add(ToAdd);

    }

    /**
     * Changes the title of the playlist.
     *
     * @param Title The new title of the playlist.
     */
    public void ChangeTitle(String Title) {
        this.Title = Title;
    }

    /**
     * Adds a description to the playlist.
     *
     * @param Description The description to be added to the playlist.
     */
    public void AddDescription(String Description) {
        this.Description = Description;
    }

    /**
     * Displays information about each media file in the playlist. If the
     * playlist is empty, a message indicating that is printed.
     */
    public void display() {
        //checking if library is empty else printing the content of the library
        if (elements.size() == 0) {
            System.out.println("Playlist is empty");
        } else {
            for (Media_File mediafile : elements) {
                System.out.println(mediafile.displayInfo());
            }
        }
    }

    /**
     * Shares the playlist. This method currently only prints a message
     * indicating successful sharing.
     */
    public void SharePlaylist() {
        System.out.println("Playlist shared successfully!");
    }

    /**
     * Plays the playlist. This method currently only prints a message
     * indicating successful playing.
     */
    public void Play() {
        System.out.println("Playing playlist!");
    }

    public String GetTitle() {
        return this.Title;
    }

    public int Getnumber_of_elements() {
        return this.number_of_elements;
    }

    public GregorianCalendar Getdate() {
        return this.date;
    }

    public void SetTitle(String Title) {
        this.Title = Title;
    }

    public void Setnumber_of_elements(int number_of_elements) {
        this.number_of_elements = number_of_elements;
    }

    public void Setdate(GregorianCalendar date) {
        this.date = date;
    }

}
