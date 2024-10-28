import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Sample questions
        quiz.addQuestion(new Question("What is the capital of France?", Arrays.asList("Berlin", "London", "Paris", "Madrid"), 2));
        quiz.addQuestion(new Question("Which language is used primarily for Android development?", Arrays.asList("Python", "Java", "Swift", "Kotlin"), 1));
        quiz.addQuestion(new Question("What is the largest planet in our Solar System?", Arrays.asList("Earth", "Jupiter", "Mars", "Venus"), 1));

        quiz.start();
    }
}
