import java.util.Scanner;

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Student[] students = new Student[n];
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown student type: " + type);
            }

            double fee = students[i].calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}

abstract class Student {
    private static final double BUS_FEE = 12000.0;
    protected final String name;

    public Student(String name) {
        this.name = name;
    }

    protected abstract double calculateTuition();

    protected boolean usesBus() {
        return false;
    }

    public final double calculateTotalFee() {
        return calculateTuition() + (usesBus() ? BUS_FEE : 0.0);
    }
}

class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    protected double calculateTuition() {
        return 40000.0;
    }

    @Override
    protected boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    protected double calculateTuition() {
        return 100000.0;
    }
}

class ScholarshipStudent extends Student {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    protected double calculateTuition() {
        return 20000.0;
    }

    @Override
    protected boolean usesBus() {
        return true;
    }
}
