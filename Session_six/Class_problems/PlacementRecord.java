import java.util.Scanner;

public class PlacementRecord {
    private String studentName;
    private String company;
    private double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PlacementRecord[] records = new PlacementRecord[3];

        for (int i = 0; i < records.length; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Student name: ");
            String name = sc.nextLine();

            System.out.print("Company: ");
            String company = sc.nextLine();

            System.out.print("Package (LPA): ");
            double packageLpa = sc.nextDouble();
            sc.nextLine();

            records[i] = new PlacementRecord(name, company, packageLpa);
        }

        System.out.println("\nPlacement Records:");
        for (PlacementRecord record : records) {
            record.printRecord();
        }

        sc.close();
    }
}
