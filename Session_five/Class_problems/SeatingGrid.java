import java.util.Scanner;

public class SeatingGrid {
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);

            if (average < threshold) {
                result.append("Row ").append(i).append(": Quiet Zone");
            } else {
                result.append("Row ").append(i).append(": Buzzing Zone");
            }

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of scores in row " + i + ": ");
            int columns = sc.nextInt();

            seatingScores[i] = new int[columns];

            System.out.println("Enter scores for row " + i + ":");
            for (int j = 0; j < columns; j++) {
                seatingScores[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        System.out.println(classifyRows(seatingScores, threshold));
        sc.close();
    }
}
