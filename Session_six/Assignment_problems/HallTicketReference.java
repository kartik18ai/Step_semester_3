import java.util.Scanner;

public class HallTicketReference {

    static class HallTicket {
        String studentName;
        int seatNumber;

        HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter seat number: ");
        int seat = sc.nextInt();

        HallTicket priya = new HallTicket(name, seat);

        // Second variable points to the same object.
        HallTicket copy = priya;

        System.out.print("Enter new seat number through second reference: ");
        copy.seatNumber = sc.nextInt();

        System.out.println("\n" + priya.studentName
                + "'s seat number (via first variable): "
                + priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket(name, priya.seatNumber);

        System.out.println("separate == priya: " + (separate == priya));

        sc.close();
    }
}