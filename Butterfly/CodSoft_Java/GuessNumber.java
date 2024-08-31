/*
 * 3. Compare the user's guess with the generated number and provide feedback on whether the guessis correct, too high, or too low.
 */

//import java.util.Random;
import java.util.*;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 100;
        int numberToGuess = random.nextInt(max - min + 1) + min;

        System.out.print("Enter your guess: ");
        int user = sc.nextInt();

        System.out.println("Generated number by Computer: " + numberToGuess);

        if (user == numberToGuess) {
            System.out.println("Congratulations! You guessed the correct number.");
        } else if (user > numberToGuess) {
            System.out.println("Your guess is too high.");
        } else {
            System.out.println("Your guess is too low.");
        }

        sc.close();
    }
}
