import java.util.Scanner;

public class Problem1_MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Ticket[] tickets = new Ticket[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String seat = parts[0];
            int count = Integer.parseInt(parts[1]);

            switch (seat) {
                case "REGULAR":
                    tickets[i] = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    tickets[i] = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    tickets[i] = new ReclinerTicket(count);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown seat type: " + seat);
            }

            double amount = tickets[i].calculateTotal();
            total += amount;
            System.out.printf("%s: %.2f%n", seat, amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    protected final int count;

    public Ticket(int count) {
        this.count = count;
    }

    protected abstract double getPricePerTicket();

    public final double calculateTotal() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 400.0;
    }
}
