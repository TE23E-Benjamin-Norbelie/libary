package net.benji;

import java.util.ArrayList;

import com.google.gson.Gson;

public class LibraryManager {
        //private ArrayList<LibraryItem> libraryItems; // Lista för alla biblioteksaker
        private ArrayList<String> Book; // Lista för böcker
        private ArrayList<String> Magazine; // Lista för magasin

        
        private Gson gson = new Gson(); // Skapa en instans av Gson för JSON-hantering

//serever url hantering
private String serverUrl;

        public LibraryManager(String serverUrl) {
                this.serverUrl = serverUrl; 
        }
        public void fetchBooks() {

        }

        public void fetchMagazines() {
            
        }

        public void listLibraryItems() {
            
        }
        public void addLibraryItem(LibraryItem item) {
            
        }
        public void removeLibraryItem(LibraryItem item) {
            
        }

}
