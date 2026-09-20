import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {

        // Check length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check whether all characters are digits
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get last 4 digits
        String lastFour = phone.substring(6);

        // Create masked number
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append(lastFour);

        // Insert '-' between mask and last four digits
        masked.insert(6, "-");

        return masked.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));

        sc.close();
    }
}