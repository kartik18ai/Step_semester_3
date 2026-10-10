import java.util.Scanner;

public class Problem4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Cab[] cabs = new Cab[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            switch (type) {
                case "MINI":
                    cabs[i] = new MiniCab(km);
                    break;
                case "SEDAN":
                    cabs[i] = new SedanCab(km);
                    break;
                case "SUV":
                    cabs[i] = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cab type: " + type);
            }

            if (time.equals("NIGHT") && !(cabs[i] instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cabs[i].calculateFare();
            if (time.equals("NIGHT")) {
                fare = ((NightService) cabs[i]).applyNightFare(fare);
            }

            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Cab {
    protected final double km;

    public Cab(double km) {
        this.km = km;
    }

    protected abstract double getRatePerKm();

    public final double calculateFare() {
        return Math.max(100.0, km * getRatePerKm());
    }
}

interface NightService {
    double applyNightFare(double fare);
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    protected double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    protected double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double km) {
        super(km);
    }

    @Override
    protected double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}
