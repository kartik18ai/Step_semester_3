import java.util.Scanner;

public class Problem3_LibraryLateFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LibraryItem[] items = new LibraryItem[n];
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);

            switch (type) {
                case "BOOK":
                    items[i] = new BookItem(title, daysLate);
                    break;
                case "DVD":
                    items[i] = new DVDItem(title, daysLate);
                    break;
                case "MAGAZINE":
                    items[i] = new MagazineItem(title, daysLate);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item type: " + type);
            }

            double fine = items[i].calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}

abstract class LibraryItem {
    protected final String title;
    protected final int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate;
    }
}
