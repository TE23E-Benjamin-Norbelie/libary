package net.benji;

public class Main {
    void main() {

        LibraryManager libraryManager = new LibraryManager("http://localhost:3000");

        IO.println("""
                    ---Bibliotekssystemet---

                    1. Hämta alla böcker
                    2. Hämta alla magasin
                    3. Skriv ut alla hämtade böcker
                    4.lägg till en bok
                    5. lägg till ett magasin
                    6. avsluta programmet

                """);
        switch (IO.readln()) {
            case "1" -> libraryManager.fetchBooks();
            case "2" -> libraryManager.fetchMagazines();
            case "3" -> libraryManager.listLibraryItems();
            case "4" -> {}
            case "5" -> {}
            case "6" -> {}
            default -> IO.println("Något blev fel.");
        }
    }

}
