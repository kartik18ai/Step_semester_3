import java.util.Arrays;
import java.util.Scanner;

public class AutoDraft {
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        public String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {
        int count = 0;

        for (Player player : players) {
            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(player.matchesPlayed, player.injured)) count++;
        }

        Player[] draftable = new Player[count];
        int index = 0;

        for (Player player : players) {
            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(player.matchesPlayed, player.injured)) {
                draftable[index++] = player;
            }
        }

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Player " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Injured? (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(name, matchesPlayed, battingAverage, injured);
        }

        System.out.println("\nDraft Ranking:");
        System.out.println(draftAndRank(players));

        sc.close();
    }
}
