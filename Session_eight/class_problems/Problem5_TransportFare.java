import java.util.Scanner;

public class Problem5_TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Journey[] journeys = new Journey[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            switch (type) {
                case "BUS":
                    journeys[i] = new BusJourney(distance);
                    break;
                case "TRAIN":
                    journeys[i] = new TrainJourney(distance);
                    break;
                case "METRO":
                    double peakHourFactor = Double.parseDouble(parts[2]);
                    journeys[i] = new MetroJourney(distance, peakHourFactor);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown transport type: " + type);
            }

            double fare = journeys[i].calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Journey {
    protected final double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + 0.10 * distance);
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + 0.15 * distance;
    }
}

class MetroJourney extends Journey {
    private final double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}
