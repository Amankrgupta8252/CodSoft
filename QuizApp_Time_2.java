import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApp_Time_2 {
    public static void main(String[] args) {
        // Define questions, options, and correct answers
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
            System.out.println(questions[i]);  // Display the question

            // Display multiple-choice options
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            // Start a timer for 10 seconds
            System.out.print("Enter your answer (1-4) within 10 seconds: ");
            Future<Integer> future = executor.submit(() -> {
                return scanner.nextInt();
            });

            try {
                // Wait for user input or timeout
                int userAnswerIndex = future.get(10, TimeUnit.SECONDS) - 1; // Convert to zero-based index
                if (userAnswerIndex >= 0 && userAnswerIndex < options[i].length) {
                    if (options[i][userAnswerIndex].equals(correctAnswers[i])) {
                        System.out.println("Correct!\n");
                    } else {
                        System.out.println("Incorrect! The correct answer is: " + correctAnswers[i] + "\n");
                    }
                } else {
                    System.out.println("Invalid choice. Please select a valid option.\n");
                }
            } catch (TimeoutException e) {
                System.out.println("\nTime's up! Moving to the next question.\n");
            } catch (Exception e) {
                System.out.println("Invalid input! Moving to the next question.\n");
            }
        }

        executor.shutdown();  // Shut down the executor
        scanner.close();  // Close the scanner
    }
}
