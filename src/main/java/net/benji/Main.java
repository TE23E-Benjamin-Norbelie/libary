package net.benji;
// meny för biblotekssystem som kopplar till en lokal server på port 3000
//  som anropar metoder via libraryManager
public class Main {
    public static void main(String[] args) {

//skapar en bibliotekshanterare som är kopplad till en lokal server på port 3000.
        LibraryManager libraryManager = new LibraryManager("http://localhost:3000");
        while (true) {

            IO.println("""
                        ---Bibliotekssystemet---

                        1. Hämta alla böcker
                        2. Hämta alla magasin
                        3. Skriv ut alla hämtade böcker
                        4. lägg till en bok
                        5. lägg till ett magasin
                        6. avsluta programmet

                    """);
            switch (IO.readln()) {
                case "1" -> libraryManager.fetchBooks();
                case "2" -> libraryManager.fetchMagazines();
                case "3" -> libraryManager.listLibraryItems();
                case "4" -> libraryManager.addBook();
                case "5" -> libraryManager.addMagazine();
                case "6" ->  System.exit(0); // alternativ 6 i menyn - stäng av
                default -> IO.println("Något blev fel.");
            }
        }
    }

}
