/*
 * 4. Repeat steps 2 and 3 until the user guesses the correct number.
 */

import java.util.Random;
import java.util.Scanner;

public class GuessNumber_4 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 100;

        int numberToGuess = random.nextInt(max - min + 1) + min;
        int userGuess = 0;
        int numberOfTries = 0;

        System.out.println("A random number between " + min + " and " + max + " has been generated.");

        // Loop until the user guesses the correct number
        while (userGuess != numberToGuess) {
            System.out.print("Guess from user: ");
            userGuess = sc.nextInt();
            numberOfTries++;

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the correct number.");
                System.out.println("It took you " + numberOfTries + " tries.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Your guess is too low. Try again.");
            }
        }

        sc.close();
    }
}
