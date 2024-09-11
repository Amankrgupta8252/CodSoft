import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApp_Time {
    public static void main(String[] args) {
        // Create questions, options, and answers in arrays
        String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?"
        };

        String[][] options = {
            {"Paris", "London", "Berlin", "Madrid"},
            {"Earth", "Mars", "Jupiter", "Venus"}
        };

        String[] correctAnswers = {"Paris", "Mars"};
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);  // Display question

            // Display options
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            // Start the timer for 5 seconds
            System.out.print("Enter your answer (1-4) within 5 seconds: ");
            Future<Integer> future = executor.submit(() -> scanner.nextInt());

            try {
                int userAnswerIndex = future.get(5, TimeUnit.SECONDS) - 1; // Wait up to 5 seconds for input
                if (options[i][userAnswerIndex].equals(correctAnswers[i])) {
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Incorrect! The correct answer is: " + correctAnswers[i] + "\n");
                }
            } catch (TimeoutException e) {
                System.out.println("\nTime's up! Moving to the next question.\n");
            } catch (Exception e) {
                System.out.println("Invalid input!\n");
            }
        }

        executor.shutdown();  // Shut down the executor
        scanner.close();  // Close the scanner
    }
}
