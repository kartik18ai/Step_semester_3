import java.util.Scanner;

public class ISBN {

    static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String firstThree = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return firstThree + remaining;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(code.substring(0, 3));
        result.append("] YEAR: ");
        result.append(code.substring(3, 7));
        result.append(" | CATALOG: ");
        result.append(code.substring(7));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String raw = sc.nextLine();

        String code = normalizeCode(raw);
        System.out.println(validateAndFormat(code));

        sc.close();
    }
}
