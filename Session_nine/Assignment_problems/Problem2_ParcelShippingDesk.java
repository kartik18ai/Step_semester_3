import java.util.Scanner;

public class Problem2_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double declaredValue = Double.parseDouble(parts[2]);

            switch (type) {
                case "STANDARD":
                    parcels[i] = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcels[i] = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcels[i] = new FragileParcel(weight, declaredValue);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parcel type: " + type);
            }

            double charge = parcels[i].calculateCharge();
            double insurance = parcels[i].calculateInsurance();
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}

abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public double calculateInsurance() {
        return 0.0;
    }
}

interface Insurable {
    double calculateInsurance();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + 10.0 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + 15.0 * weightKg;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + 10.0 * weightKg + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}
