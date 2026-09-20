import java.util.Scanner;

public class LibraryInventory {

    static class BookInventory {
        String title;
        String author;
        int copiesAvailable;

        BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        void printInfo() {
            System.out.println(title + " by " + author + " - "
                    + copiesAvailable + " copies available");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookInventory[] books = new BookInventory[4];

        for (int i = 0; i < books.length; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Copies available: ");
            int copies = sc.nextInt();
            sc.nextLine();

            books[i] = new BookInventory(title, author, copies);
        }

        System.out.println("\nLibrary Inventory:");
        for (BookInventory book : books) {
            book.printInfo();
        }

        sc.close();
    }
}