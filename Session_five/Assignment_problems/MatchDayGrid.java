import java.util.Scanner;

public class MatchDayGrid {
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) sum += value;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold)
                result.append("Match ").append(i).append(": Power Surge");
            else
                result.append("Match ").append(i).append(": Normal");

            if (i < runsPerOver.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = sc.nextInt();
        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {
            System.out.print("Enter number of overs for Match " + i + ": ");
            int overs = sc.nextInt();
            runsPerOver[i] = new int[overs];

            System.out.println("Enter runs for each over:");
            for (int j = 0; j < overs; j++) runsPerOver[i][j] = sc.nextInt();
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        System.out.println(classifyMatches(runsPerOver, threshold));
        sc.close();
    }
}
