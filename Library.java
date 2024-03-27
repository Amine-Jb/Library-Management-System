package main;

import UserTypes.Staff;
import java.util.List;
import UserBelongings.Profile;
import UserTypes.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

/**
 * This class represent the media library which is a list of media files
 *
 * @author Abdallah Razid
 */
public class Library<T> {

    private List<Media_File> Items;
    private List<Album> Albums;
    private List<Profile> Profiles;
    private List<Staff> Staff;

    // Constructors...
    /**
     * Constructs a Library with specified lists of media files, albums,
     * profiles, and staff.
     *
     * @param items the list of media files
     * @param albums the list of albums
     * @param profiles the list of user profiles
     * @param staff the list of staff members
     */
    public Library(List<Media_File> items, List<Album> albums, List<Profile> profiles, List<Staff> staff) {
        this.Items = items;
        this.Albums = albums;
        this.Profiles = profiles;
        this.Staff = staff;
    }

    // Search by title
    /**
     * Searches for a media file by its title.
     *
     * @param title the title of the media file to search for
     * @return the media file with the matching title, or null if not found
     */
    public Media_File findMediaFileByTitle(String title) {
        List<Media_File> libraryMediaFiles = this.getItems();

        for (Media_File mediaFile : libraryMediaFiles) {
            if (mediaFile.getName().equalsIgnoreCase(title)) {
                return mediaFile;
            }
        }
        return null; // Return null if the media file with the specified ID is not found in the library
    }

    // Search by ID
    /**
     * Searches for a media file by its ID.
     *
     * @param ID the ID of the media file to search for
     * @return the media file with the matching ID, or null if not found
     */
    public Media_File findMediaFileByID(int ID) {
        List<Media_File> libraryMediaFiles = this.getItems();

        for (Media_File mediaFile : libraryMediaFiles) {
            if (mediaFile.getId() == ID) {
                return mediaFile;
            }
        }
        return null;
    }

    // Display items
    /**
     * Displays information about the media files in the media library If the
     * library is empty a message indicating that the library is empty will be
     * printed Else it prints information about each media file in the library
     *
     * @author Abdallah Razid
     */
    public void display() {
        //checking if library is empty else printing the content of the library
        if (Items.size() == 0) {
            System.out.println("Library is empty");
        } else {
            for (Media_File mediafile : Items) {
                System.out.println(mediafile.displayInfo());
            }
        }
    }

    /**
     * Sorts the media items in the library based on a specified key extractor
     * function.
     *
     * @param keyExtractor a function that extracts a Comparable key from a
     * media file It basically takes for example media file and takes one of its
     * attributes to use it for sorting
     */
    public void sortItems(Function<Media_File, Comparable> keyExtractor) {
        Comparator<Media_File> comparator = Comparator.comparing(keyExtractor);
        Collections.sort(Items, comparator);
    }

    // Filtering items
    /**
     * Displays information about the media files in the media library But
     * filtering is applied which means it will only print files of a certain
     * type (only audio files only video files etc..) it checks if the library
     * is empty before doing that.
     *
     * @author Abdallah Razid
     */
    public void filtering(File_type type) {
        if (Items.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            for (Media_File mediaFile : Items) {
                if (mediaFile.getFile_type() == type) {
                    System.out.println(mediaFile.displayInfo());
                }
            }
        }
    }

    // Getters and Setters...
    /**
     * To get the items in the media library this is a getter it returns a list
     * of media files
     *
     * @return the list of media files in the library
     *
     * @author Abdallah Razid
     */
    public List<Media_File> getItems() {
        return Items;
    }

    public List<Album> getAlbums() {
        return Albums;
    }

    public List<Profile> getProfiles() {
        return Profiles;
    }

    public List<Staff> getStaff() {
        return Staff;
    }

    public void setItems(List<Media_File> items) {
        this.Items = items;
    }

    public void setAlbums(List<Album> albums) {
        this.Albums = albums;
    }

    public void setProfiles(List<Profile> profiles) {
        this.Profiles = profiles;
    }

    public void setStaff(List<Staff> staff) {
        this.Staff = staff;
    }
}
