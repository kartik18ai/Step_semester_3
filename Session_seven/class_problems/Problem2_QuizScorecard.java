public class Problem2_QuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final score: " + sc.getScore());
        System.out.println("Answers recorded: " + sc.getAnswersRecorded());

        sc.recordAnswer(true);
    }
}

class Scorecard {
    private final boolean[] results;
    private int answersRecorded;

    public Scorecard(int questionCount) {
        if (questionCount < 0) {
            throw new IllegalArgumentException("Question count cannot be negative.");
        }
        results = new boolean[questionCount];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answersRecorded >= results.length) {
            System.out.println("Answer rejected: all questions have been recorded.");
            return;
        }

        results[answersRecorded] = correct;
        answersRecorded++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public int getAnswersRecorded() {
        return answersRecorded;
    }
}
