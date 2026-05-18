package net.benji;

import java.util.ArrayList;
import java.util.List;

import net.benji.LibraryItems.Book;
import net.benji.LibraryItems.Magazine;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

// LibraryManager hanterar ett bibliotekssystem som lagrar och organiserar böcker och magasin.
// Klassen kan hämta data från en server via API-anrop, lista bibliotekets innehåll samt låta
// användaren lägga till nya böcker och magasin lokalt i programmet.

public class LibraryManager {
    // private ArrayList<LibraryItem> libraryItems; // Lista för alla biblioteksaker
    private ArrayList<Book> books; // Lista för böcker
    private ArrayList<Magazine> magazines; // Lista för magasin

    private Gson gson = new Gson(); // Skapa en instans av Gson för JSON-hantering

    // serever url hantering
    private String serverUrl;

    public LibraryManager(String serverUrl) {
        this.serverUrl = serverUrl;
        this.books = new ArrayList<>();// Initiera listan för böcker
        this.magazines = new ArrayList<>();// Initiera listan för magasin
    }

// Alternativ 1 i menyn

    public void fetchBooks() {
        HttpResponse<String> response;
        try {
            response = Unirest.get(serverUrl + "/books").asString(); //fråga till servern
            String jsonBody = response.getBody();


            // Konvertera JSON-strängen till en lista av Book-objekt
            List<Book> fetchedBooks = gson.fromJson(jsonBody, new TypeToken<List<Book>>() {
            }.getType());
            books.addAll(fetchedBooks);
            IO.println("Hämtat information om Böcker");

        } catch (UnirestException e) {
            IO.println("Något blev fel vid inläsning.");
        }   
    }

    // Alternativ 2 i menyn (typ som 1)

    public void fetchMagazines() {
        HttpResponse<String> response;
        try {
            response = Unirest.get(serverUrl + "/magazines").asString();
            String jsonBody = response.getBody();

            // Konvertera JSON-strängen till en lista av Magazine-objekt
            List<Magazine> fetchedMagazines = gson.fromJson(jsonBody, new TypeToken<List<Magazine>>() {
            }.getType());
            magazines.addAll(fetchedMagazines);
            IO.println("Hämtat information om Magazinen");

        } catch (UnirestException e) {
            IO.println("Något blev fel vid inläsning.");
        }
    }

    // Alternativ 3 i menyn

    public void listLibraryItems() {
        IO.println("Bibliotekobjekt:");
        for (Book book : books) {
            IO.println(book.toString());
        }
        for (Magazine magazine : magazines) {
            IO.println(magazine.toString());
        }

    }

    // Alternativ 4 i menyn

    public void addBook() {
        IO.println("Lägger till en bok.");

        IO.println("Ange titel:");
        String newBookTitle = IO.readln();

        IO.println("Ange författare:");
        String newBookAuthor = IO.readln();

        IO.println("Ange genre:");
        String newBookGenre = IO.readln();

        IO.println("Ange antal sidor:");
        int newBookPages = Integer.parseInt(IO.readln());

        String newBookId = String.valueOf(books.size() + 1);

        Book newBook = new Book(
                newBookId,
                newBookTitle,
                true,
                newBookAuthor,
                newBookGenre,
                newBookPages);
        books.add(newBook);
        IO.println("Bok tillagd.");
    }

    // Alternativ 5 i menyn

    public void addMagazine() {
        IO.println("Lägger till ett magazine.");

        IO.println("Ange titeln:");
        String newMagazineTitle = IO.readln();

        IO.println("Ange utgåva: ");
        int newIssuenumber = Integer.parseInt(IO.readln());

        IO.println("Ange kategori: ");
        String newCategory = IO.readln();

        IO.println("Ange publiceirings år: ");
        int newPublicationYear = Integer.parseInt(IO.readln());

        String newMagazineId = String.valueOf(magazines.size() + 1);

        Magazine newMagazine = new Magazine(
                newMagazineTitle,
                newMagazineId,
                true,
                newIssuenumber,
                newCategory,
                newMagazineId,
                newPublicationYear);
        magazines.add(newMagazine);
        IO.println("Magazine tillagd.");

    }

}
