import java.util.Scanner;

public class StudentCollegeInfo {
    private String name;
    private double attendance;

    private static String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount = 0;

    public StudentCollegeInfo(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first student name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first student attendance: ");
        double attendance1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second student attendance: ");
        double attendance2 = sc.nextDouble();

        StudentCollegeInfo student1 =
                new StudentCollegeInfo(name1, attendance1);

        StudentCollegeInfo student2 =
                new StudentCollegeInfo(name2, attendance2);

        StudentCollegeInfo.printCollegeInfo();

        sc.close();
    }
}
