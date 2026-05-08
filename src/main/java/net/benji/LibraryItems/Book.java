package net.benji.LibraryItems;
import net.benji.LibraryItem;
/**
 * Klass som extenderar LibraryItem, som är en superklass, 
 * och därmed ärver dess egenskaper och metoder.
 *  Denna klass kan användas för att representera böcker i bibliotekssystemet.
 */
public class Book extends LibraryItem {
    private String author;
    private String genre;
    private int pages;

    public Book(String title, String id, boolean isAvailable, String author, String genre, int pages) {
        super(title, id, isAvailable);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    public String ToString() {
        return "Titel: " + getTitle() + ", Författare: " + author + ", Genre: " + genre + ", sidor: " + pages +
         ", Tillgänglig: " + isAvailable();
    }
}
