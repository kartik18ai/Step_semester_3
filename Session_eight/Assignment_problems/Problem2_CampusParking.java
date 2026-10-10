import java.util.Scanner;

public class Problem2_CampusParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        ParkingVehicle[] vehicles = new ParkingVehicle[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;
                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;
                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown vehicle type: " + type);
            }

            double charge = vehicles[i].calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class ParkingVehicle {
    protected final int hours;

    public ParkingVehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class Bike extends ParkingVehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends ParkingVehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours == 1 ? 30.0 : 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends ParkingVehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}
