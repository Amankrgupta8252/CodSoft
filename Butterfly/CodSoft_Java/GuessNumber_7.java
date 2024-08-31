/*
 * 7. Display the user's score, which can be based on the number of attempts taken or rounds won.
 */

 import java.util.*;

 class GuessNumber_7 {
     public static void main(String[] args) {
         Random random = new Random();
         Scanner sc = new Scanner(System.in);
 
         int min = 1;
         int max = 6;
         int maxAttempts = 5;  // Set the maximum number of attempts
         int roundsWon = 0;    // Initialize rounds won
         boolean playAgain = true;
 
         while (playAgain) {
             int numberToGuess = random.nextInt(max - min + 1) + min;
             System.out.println("Guess a number between " + min + " and " + max);
 
             boolean guessedCorrectly = false;
 
             for (int i = 0; i < maxAttempts; i++) {
                 System.out.print("Enter your guess: ");
                 int guess = sc.nextInt();
 
                 if (guess < numberToGuess) {
                     System.out.println("Too low!");
                 } else if (guess > numberToGuess) {
                     System.out.println("Too high!");
                 } else {
                     System.out.println("Congratulations! You guessed it!");
                     roundsWon++;  // Increment the number of rounds won
                     guessedCorrectly = true;
                     break;  // Exit loop when guessed correctly
                 }
 
                 if (i == maxAttempts - 1) {
                     System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
                 }
             }
 
             // Display the score after each round
             System.out.println("Your score (rounds won): " + roundsWon);
 
             // Ask if the user wants to play again
             System.out.println("Would you like to play again? (yes/no)");
             String response = sc.next().toLowerCase();
 
             if (!response.equals("yes")) {
                 playAgain = false;
                 System.out.println("Thanks for playing!");
                 System.out.println("Your final score (rounds won): " + roundsWon);
             }
         }
 
         sc.close();
     }
 }
 