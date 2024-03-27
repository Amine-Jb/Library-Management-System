package main;

import java.util.ArrayList;
import java.util.List;
import  java.util.GregorianCalendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */

 
public class Media_File {
    private int id;
    private String name;
    private File_type file_type;
    private double rating;
    private List<Comment> Comments= new ArrayList<>();
    private List<Integer> ratings = new ArrayList<>();
    private GregorianCalendar date;
    

 
    // the constructor
    /**
     * Constructs a new Media_File with the specified details.
     *
     * @param id        The ID of the media file.
     * @param name      The name of the media file.
     * @param file_type The type of the media file (e.g., AUDIO, VIDEO).
     * @param date      The date associated with the media file.
     */
    public Media_File(int id, String name, File_type file_type,GregorianCalendar date) {
        this.id = id;
        this.name = name;
        this.file_type = file_type;
        this.date=date;
    }
     /**
     * Adds a user rating to the media file.
     *
     * @param userRating The rating to be added.
     */
 public void setRating(int userRating) {
        ratings.add(userRating);
        getAverageRating();
        //each time a user computes a rating it is added to the list of integers and the average of this array is updated to the double rating 
    }
 /**
     * Calculates and returns the average rating of the media file.
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
        return this.rating;
    }
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public File_type getFile_type() {
        return file_type;
    }
 
    public void setFile_type( File_type file_type) {
        this.file_type = file_type;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
  // Method to add a comment
    public void addComment(Comment comment) {
        Comments.add(comment);
    }

    // Method to get all comments
    public List<Comment> getComments() {
        return Comments;
    }
 
    public String displayInfo() {
        return "Name: " + getName() + "\nID: " + getId() + "\nFile Type: " + getFile_type() + "\n"
                ;

    }
}