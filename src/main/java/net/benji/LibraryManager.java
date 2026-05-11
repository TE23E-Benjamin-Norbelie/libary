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

public class LibraryManager {
        //private ArrayList<LibraryItem> libraryItems; // Lista för alla biblioteksaker
        private ArrayList<Book> books; // Lista för böcker
        private ArrayList<Magazine> magazines; // Lista för magasin

        
        private Gson gson = new Gson(); // Skapa en instans av Gson för JSON-hantering

//serever url hantering
private String serverUrl;

        public LibraryManager(String serverUrl) {
                this.serverUrl = serverUrl; 
        }
        public void fetchBooks() {
            HttpResponse<String> response;
            try {
                response = Unirest.get(serverUrl + "/books").asString();
                String jsonBody = response.getBody();

                // Konvertera JSON-strängen till en lista av Book-objekt
                List<Book> fetchedBooks = gson.fromJson(jsonBody, new TypeToken<List<Book>>(){}.getType());
                books.addAll(fetchedBooks);
                

            } catch (UnirestException e) {
                IO.println("Något blev fel vid inläsning.");
            }
        }

        public void fetchMagazines() {
            HttpResponse<String> response;
            try {
                response = Unirest.get(serverUrl + "/magazines").asString();
                String jsonBody = response.getBody();

                // Konvertera JSON-strängen till en lista av Magazine-objekt
                List<Magazine> fetchedMagazines = gson.fromJson(jsonBody, new TypeToken<List<Magazine>>(){}.getType());

            } catch (UnirestException e) {
                IO.println("Något blev fel vid inläsning.");
            }
        }

        public void listLibraryItems() {
            
        }
        public void addLibraryItem(LibraryItem item) {
            
        }
        public void removeLibraryItem(LibraryItem item) {
            
        }

}
