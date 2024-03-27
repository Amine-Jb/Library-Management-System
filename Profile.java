package UserBelongings;

import main.*;
import UserTypes.User;

/**
 * Represents a user profile with details such as name, subscriber count, bio,
 * age, and associated library.
 */
public class Profile {

    private String Name;
    private int N_of_subscribers;
    private int N_of_following;
    private String Bio;
    private int age;
    private String email;
    private String password;
    private User user;
    private Library library;

    // Constructor
    /**
     * Constructs a new Profile with specified user details.
     *
     * @param Name The name of the user.
     * @param N_of_subscribers Number of subscribers the user has.
     * @param N_of_following Number of users the user is following.
     * @param Bio The biography of the user.
     * @param age The age of the user.
     * @param email The email of the user.
     * @param password The password for the user's account.
     * @param user The associated User object.
     * @param library The associated Library object.
     */
    public Profile(String Name, int N_of_subscribers, int N_of_following, String Bio, int age, String email, String password, User user, Library library) {
        this.Name = Name;
        this.N_of_subscribers = N_of_subscribers;
        this.N_of_following = N_of_following;
        this.Bio = Bio;
        this.age = age;
        this.email = email;
        this.password = password;
        this.user = user;
        this.library = library;
    }

    // Edit bio method
    /**
     * Edits the biography of the user's profile.
     *
     * @param modification The new biography to be set.
     */
    public void editBio(String modification) {
        this.Bio = modification;
    }

    // Log in method
    /**
     * Attempts to log in with the provided email and password.
     *
     * @param email The email to log in with.
     * @param password The password to log in with.
     * @return true if login is successful, false otherwise.
     */
    public boolean logIn(String email, String password) {
        if (email.equals(this.email) && password.equals(this.password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed. Invalid email or password.");
            return false;
        }
    }

    // Sign up method
    /**
     * Signs up with the provided email and password.
     *
     * @param email The email for the new account.
     * @param password The password for the new account.
     */
    public void signUp(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Log out method
    /**
     * Logs out of the account.
     *
     * @return A message indicating successful logout.
     */
    public String logOut() {
        return "Logout successful!";
    }

    // Change email method
    /**
     * Changes the email of the user's account.
     *
     * @param email The new email to be set.
     * @return A message indicating successful email change.
     */
    public String changeEmail(String email) {
        this.email = email;
        return "Email changed successfully!";
    }

    // Change password method
    /**
     * Changes the password of the user's account.
     *
     * @param password The new password to be set.
     * @return A message indicating successful password change.
     */
    public String changePassword(String password) {
        this.password = password;
        return "Password changed successfully!";
    }

    // Getters and setters for Profile
    public String getName() {
        return this.Name;
    }

    public int getN_of_Subscribers() {
        return this.N_of_subscribers;
    }

    public int getN_of_Following() {
        return this.N_of_following;
    }

    public int getAge() {
        return this.age;
    }

    public String getBio() {
        return this.Bio;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setN_of_Subscribers(int N_of_subscribers) {
        this.N_of_subscribers = N_of_subscribers;
    }

    public void setN_of_Following(int N_of_following) {
        this.N_of_following = N_of_following;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }

    // Getters and setters for Account
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Library getLibrary() {
        return library;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getN_of_subscribers() {
        return this.N_of_subscribers;
    }

    public void setN_of_subscribers(int N_of_subscribers) {
        this.N_of_subscribers = N_of_subscribers;
    }

    public int getN_of_following() {
        return this.N_of_following;
    }

    public void setN_of_following(int N_of_following) {
        this.N_of_following = N_of_following;
    }
}
