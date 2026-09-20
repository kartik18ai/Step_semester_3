import java.util.Scanner;

public class EmployeeCompanyInfo {
    private String employeeName;
    private double salary;
    private static String companyName = "BrightHorizon Technologies";
    private static int employeeCount = 0;

    public EmployeeCompanyInfo(String employeeName, double salary) {
        this.employeeName = employeeName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EmployeeCompanyInfo[] employees = new EmployeeCompanyInfo[3];

        for (int i = 0; i < employees.length; i++) {
            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Employee name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees[i] = new EmployeeCompanyInfo(name, salary);
        }

        System.out.println("\nCompany Information:");
        EmployeeCompanyInfo.printCompanyInfo();

        sc.close();
    }
}