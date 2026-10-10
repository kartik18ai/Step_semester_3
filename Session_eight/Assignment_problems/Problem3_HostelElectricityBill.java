import java.util.Scanner;

public class Problem3_HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        RoomBill[] rooms = new RoomBill[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = Integer.parseInt(parts[2]);
                    rooms[i] = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    rooms[i] = new ACRoom(units);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown room type: " + type);
            }

            double bill = rooms[i].calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class RoomBill {
    protected final int units;

    public RoomBill(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends RoomBill {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends RoomBill {
    private final int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return units * 6.0 / occupants;
    }
}

class ACRoom extends RoomBill {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 10.0 + 200.0;
    }
}
