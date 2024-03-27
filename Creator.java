package UserTypes;

import main.*;
import UserBelongings.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
import java.util.List;

public class Creator extends User {

    private List<Media_File> myMediaFiles;
    private List<Album> myAlbums;

    // Constructor
    /**
     * Constructs a Creator with the specified user details, media files, and
     * albums.
     *
     * @param id the user's ID
     * @param myPlaylists the user's playlists
     * @param userProfile the user's profile
     * @param followedUsers the list of users followed by this user
     * @param followingUsers the list of users following this user
     * @param myMediaFiles the media files created by the user
     * @param myAlbums the albums created by the user
     */
    public Creator(int id, List<Playlist> myPlaylists, Profile userProfile, List<User> followedUsers, List<User> followingUsers, List<Media_File> myMediaFiles, List<Album> myAlbums) {
        super(id, myPlaylists, userProfile, followedUsers, followingUsers);
        this.myMediaFiles = myMediaFiles;
        this.myAlbums = myAlbums;
    }

    /**
     * Constructs a Creator from an existing User.
     *
     * @param user the User to be upgraded to a Creator
     */
    public Creator(User user) {
        // Call the super constructor with User's properties
        super(user.getId(), user.getMyPlaylists(), user.getUserProfile(), user.getFollowedUsers(), user.getFollowingUsers());

        // Initialize myMediaFiles and myAlbums for Creator
        this.myMediaFiles = new ArrayList<>();
        this.myAlbums = new ArrayList<>();
    }
    // Methods

    // Create a new album
    /**
     * Constructs a Creator from an existing User.
     *
     * @param user the User to be upgraded to a Creator
     */
    public Album createAlbum(String albumName, List<Media_File> myMediaFiles, int albumId, Creator creatorDetails, Library library) {
        Album newAlbum = new Album(albumId, albumName, creatorDetails, myMediaFiles, library);
        newAlbum.setAlbumName(albumName);
        newAlbum.setAlbumDetails(myMediaFiles);
        myAlbums.add(newAlbum);
        return newAlbum;
    }

    // Add a new media file
    /**
     * Adds a new media file to the Creator's collection.
     *
     * @param toAdd the media file to add
     * @return the updated list of the Creator's media files
     */
    public List<Media_File> addMediaFile(Media_File toAdd) {
        myMediaFiles.add(toAdd);
        return myMediaFiles;
    }

    // Remove a media file
    /**
     * Removes a media file from the Creator's collection by its ID.
     *
     * @param myMediaFiles the list of media files
     * @param idToRemove the ID of the media file to remove
     * @return the updated list of the Creator's media files
     */
    public List<Media_File> removeMediaFile(List<Media_File> myMediaFiles, int idToRemove) {

        for (Media_File mediaFile : myMediaFiles) {
            if (mediaFile.getId() == idToRemove) {
                myMediaFiles.remove(mediaFile);
            }
        }

        return myMediaFiles;
    }

    // View the rating of a media file
    /**
     * Views the rating of a specified media file.
     *
     * @param file the media file whose rating is to be viewed
     * @return the rating of the media file
     */
    public String viewFileRating(Media_File file) {

        return "Rating: " + file.getRating();
    }

    // Getters
    public List<Media_File> getMyMediaFiles() {
        return myMediaFiles;
    }

    public List<Album> getMyAlbums() {
        return myAlbums;
    }

    // Setters
    public void setMyMediaFiles(List<Media_File> myMediaFiles) {
        this.myMediaFiles = myMediaFiles;
    }

    public void setMyAlbums(List<Album> myAlbums) {
        this.myAlbums = myAlbums;
    }
}
