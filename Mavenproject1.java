/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import UserBelongings.Playlist;
import UserBelongings.Profile;
import UserTypes.Creator;
import UserTypes.Staff;
import UserTypes.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import main.Album;
import main.Comment;
import main.Library;
import main.Media_File;
import main.File_type;

/**
 * Hello this is our main we can have a sort of menu where the classes are
 * initially initialized before the
 *
 * @author Abdallah Razid
 */
public class Mavenproject1 {

    List<User> Users = new ArrayList<>();
    ;
        Library library;
 
        
        
        
        public void save () throws FileNotFoundException, IOException{
            String pa = "path/to/my/file.ser";
        File f = new File(pa);
        try (FileOutputStream fos = new FileOutputStream(f, false); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                List <Media_File> projects=new ArrayList<>();
            oos.writeObject(projects);
        }   
    }
    public void load () throws FileNotFoundException, IOException,
            ClassNotFoundException {
        String pa = "path/to/my/file.ser";
        try (FileInputStream fis = new FileInputStream(pa); ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Media_File> projects = (List<Media_File>)ois.readObject();
        }    
    }
    public static void main(String[] args) {   // BEFORE GOING TO THE MENU WE HAVE TO CREATE A USER AND THE MEDIA LIBRARY INITIALIZING THEM BEFORE THE MENU:
        List<Media_File> files = new ArrayList<>();
        Playlist Playlist1 = new Playlist("", files, "", new GregorianCalendar(2023, GregorianCalendar.JANUARY, 15), 0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");
        System.out.println("Welcome to our program here is the menu for you:");
        List<Media_File> items = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        List<Profile> profiles = new ArrayList<>();
        List<Staff> staff = new ArrayList<>();
        Library library = new Library(items, albums, profiles, staff);
        System.out.println("Library created!");
        // here we will create a user in order to be able to use the library's functions
        System.out.println("Creating user:");
        System.out.println("Let's create a user to get started!");
        int id;
        // exception in case of wrong data type enterred.
        while (true) {
            try {
                System.out.print("Enter your ID: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id >= 0) {
                    break;
                } else {
                    System.out.println("Invalid input for ID. Please enter a non-negative integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for ID. Please enter a valid integer.");
            }
        }
        int age = 0;
        // exception in case of wrong data type enterred.

        while (true) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 0) {
                    break;
                } else {
                    System.out.println("Invalid input for age. Please enter a non-negative integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for age. Please enter a valid integer.");
            }
        }
        String name = "";
        // exception for name (it cannot contain digits)
        while (true) {
            try {
                System.out.print("Enter your Name: ");
                String input = scanner.nextLine();
                if (input.matches(".*\\d.*")) {
                    throw new IllegalArgumentException("Error: Name cannot contain numbers. Please enter a valid name.");
                }
                name = input;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        // SIGNING UP(creating account with new email and password):
        System.out.print("Signing up (creating an account with email and password): ");
        //first time logging into the system
        System.out.print("Enter your email: ");
        String email;
        while (true) {
            email = scanner.nextLine();
            if (email.endsWith("@aui.ma")) {
                break;
            } else {
                System.out.println("Invalid email. Please enter an email that ends with @aui.ma");
            }
        }
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        // creating profile 
        Profile userProfile = new Profile(name, 0, 0, "", age, email, password, null, library);
        //a user has a list of followings and followed which are users too
        List<User> Followed = new ArrayList<>();
        List<User> Following = new ArrayList<>();
        //he also has a list of playlists
        List<Playlist> MyPlaylists = new ArrayList<>();
        // initiantiating object of type User using the defined constructor that we created
        User User1 = new User(id, MyPlaylists, userProfile, Followed, Following);
        int choice = 0;
        boolean isLoggedIn = false;
        while (choice != 11) {
            //printing the menu to the user:
            System.out.println("Menu:");
            System.out.println("1.Log in with your email and password");
            System.out.println("2.Add media to library");
            System.out.println("3.Display Library media files");
            System.out.println("4.create playlist");
            System.out.println("5.Add media_file to the playlist");
            System.out.println("6.print playlist content");

            System.out.println("7.Comment media file");
            System.out.println("8.Create your own media file (become a creator)");

            System.out.println("9.Rate media file");
            System.out.println("10.Display ratings");
            System.out.println("11.Terminate the program");

            System.out.print("Enter your choice: ");
            // exception in case of the user not using the right 
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && !isLoggedIn) {
                    System.out.println("Please log in first.");
                    continue;
                }
                switch (choice) {
                    case 1:

                        System.out.println("Please enter your email");
                        String entered_email = scanner.nextLine();
                        System.out.println("Please enter your password");
                        String entered_password = scanner.nextLine();
                        //User is logging in with the same email and password that he had before the switch case else it will print an error
                        isLoggedIn = User1.getUserProfile().logIn(entered_email, entered_password);
                        break;
                    case 2:
                        // this option creates some sample media files to test some things on them and adds them to the media library
                        Media_File media1 = new Media_File(1, "Java podcast", File_type.AUDIO, new GregorianCalendar(2022, GregorianCalendar.JANUARY, 15));
                        Media_File media2 = new Media_File(2, "Java lecture", File_type.VIDEO, new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 20));
                        Media_File media3 = new Media_File(3, "the song", File_type.AUDIO, new GregorianCalendar(2022, GregorianCalendar.MARCH, 25));
                        library.getItems().add(media1);
                        library.getItems().add(media2);
                        library.getItems().add(media3);
                        System.out.println("Three media files were successfully added to the media Library");
                        System.out.println(library.getItems().size());

                        break;
                    case 3:
                        //function to display the content of the library (will print nothing if option 2 wasnt used before
                        library.display();
                        break;
                    case 4:
                        //creating a playlist using name and description it will be empty until the user selects create playlist

                        List<Media_File> elem = new ArrayList<>();
                        System.out.print("Enter the name of the playlist: ");
                        String input = scanner.nextLine();
                        System.out.print("Enter the description of the playlist: ");
                        String input2 = scanner.nextLine();
                        Playlist1 = new Playlist(input, elem, input2, new GregorianCalendar(2023, GregorianCalendar.JANUARY, 15), 0);

                        break;
                    case 5:

                        if (library.getItems().isEmpty()) {
                            System.out.println("You cannot add elements to your playlist because the library does not contain any media files. Click the 'add medias to library' option before doing that.");
                        } else {
                            System.out.println("Here is the list of the library media files:");
                            library.display();
                            System.out.println("Which one do you want to add to your playlist? Type the order of the file (1st slot, 2nd, etc..)");

                            int index = 0;
                            while (true) {
                                try {
                                    System.out.print("Enter the order in which the media file is (1, 2, 3, etc...): ");
                                    index = Integer.parseInt(scanner.nextLine());
                                    if (index > 0 && index <= library.getItems().size()) {
                                        List<Media_File> allTheElements = library.getItems();
                                        Media_File elementAtIndex = allTheElements.get(index - 1);
                                        Playlist1.addMediaFile(elementAtIndex);
                                        break; // Break the loop after successful addition
                                    } else {
                                        System.out.println("Index " + index + " is out of bounds. Please enter a valid index.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input for index. Please enter a valid integer.");
                                }
                            }
                        }
                        break;
                    case 6:
                        Playlist1.display();
                        break;
                    case 7:
                        if (library.getItems().isEmpty()) {
                            System.out.println("No media files to comment on. Please add media files first.");
                        } else {
                            library.display();
                            System.out.println("Please enter the ID of the media file you wish to comment on:");
                            int fileId;
                            while (true) {
                                try {
                                    fileId = Integer.parseInt(scanner.nextLine());
                                    Media_File mediaFile = library.findMediaFileByID(fileId);
                                    if (mediaFile != null) {
                                        System.out.print("Enter your comment: ");
                                        String commentText = scanner.nextLine();
                                        Comment newComment = new Comment(new GregorianCalendar(2023, GregorianCalendar.JANUARY, 15), mediaFile, User1.getUserProfile().getName(), commentText, new ArrayList<>());
                                        mediaFile.addComment(newComment);
                                        System.out.println("Comment added successfully.");
                                        break;
                                    } else {
                                        System.out.println("Media file with ID " + fileId + " not found. Try again.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid integer for the media file ID.");
                                }
                            }
                        }
                        break;
                    case 8:

                        Creator creator;
                        // Check if User1 is a Creator, if not, upgrade User1 to Creator
                        if (User1 instanceof Creator) {
                            creator = (Creator) User1;
                        } else {
                            creator = new Creator(User1);
                            // Optionally update User1 to point to the new Creator instance
                            User1 = creator;
                        }

                        System.out.println("You are now a creator. Let's create a media file.");

                        // Gather information about the new media file
                        System.out.print("Enter media file name: ");
                        String mediaName = scanner.nextLine();

                        System.out.print("Enter media file type (AUDIO/VIDEO/IMAGE/VIDEO): ");
                        File_type fileType = File_type.valueOf(scanner.nextLine().toUpperCase());

                        int year = 0,
                         month = 0,
                         day = 0;
                        boolean validInput = false;

                        // Handling Year Input
                        while (!validInput) {
                            try {
                                System.out.print("Enter release year: ");
                                year = scanner.nextInt();
                                if (year > 0) {
                                    validInput = true;
                                } else {
                                    System.out.println("Invalid year. Please enter a positive number.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // Clear the buffer
                            }
                        }

                        // Handling Month Input
                        validInput = false;
                        while (!validInput) {
                            try {
                                System.out.print("Enter release month (1-12): ");
                                month = scanner.nextInt() - 1; // Adjusting month index for GregorianCalendar
                                if (month >= 0 && month < 12) {
                                    validInput = true;
                                } else {
                                    System.out.println("Invalid month. Please enter a number between 1 and 12.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // Clear the buffer
                            }
                        }

                        // Handling Day Input
                        validInput = false;
                        while (!validInput) {
                            try {
                                System.out.print("Enter release day: ");
                                day = scanner.nextInt();
                                if (day > 0 && day <= 31) { // Basic check, not accounting for different month lengths
                                    validInput = true;
                                } else {
                                    System.out.println("Invalid day. Please enter a number between 1 and 31.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // Clear the buffer
                            }
                        }

                        scanner.nextLine(); // Clear the buffer after last integer input

                        // Create the new media file
                        Media_File newMediaFile = new Media_File(library.getItems().size() + 1, mediaName, fileType, new GregorianCalendar(year, month, day));

                        // Add the new media file to the library
                        library.getItems().add(newMediaFile);
                        creator.addMediaFile(newMediaFile);
                        System.out.println("New media file added to the library successfully!");

                        break;
                    case 9:
                        if (library.getItems().isEmpty()) {
                            System.out.println("You cannot rate elements because the library does not contain any. Click the 'add medias to library' option before doing that.");
                        } else {
                            System.out.println("You want to rate a media file. Here is the list of the library media files:");
                            library.display();
                            System.out.println("Which one do you want to rate? Type the order of the file (1st slot, 2nd, etc..)");
                            int index = 0;
                            int userRating = 0; // Initialize a variable to store the user's rating
                            while (true) {
                                try {
                                    System.out.print("Enter the order in which the media file is (1, 2, 3, etc...): ");
                                    index = Integer.parseInt(scanner.nextLine());
                                    if (index > 0 && index <= library.getItems().size()) {
                                        List<Media_File> allTheElements = library.getItems();
                                        Media_File elementAtIndex = allTheElements.get(index - 1);

                                        // Prompt for rating
                                        System.out.print("Enter your rating (1-5): ");
                                        userRating = Integer.parseInt(scanner.nextLine());

                                        // Check if rating is between 1 and 5
                                        if (userRating >= 1 && userRating <= 5) {
                                            // Call the method with the user rating
                                            User1.rateMedia_file(library, allTheElements, elementAtIndex.getId(), userRating);
                                            System.out.println("Rating added successfully!");
                                            break; // Break out of the loop if everything was successful
                                        } else {
                                            System.out.println("Invalid rating. Please enter a number between 1 and 5.");
                                            // Don't break the loop, ask for the rating again
                                        }
                                    } else {
                                        System.out.println("Index " + index + " is out of bounds.");
                                        // Don't break the loop, ask for the index again
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid integer.");
                                    // Don't break the loop, ask for the index again
                                }
                            }
                        }
                        break;
                    case 10:
                        if (library.getItems().isEmpty()) {
                            System.out.println("You cannot see a media file ratings the library is empty");
                        } else {
                            System.out.println("Here is the list of the library media files:");
                            library.display();
                            System.out.println("Which one do you want to add to your playlist? Type the order of the file (1st slot, 2nd, etc..)");

                            int index = 0;
                            while (true) {
                                try {
                                    System.out.print("Enter the order in which the media file is (1, 2, 3, etc...): ");
                                    index = Integer.parseInt(scanner.nextLine());
                                    if (index > 0 && index <= library.getItems().size()) {
                                        List<Media_File> allTheElements = library.getItems();
                                        Media_File elementAtIndex = allTheElements.get(index - 1);
                                        System.out.println(elementAtIndex.getRating());
                                        break; // Break the loop after successful addition
                                    } else {
                                        System.out.println("Index " + index + " is out of bounds. Please enter a valid index.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input for index. Please enter a valid integer.");
                                }
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid choice, please try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
            }
        }
    }
}
