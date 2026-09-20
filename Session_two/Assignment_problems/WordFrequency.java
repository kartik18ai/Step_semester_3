import java.util.*;

public class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {
        String cleanedText = feedback.toLowerCase()
                .replace(",", "")
                .replace(".", "");

        String[] words = cleanedText.split("\\s+");

        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "was", "and", "a", "is", "of", "in")
        );

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback paragraph: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}
