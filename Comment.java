package main;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Represents a comment made on a media file, including details such as the
 * date, author, and content of the comment.
 */
public class Comment {

    private GregorianCalendar date;
    private Media_File media_file_to_comment;
    private String author;
    private String typeComment;
    private List<Comment> reply;

    // Constructor
    /**
     * Constructs a new Comment with specified details.
     *
     * @param date The date of the comment.
     * @param media_file_to_comment The media file that the comment is made on.
     * @param author The author of the comment.
     * @param typeComment The content of the comment.
     * @param reply The list of replies to this comment.
     */
    public Comment(GregorianCalendar date, Media_File media_file_to_comment, String author, String typeComment, List<Comment> reply) {
        this.date = date;
        this.media_file_to_comment = media_file_to_comment;
        this.author = author;
        this.typeComment = typeComment;
        this.reply = reply;
    }

    /**
     * Writes or updates the content of the comment.
     *
     * @param content The new content to be set for the comment.
     */
    public void WriteComment(String content) {
        this.typeComment = content;
    }

    /**
     * Adds a reply to this comment.
     *
     * @param comment The reply to be added.
     */
    public void Reply(Comment comment) {
        this.reply.add(comment);

    }

    // Getters and Setters for attributes...
    // Getter and Setter for date
    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    // Getter and Setter for media_file_to_comment
    public Media_File getMedia_file_to_comment() {
        return media_file_to_comment;
    }

    public void setMedia_file_to_comment(Media_File media_file_to_comment) {
        this.media_file_to_comment = media_file_to_comment;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for visibility
    // Getter and Setter for typeComment
    public String getTypeComment() {
        return typeComment;
    }

    public void setTypeComment(String typeComment) {
        this.typeComment = typeComment;
    }

    // Getter and Setter for reply
    public List<Comment> getReply() {
        return reply;
    }

    public void setReply(List<Comment> reply) {
        this.reply = reply;
    }

}
