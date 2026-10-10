import java.util.Scanner;

public class Problem5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Appliance[] appliances = new Appliance[n];
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AirConditioner(hours);
                    break;
                case "TV":
                    appliances[i] = new Television(hours);
                    break;
                case "WASHER":
                    appliances[i] = new WashingMachine(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown appliance: " + type);
            }

            if (saverRequested && !(appliances[i] instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliances[i].calculateUnits();
            if (saverRequested) {
                units = ((SaverMode) appliances[i]).applySaverMode(units);
            }

            double cost = units * 8.0;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}

abstract class Appliance {
    protected final double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    protected abstract double getPowerWatts();

    public final double calculateUnits() {
        return getPowerWatts() * hours / 1000.0;
    }
}

interface SaverMode {
    double applySaverMode(double units);
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 1500.0;
    }

    @Override
    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 500.0;
    }

    @Override
    public double applySaverMode(double units) {
        return units * 0.75;
    }
}
