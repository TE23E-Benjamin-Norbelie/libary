package net.benji.LibraryItems;

import net.benji.LibraryItem;

/**
 * Klass som extenderar LibraryItem, som är en superklass,
 * och därmed ärver dess egenskaper och metoder.
 * Denna klass kan användas för att representera magasin i bibliotekssystemet.
 */
public class Magazine extends LibraryItem {
    private int issueNumber;
    private String category;
    private int publicationYear;

    public Magazine(String title, String id, boolean isAvailable, int issueNumber, String category,
            int publicationYear) {
        super(title, id, isAvailable);
        this.issueNumber = issueNumber;
        this.category = category;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Titel: " + getTitle() + "\n" +
               "Nummer: " + issueNumber + "\n" +
               "Kategori: " + category + "\n" +
               "År: " + publicationYear + "\n" +
               "Tillgänglig: " + isAvailable() + "\n";
    }

}
