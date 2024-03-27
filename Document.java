package medias;
import main.*;
import  java.util.GregorianCalendar;
/**
 * Represents a document file, extending the Media_File class with text-based functionalities.
 * Includes capabilities to edit and search within the document content.
 * 
 */
public class Document extends Media_File {
    

    private String Content;
    /**
     * Constructs a new Document instance.
     * 
     * @param id         The unique identifier for the document.
     * @param name       The name of the document.
     * @param file_type  The type of the media file, typically indicating a document.
     * @param owner_id   The identifier of the owner of the document.
     * @param Content    The textual content of the document.
     * @param Date       The date when the document was created or uploaded.
     */
    public Document(int id, String name, File_type file_type, String owner_id,String Content,GregorianCalendar Date) {
        super(id,name,file_type,Date);
        this.Content = Content;
    }
    /**
     * Adds text to the existing content of the document.
     * 
     * @param ToAdd The string to be added to the document.
     */
    public void AddText(String ToAdd) {
        this.Content +=ToAdd;
    }
    /**
     * Searches for a specified word within the document content.
     * 
     * @param Word The word to search for in the document content.
     * @return     true if the word is found, false otherwise.
     */
    public boolean Search(String Word) {
          return this.Content.contains(Word);
    
    }
     /**
     * Replaces the entire content of the document with a new text.
     * 
     * @param ToReplace The new content to set for the document.
     */
    public void EditDocument(String ToReplace) {
        this.Content = ToReplace;
    }
    
    public String GetContent()
    {
        return this.Content;
    }
    
    
    public void SetContent(String Content) {
        this.Content = Content;
    }
}

