package net.benji;
/* LibraryItem är parent klass som extenderar andra klasser som Book och Magazine.
 Den fungerar som en abstrakt basklass för olika typer av bibliotekselement. */
public abstract class LibraryItem {
    private String title;
    private String id;
    private boolean isAvailable;
    public LibraryItem(String title, String id, boolean isAvailable) {
        this.title = title;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    
}
