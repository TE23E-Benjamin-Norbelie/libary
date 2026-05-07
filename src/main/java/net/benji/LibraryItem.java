package net.benji;
/* LibraryItem är parent klass som extenderar andra klasser som Book och Magazine.
 Den fungerar som en abstrakt basklass för olika typer av bibliotekselement. */
public abstract class LibraryItem {
    private String title;
    private String id;
    private boolean isAvailable;

    //constructor för att skapa en instans av LibraryItem
    public LibraryItem(String title, String id, boolean isAvailable) {
        this.title = title;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    //Getters och setters för att komma åt och ändra hos LibraryItem.
public String getTitle() {
        return title;
    }
    public String getId() {
        return id;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
