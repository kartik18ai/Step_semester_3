import java.util.Scanner;

public class CourseCredit {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    // Four-argument constructor: sets all fields directly.
    public CourseCredit(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor: delegates to the four-argument constructor.
    public CourseCredit(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Course using four-argument constructor:");
        System.out.print("Course code: ");
        String code1 = sc.nextLine();

        System.out.print("Course title: ");
        String title1 = sc.nextLine();

        System.out.print("Credits: ");
        int credits1 = sc.nextInt();

        System.out.print("Lab credits: ");
        int labCredits1 = sc.nextInt();
        sc.nextLine();

        CourseCredit course1 =
                new CourseCredit(code1, title1, credits1, labCredits1);

        System.out.println("\nCourse using three-argument constructor:");
        System.out.print("Course code: ");
        String code2 = sc.nextLine();

        System.out.print("Course title: ");
        String title2 = sc.nextLine();

        System.out.print("Credits: ");
        int credits2 = sc.nextInt();

        CourseCredit course2 =
                new CourseCredit(code2, title2, credits2);

        System.out.println("\nOutput:");
        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());

        sc.close();
    }
}
