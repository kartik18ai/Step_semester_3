import java.util.Scanner;

public class EmployeeProfile {
    private String empId;
    private String empName;
    private double salary;
    private boolean intern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.intern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0);
        this.intern = true;
    }

    public boolean isIntern() {
        return intern;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + intern);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Permanent Employee");
        System.out.print("Employee ID: ");
        String permanentId = sc.nextLine();

        System.out.print("Employee Name: ");
        String permanentName = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.println("\nIntern");
        System.out.print("Employee ID: ");
        String internId = sc.nextLine();

        System.out.print("Employee Name: ");
        String internName = sc.nextLine();

        EmployeeProfile permanent = new EmployeeProfile(
                permanentId, permanentName, salary);

        EmployeeProfile internEmployee = new EmployeeProfile(
                internId, internName);

        System.out.println("\nEmployee Profiles:");
        permanent.printProfile();
        internEmployee.printProfile();

        sc.close();
    }
}