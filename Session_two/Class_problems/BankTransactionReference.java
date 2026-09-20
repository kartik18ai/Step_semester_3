import java.util.Scanner;

public class BankTransactionReference {

    static String normalizeReference(String raw) {

        // Remove leading and trailing spaces
        String reference = raw.trim();

        // If length is less than 3, return as it is
        if (reference.length() < 3) {
            return reference;
        }

        // Convert only first 3 characters to uppercase
        String bankCode = reference.substring(0, 3).toUpperCase();

        // Keep remaining characters unchanged
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract parts
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        // Format date as dd/MM/yy
        String formattedDate = date.substring(0, 2) + "/" +
                               date.substring(2, 4) + "/" +
                               date.substring(4, 6);

        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(formattedDate)
              .append(" | SEQ: ")
              .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        System.out.println(validateAndFormat(normalized));

        sc.close();
    }
}