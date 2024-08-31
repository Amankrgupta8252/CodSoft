import java.util.Random;
import java.util.Scanner;

public class GuessNumber_5 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 100;
        int maxAttempts = 5;  // Set the maximum number of attempts

        int numberToGuess = random.nextInt(max - min + 1) + min;

        System.out.println("Guess a number between " + min + " and " + max);

        for (int i = 0; i < maxAttempts; i++) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed it!");
                break;  // Exit loop when guessed correctly
            }

            if (i == maxAttempts - 1) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }
        }

        sc.close();
    }
}
