public class Problem5_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}

class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maximumClassSize) {
        if (maximumClassSize < 0) {
            throw new IllegalArgumentException("Maximum class size cannot be negative.");
        }
        presentStudents = new String[maximumClassSize];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid student name.");
            return;
        }

        if (isPresent(name)) {
            return;
        }

        if (presentCount >= presentStudents.length) {
            System.out.println("Cannot mark present: attendance sheet is full.");
            return;
        }

        presentStudents[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}
