package main;
import UserTypes.Creator;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an album, containing a collection of media files and associated information such as the album creator, album ID, and name.
 */
public class Album {
    private List<Media_File> AlbumDetails;
    private Creator creatorDetails;
    private Library Library;
    private int AlbumID;
    private String AlbumName;
    private boolean isPlaying=false;
    private double rating;
     private List<Integer> ratings = new ArrayList<>();
    /**
     * Constructs a new Album with specified details.
     *
     * @param AlbumID        The ID of the album.
     * @param AlbumName      The name of the album.
     * @param creatorDetails The creator of the album.
     * @param albumDetails   The list of media files in the album.
     * @param library        The library to which the album belongs.
     */
      public Album(int albumId, String albumName,Creator creatorDetails,List <Media_File> myMediaFiles,Library library) {
        this.AlbumID = AlbumID;
        this.AlbumName = AlbumName;
        this.creatorDetails = creatorDetails;
        this.AlbumDetails = myMediaFiles;
        this.Library = library;
    }
      /**
     * Plays the album.
     *
     * @return A string indicating that the album is now playing.
     */
    public String play() 
    {
        isPlaying = true;
        return "Playing...";
    }
 /**
     * Pauses the album.
     *
     * @return A string indicating that the album is paused.
     */
    public String pause() 
    {
        isPlaying = false;
        return "Paused.";
    }
     /**
     * Adds a media file to the album.
     *
     * @param toAdd         The media file to be added.
     * @param AlbumDetails  The list of media files in the album.
     */
     public void addMediaFile(Media_File toAdd,List<Media_File>AlbumDetails) 
     {
         AlbumDetails.add(toAdd);
     }
       /**
     * Finds a media file by its ID within the album.
     *
     * @param fileId        The ID of the media file to find.
     * @param mediaFileList The list of media files to search.
     * @return The media file with the specified ID, or null if not found.
     */
     public Media_File findMediaFileById(int fileId, List<Media_File> mediaFileList) {
    for (Media_File mediaFile : mediaFileList) {
        if (mediaFile.getId() == fileId) {
            return mediaFile;
        }
    }
    return null; // Return null if the media file with the specified ID is not found
}
     /**
     * Removes a media file from the album by its ID.
     *
     * @param toRemoveID    The ID of the media file to remove.
     * @param albumDetails  The list of media files in the album.
     */
     public void removeMediaFile(int toRemoveID, List<Media_File> albumDetails) {
    albumDetails.remove(findMediaFileById(toRemoveID,albumDetails));
    
}
     /**
     * Adds a user rating to the album.
     *
     * @param userRating The rating to be added.
     */
     public void setRating(int userRating) {
        ratings.add(userRating);
        getAverageRating();
        
    }
      /**
     * Calculates and returns the average rating of the album.
     *
     * @return The average rating, or 0.0 if no ratings are available.
     */
     public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0; // Return 0 if no ratings are available
        }

        int sum = 0;
        for (int ratingg : ratings) {
            sum += ratingg;
        }

        this.rating=(double) sum / ratings.size();
        return 1.0;
    }
      // Getters

    public List<Media_File> getAlbumDetails() {
        return AlbumDetails;
    }

    public Creator getCreatorDetails() {
        return creatorDetails;
    }

    public Library getLibrary() {
        return Library;
    }

    public int getAlbumID() {
        return AlbumID;
    }
    public String getAlbumName() {
        return AlbumName;
    }
    public boolean getisPlaying() {
        return isPlaying;
    }
     public double getRating() {
        return rating;
    }
    public List<Integer> getRatings() {
        return ratings;
    }
    
    // Setters
    
    public void setAlbumDetails(List<Media_File> albumDetails) {
        this.AlbumDetails = albumDetails;
    }

    public void setCreatorDetails(Creator creatorDetails) {
        this.creatorDetails = creatorDetails;
    }

    public void setLibrary(Library Library) {
        this.Library = Library;
    }

    public void setAlbumID(int AlbumID) {
        this.AlbumID = AlbumID;
    }
      public void setAlbumName(String AlbumName) {
        this.AlbumName = AlbumName;
    }
      public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
     public void setRating(double rating) {
        this.rating = rating;
    }
       public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }
    
}