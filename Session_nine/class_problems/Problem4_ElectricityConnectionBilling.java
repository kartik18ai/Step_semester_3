import java.util.Scanner;

public class Problem4_ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        ElectricityConnection[] connections = new ElectricityConnection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            switch (type) {
                case "HOME":
                    connections[i] = new HomeConnection(units);
                    break;
                case "SHOP":
                    connections[i] = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connections[i] = new FactoryConnection(units);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown connection type: " + type);
            }

            double bill = connections[i].calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class ElectricityConnection {
    protected final int units;

    public ElectricityConnection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0 + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}
