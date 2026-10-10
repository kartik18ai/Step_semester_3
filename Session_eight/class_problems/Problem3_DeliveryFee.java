import java.util.Scanner;

public class Problem3_DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Delivery[] deliveries = new Delivery[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            switch (type) {
                case "STANDARD":
                    deliveries[i] = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    deliveries[i] = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customsFee = Double.parseDouble(parts[3]);
                    deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown delivery type: " + type);
            }

            double fee = deliveries[i].calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Delivery {
    protected final double weight;
    protected final double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    private final double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}
