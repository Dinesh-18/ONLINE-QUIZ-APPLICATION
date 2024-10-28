import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            int userAnswer = getUserAnswer(scanner, options.size());
            if (question.isCorrect(userAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer was: " + options.get(question.getCorrectAnswerIndex()));
            }
        }

        System.out.println("Your final score is: " + score + "/" + questions.size());
    }

    private int getUserAnswer(Scanner scanner, int numberOfOptions) {
        int answer;
        do {
            System.out.print("Please enter your answer (1-" + numberOfOptions + "): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-" + numberOfOptions + "): ");
                scanner.next();
            }
            answer = scanner.nextInt();
        } while (answer < 1 || answer > numberOfOptions);
        return answer - 1; // Adjusting for zero-based index
    }
}
