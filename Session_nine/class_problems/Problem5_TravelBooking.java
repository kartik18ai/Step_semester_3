import java.util.Scanner;

public class Problem5_TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String mode = parts[0];
            double distance = Double.parseDouble(parts[1]);

            switch (mode) {
                case "BUS":
                    bookings[i] = new BusBooking(distance);
                    break;
                case "TRAIN":
                    bookings[i] = new TrainBooking(distance);
                    break;
                case "FLIGHT":
                    bookings[i] = new FlightBooking(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown travel mode: " + mode);
            }

            System.out.printf("%s: %.2f%n", mode, bookings[i].calculateTotal());
        }

        sc.close();
    }
}

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    protected final double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    protected abstract double calculateBaseFare();

    public final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2.0 * distanceKm;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + 4.0 * distanceKm;
    }
}
