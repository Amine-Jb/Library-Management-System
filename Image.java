package medias;
import main.*;
import java.util.GregorianCalendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Represents an image file with properties such as dimensions, quality, and filter type.
 * Extends the Media_File class to include image-specific functionalities.
 *
 * @author HP
 */ 
public class Image extends Media_File {
     private int width;
    private int height;
    private int degrees;
    private String quality;
    private String filterType;
    private String description;
    /**
     * Constructs a new Image instance.
     *
     * @param id         The unique identifier for the image.
     * @param name       The name of the image.
     * @param file_type  The type of the media file.
     * @param owner_id   The identifier of the owner of the image.
     * @param date       The date when the image was created or uploaded.
     * @param width      The width of the image in pixels.
     * @param height     The height of the image in pixels.
     * @param degrees    The rotation degree of the image.
     * @param quality    The quality of the image.
     * @param filterType The type of filter applied to the image.
     * @param description A description of the image.
     */
   public Image(int id, String name, File_type file_type, String owner_id, GregorianCalendar date,
             int width, int height, int degrees, String quality, String filterType, String description) {
    super(id, name, file_type, date);
    this.width = width;
    this.height = height;
    this.degrees = degrees;
    this.quality = quality;
    this.filterType = filterType;
    this.description = description;
}
   /**
     * Resizes the image to new dimensions.
     *
     * @param newWidth  The new width in pixels.
     * @param newHeight The new height in pixels.
     */
    public void resize(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }
 /**
     * Rotates the image by a specified number of degrees.
     *
     * @param degrees The degrees to rotate the image.
     */
    public void rotate(int degrees) {
        this.degrees = degrees;
    }
/**
     * Compresses the image to a specified quality level.
     *
     * @param quality The quality level to compress the image to.
     */
    public void compress(String quality) {
        this.quality = quality;
    }
/**
     * Applies a filter to the image.
     *
     * @param filterType The type of filter to apply to the image.
     */
    public void addFilter(String filterType) {
        this.filterType = filterType;
    }

    // Getters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getDescription() {
        return description;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getQuality() {
        return quality;
    }

    public int getDegrees() {
        return degrees;
    }

    // Setters
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
