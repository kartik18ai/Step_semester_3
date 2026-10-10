import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4_QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<ExamQuestion> questions = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            List<String> tokens = parseQuotedTokens(line);
            String type = tokens.get(0);
            String questionText = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            ExamQuestion question;
            switch (type) {
                case "MCQ":
                    question = new MCQQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "TF":
                    question = new TrueFalseQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "ESSAY":
                    question = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown question type: " + type);
            }

            questions.add(question);
            double score = question.grade();
            total += score;
            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }

    private static List<String> parseQuotedTokens(String line) {
        List<String> tokens = new ArrayList<>();
        int i = 0;

        while (i < line.length()) {
            while (i < line.length() && Character.isWhitespace(line.charAt(i))) {
                i++;
            }
            if (i >= line.length()) {
                break;
            }

            if (line.charAt(i) == '"') {
                int end = line.indexOf('"', i + 1);
                if (end == -1) {
                    throw new IllegalArgumentException("Unclosed quoted text.");
                }
                tokens.add(line.substring(i + 1, end));
                i = end + 1;
            } else {
                int end = i;
                while (end < line.length() && !Character.isWhitespace(line.charAt(end))) {
                    end++;
                }
                tokens.add(line.substring(i, end));
                i = end;
            }
        }

        return tokens;
    }
}

abstract class ExamQuestion {
    protected final String questionText;
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final double points;

    public ExamQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();
}

class MCQQuestion extends ExamQuestion {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends ExamQuestion {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        String answer = studentAnswer.toLowerCase();
        int matches = 0;

        for (String keyword : correctAnswer.split(",")) {
            String cleaned = keyword.trim().toLowerCase();
            if (!cleaned.isEmpty() && answer.contains(cleaned)) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }
        return 0;
    }
}
