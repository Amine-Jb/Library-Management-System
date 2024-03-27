package UserTypes;


import main.*;
import UserBelongings.Profile;
import UserBelongings.Playlist;
import java.util.List;
import java.util.Scanner;
import  java.util.GregorianCalendar;
/**
 * Represents a user with the ability to create playlists, rate albums and media files, and follow/unfollow other users.
 */
public class User
{
  private int id;
  private List<Playlist> MyPlaylists;
  private Profile UserProfile;
  private List<User> FollowedUsers;
  private List<User> FollowingUsers;
   /**
     * Constructs a new User with the given details.
     *
     * @param id            The user's ID.
     * @param myPlaylists   The user's playlists.
     * @param userProfile   The user's profile.
     * @param followedUsers The list of users followed by this user.
     * @param FollowingUsers The list of users following this user.
     */
    public User(int id, List<Playlist> myPlaylists, Profile userProfile, List<User> followedUsers,List<User> FollowingUsers) {
        this.id = id;
        this.MyPlaylists = myPlaylists;
        this.UserProfile = userProfile;
        this.FollowedUsers = followedUsers;
        this.FollowingUsers=FollowingUsers;
    }
/**
     * Creates a new playlist with the specified details and adds it to the user's playlists.
     *
     * @param nameOfPlaylist    The name of the playlist.
     * @param content           The list of media files in the playlist.
     * @param description       The description of the playlist.
     * @param date              The date of creation of the playlist.
     * @param number_of_elements The number of elements in the playlist.
     * @return A string indicating that the playlist was created successfully.
     */
public String createPlaylist(String nameOfPlaylist, List<Media_File> content,String description, GregorianCalendar date, int number_of_elements) {        
        Playlist newPlaylist = new Playlist(nameOfPlaylist, content,description,date,number_of_elements);
        this.MyPlaylists.add(newPlaylist);
        return "Playlist created successfully!";
    }
/**
     * Rates an album by its ID.
     *
     * @param Albums  The list of albums to search from.
     * @param albumId The ID of the album to be rated.
     * @return true if the album is found and rated, false otherwise.
     */
 public boolean rateAlbum(List <Album> Albums, int albumId,int userRating) {
        Album targetAlbum = findAlbumById(Albums, albumId);

        if (targetAlbum != null) {
            targetAlbum.setRating(userRating);
            System.out.println("Rating set successfully!");
            return true;
        } else {
            System.out.println("Album not found.");
            return false;
        }
    }
 /**
     * Rates a media file by its ID.
     *
     * @param library          The library containing the media files.
     * @param Media_FileId     The ID of the media file to be rated.
     * @param userRating       The rating to be set.
     * @return true if the media file is found and rated, false otherwise.
     */
 public boolean rateMedia_file(Library library,List <Media_File> libraryMediaFiles, int Media_FileId,int userRating) {
        Media_File targetMedia_File = library.findMediaFileByID(Media_FileId);

        if (targetMedia_File != null) {
            targetMedia_File.setRating(userRating);
            System.out.println("Rating set successfully!");
            return true;
        } else {
            System.out.println("Media file not found.");
            return false;
        }
    }
 /**
 * Searches for an album by its ID within a given list of albums.
 *
 * @param albums  The list of albums to search.
 * @param AlbumId The ID of the album to find.
 * @return The album with the specified ID, or null if no such album is found.
 */
    private Album findAlbumById(List <Album> albums, int AlbumId) {

        for (Album album : albums) {
            if (album.getAlbumID() == AlbumId) {
                return album;
            }
        }

        return null; // Album not found
    }

    // Follow User method
    /**
 * Follows another user, adding them to this user's list of followed users.
 *
 * @param userToFollow The user to follow.
 */
    public void followUser(User userToFollow) {
        FollowingUsers.add(userToFollow);
        userToFollow.addFollower(this);
    }
/**
 * unfollow another user, removing them from this user's list of followed users.
 *
 * @param userToUnfollow The user to unfollow.
 */
    public void unfollowUser(User userToUnfollow) {
        FollowingUsers.remove(userToUnfollow);
        userToUnfollow.removeFollower(this);
    }
/**
 * Adds a follower to this user's list of followers.
 *
 * @param follower The user who is following this user.
 */
    public void addFollower(User follower) {
        FollowedUsers.add(follower);
    }
/**
 * Removes a follower from this user's list of followers.
 *
 * @param follower The user to remove from the followers list.
 */
    public void removeFollower(User follower) {
        FollowedUsers.remove(follower);
    }
    /**
 * Prints information about this user, including ID, name, age, bio, number of followers, number of following, and email address.
 */
    public void printUserInfo() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + UserProfile.getName());
        System.out.println("Age: " + UserProfile.getAge());
        System.out.println("Bio: " + UserProfile.getBio());
        System.out.println("Followers: " + UserProfile.getN_of_subscribers());
        System.out.println("Following: " + UserProfile.getN_of_following());
        System.out.println("Email adress: " + UserProfile.getEmail());
        System.out.println("ID: " + this.id);
        
    }
    // Getters
    public int getId() {
        return id;
    }

    public List<Playlist> getMyPlaylists() {
        return this.MyPlaylists;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setMyPlaylists(List<Playlist> playlists) {
        this.MyPlaylists = playlists;
    }
public Profile getUserProfile() {
        return UserProfile;
    }

    public List<User> getFollowedUsers() {
        return FollowedUsers;
    }

    public List<User> getFollowingUsers() {
        return FollowingUsers;
    }
    public void setUserProfile(Profile userProfile) {
        this.UserProfile = userProfile;
    }

    public void setFollowedUsers(List<User> followedUsers) {
        this.FollowedUsers = followedUsers;
    }

    public void setFollowingUsers(List<User> followingUsers) {
        this.FollowingUsers = followingUsers;
    }
    
    }

    









