/*
 * Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user
 */
import java.util.Scanner;

public class GREADECALCULATOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to hold marks for 5 subjects
        int[] marks = new int[5];
        int totalMarks = 0;
        double average;
        
        // Input marks for 5 subjects
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i]; // Summing up the total marks
        }
        
        // Calculate average percentage
        average = totalMarks / 5.0;
        
        // Determine grade
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
