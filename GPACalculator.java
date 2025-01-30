import java.util.Scanner;

public class GPACalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        double totalQualityPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter grade for course " + (i + 1) + " (A, B, C, D, F): ");
            String grade = scanner.nextLine().toUpperCase();
            System.out.print("Enter credit hours for course " + (i + 1) + ": ");
            int credits = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            double gradePoint = getGradePoint(grade);
            totalQualityPoints += gradePoint * credits;
            totalCredits += credits;
        }

        double gpa = totalQualityPoints / totalCredits;
        System.out.printf("Your GPA is: %.2f%n", gpa);
    }

    private static double getGradePoint(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }
}