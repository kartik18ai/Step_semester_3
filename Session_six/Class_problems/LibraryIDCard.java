import java.util.Scanner;

public class LibraryIDCard {
    static class IdCard {
        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial books issued: ");
        int booksIssued = sc.nextInt();

        IdCard ravi = new IdCard(name, booksIssued);

        IdCard duplicate = ravi;

        System.out.print("Enter updated books issued through second reference: ");
        duplicate.booksIssued = sc.nextInt();

        IdCard separate = new IdCard(name, duplicate.booksIssued);

        System.out.println("\n" + ravi.name
                + "'s booksIssued (via first variable): "
                + ravi.booksIssued);

        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        sc.close();
    }
}
