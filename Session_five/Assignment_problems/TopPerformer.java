import java.util.Scanner;

public class TopPerformer {
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0], max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) min = scores[i];
            if (scores[i] > max) max = scores[i];
        }

        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();
        int[] scores = new int[n];

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();

        System.out.println(findMinMaxSpread(scores));
        sc.close();
    }
}
