public class Problem4_LockerCode {
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");

        System.out.println("Correct code change: " + locker.changeCode("1234", "5678"));
        System.out.println("Wrong code change: " + locker.changeCode("0000", "9999"));
        System.out.println("Locker number: " + locker.getLockerNumber());
    }
}

class Locker {
    private String combinationCode;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}
