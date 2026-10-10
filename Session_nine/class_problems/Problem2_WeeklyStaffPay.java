import java.util.Scanner;

public class Problem2_WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        StaffMember[] staff = new StaffMember[n];
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];

            switch (type) {
                case "FULLTIME":
                    staff[i] = new FullTimeStaff(name, Double.parseDouble(parts[2]));
                    break;
                case "HOURLY":
                    staff[i] = new HourlyStaff(name, Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]));
                    break;
                case "INTERN":
                    staff[i] = new InternStaff(name, Double.parseDouble(parts[2]));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown staff type: " + type);
            }

            double pay = staff[i].calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}

abstract class StaffMember {
    protected final String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private final double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private final double hours;
    private final double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends StaffMember {
    private final double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}
