/*
 * 2. Prompt the user to enter their guess for the generated number.

 */

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Range from 1 to 100 (inclusive)
        int min = 1;
        int max = 100;

        int randomNumber = random.nextInt((max - min) + 1) + min;

        System.out.println("A random number between " + min + " and " + max + " has been generated.");
        System.out.print("Enter your guess: ");

        int userGuess = sc.nextInt();

        if (userGuess == randomNumber) {
            System.out.println("Congratulations! You guessed the correct number.");
        } else {
            System.out.println("Sorry, the correct number was " + randomNumber + ". Better luck next time!");
        }

        sc.close();
    }
}
