import java.util.Scanner;

public class Problem1_CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        CustomerBill[] bills = new CustomerBill[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "STUDENT":
                    bills[i] = new StudentBill(amount);
                    break;
                case "STAFF":
                    bills[i] = new StaffBill(amount);
                    break;
                case "GUEST":
                    bills[i] = new GuestBill(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown customer type: " + type);
            }

            double finalAmount = bills[i].calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class CustomerBill {
    protected final double amount;

    public CustomerBill(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class StudentBill extends CustomerBill {
    public StudentBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class StaffBill extends CustomerBill {
    public StaffBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestBill extends CustomerBill {
    public GuestBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10;
    }
}
