import java.util.Scanner;

public class Stock {

    static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - lowestPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("Maximum Profit: " + maxProfit(prices));

        sc.close();
    }
}
