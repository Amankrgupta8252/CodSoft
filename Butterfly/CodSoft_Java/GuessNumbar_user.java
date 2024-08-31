/*
 * 6. Add the option for multiple rounds, allowing the user to play again.
 */
import java.util.*;

class GuessNumber_User {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 100;
        int maxAttempts = 5;  // Set the maximum number of attempts

        boolean playAgain = true;

        while (playAgain) {
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

            // Ask if the user wants to play again
            System.out.println("Would you like to play again? (yes/no)");
            String response = sc.next().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }

        sc.close();
    }
}
