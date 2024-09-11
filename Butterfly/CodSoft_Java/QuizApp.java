/*
 * Quiz Questions and Options: Store quiz questions along with multiple-choice options and correct answers.
 */

import java.util.*;

public class QuizApp {
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
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);


            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }
            
            System.out.print("Enter your answer (1-4): ");
            int userAnswerIndex = sc.nextInt() - 1;  
            
            if (options[i][userAnswerIndex].equals(correctAnswers[i])) {
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect! The correct answer is: " + correctAnswers[i] + "\n");
            }
        }
        
        sc.close();  
    }
}
