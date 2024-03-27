package UserTypes;

import main.*;
import UserTypes.User;
import UserBelongings.Profile;
import UserBelongings.Playlist;
import java.util.List;

/**
 * Represents a staff member, extending the functionality of a User with
 * staff-specific attributes and capabilities.
 */
public class Staff extends User {

    private String jobTitle;
    private String department;
    private String shiftSchedule;
    private Library library;

    /**
     * Constructs a new Staff member with specified user and staff-specific
     * details.
     *
     * @param id The ID of the staff member.
     * @param myPlaylists The staff member's playlists.
     * @param userProfile The profile of the staff member.
     * @param followedUsers The list of users followed by the staff member.
     * @param followingUsers The list of users following the staff member.
     * @param jobTitle The job title of the staff member.
     * @param department The department where the staff member works.
     * @param shiftSchedule The shift schedule of the staff member.
     */
    public Staff(int id, List<Playlist> myPlaylists, Profile userProfile, List<User> followedUsers, List<User> followingUsers,
             String employeeID, String jobTitle, String department, String shiftSchedule) {
        super(id, myPlaylists, userProfile, followedUsers, followingUsers);

        this.jobTitle = jobTitle;
        this.department = department;
        this.shiftSchedule = shiftSchedule;
    }

    /**
     * Removes a specified media file from the library.
     *
     * @param library The library from which to remove the media file.
     * @param media The media file to be removed.
     */
    public void RemoveMedia(Library library, Media_File media) {
        int mediaIdToRemove = media.getId();
        List<Media_File> libraryMediaFiles = library.getItems();

        for (Media_File file : libraryMediaFiles) {
            if (file.getId() == mediaIdToRemove) {
                libraryMediaFiles.remove(file);
                System.out.println("Media with ID " + mediaIdToRemove + " removed from the library.");
                return;
            }
        }

        System.out.println("Media with ID " + mediaIdToRemove + " not found in the library.");
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShiftSchedule() {
        return shiftSchedule;
    }

    public void setShiftSchedule(String shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }

}
