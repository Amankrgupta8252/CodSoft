/*
 * 1. Generate a random number within a specified range, such as 1 to 100.
 */

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        
        // Range from 1 to 100 (inclusive)
        int min = 1;
        int max = 100;
        
        int randomNumber = random.nextInt((max - min) + 1) + min;
        
        System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
    }
}
