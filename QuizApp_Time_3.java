import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApp_Time_3 {
    public static void main(String[] args) {

        String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?"
        };

        String[][] options = {
            {"Paris", "London", "Berlin", "Madrid"},
            {"Earth", "Mars", "Jupiter", "Venus"}
        };

        String[] correctAnswers = {"Paris", "Mars"};
        Scanner sc = new Scanner(System.in);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        int score = 0;  
        int totalQuestions = questions.length;
        int correctAnswersCount = 0;
        int incorrectAnswersCount = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);  

            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            System.out.print("Enter your answer (1-4) within 10 seconds: ");
            Future<Integer> future = executor.submit(() -> sc.nextInt());

            try {
                int userAnswerIndex = future.get(10, TimeUnit.SECONDS) - 1; 
                if (userAnswerIndex >= 0 && userAnswerIndex < options[i].length) {
                    if (options[i][userAnswerIndex].equals(correctAnswers[i])) {
                        System.out.println("Correct!\n");
                        score++;  
                        correctAnswersCount++;
                    } else {
                        System.out.println("Incorrect! The correct answer is: " + correctAnswers[i] + "\n");
                        incorrectAnswersCount++;
                    }
                } else {
                    System.out.println("Invalid choice. Please select a valid option.\n");
                    incorrectAnswersCount++;
                }
            } catch (TimeoutException e) {
                System.out.println("\nTime's up! Moving to the next question.\n");
                incorrectAnswersCount++;
            } catch (Exception e) {
                System.out.println("Invalid input! Moving to the next question.\n");
                incorrectAnswersCount++;
            }
        }

        System.out.println("Quiz Over!");
        System.out.println("Your final score is: " + score + "/" + totalQuestions);
        System.out.println("Correct Answers: " + correctAnswersCount);
        System.out.println("Incorrect Answers: " + incorrectAnswersCount);

        executor.shutdown();  
        sc.close();  
    }
}
