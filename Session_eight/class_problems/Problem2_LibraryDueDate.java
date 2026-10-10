import java.time.LocalDate;
import java.util.Scanner;

public class Problem2_LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;
            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item type: " + type);
            }

            System.out.println(item.getTitle() + ": " + item.getDueDate(currentDate));
        }
        sc.close();
    }
}

abstract class LibraryItem {
    private final String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getLoanDays();

    public LocalDate getDueDate(LocalDate borrowedDate) {
        return borrowedDate.plusDays(getLoanDays());
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getLoanDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public int getLoanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getLoanDays() {
        return 3;
    }
}
