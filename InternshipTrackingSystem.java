import java.util.Scanner;

// Internship Class
class Internship {
    private String studentName;
    private String studentId;
    private String companyName;
    private int durationWeeks;
    private double progress;
    private boolean isCompleted;

    // Constructor
    public Internship(String studentName, String studentId, String companyName, int durationWeeks) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.companyName = companyName;
        this.durationWeeks = durationWeeks;
        this.progress = 0.0;
        this.isCompleted = false;
    }

    // Update progress
    public void updateProgress(double progress) {
        if (progress >= 0 && progress <= 100) {
            this.progress = progress;
            this.isCompleted = (progress == 100);
            System.out.println("Progress updated successfully!");
        } else {
            System.out.println("Invalid input! Enter value between 0 and 100.");
        }
    }

    // Display report
    public void displayReport() {
        System.out.println("\n===== Internship Report =====");
        System.out.println("Student Name   : " + studentName);
        System.out.println("Student ID     : " + studentId);
        System.out.println("Company Name   : " + companyName);
        System.out.println("Duration       : " + durationWeeks + " weeks");
        System.out.println("Progress       : " + progress + "%");
        System.out.println("Status         : " + (isCompleted ? "Completed" : "In Progress"));
        System.out.println("==============================\n");
    }

    // Check completion
    public void checkCompletion() {
        if (isCompleted) {
            System.out.println("Internship successfully completed!");
        } else {
            System.out.println("Internship is still ongoing.");
        }
    }
}

// Main Class
public class InternshipTrackingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Internship Tracking System =====");

        // Input details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student ID (USN): ");
        String id = sc.nextLine();

        System.out.print("Enter Company Name: ");
        String company = sc.nextLine();

        System.out.print("Enter Internship Duration (in weeks): ");
        int duration = sc.nextInt();

        // Create object
        Internship internship = new Internship(name, id, company, duration);

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Update Progress");
            System.out.println("2. View Internship Report");
            System.out.println("3. Check Completion Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter progress (0–100): ");
                    double progress = sc.nextDouble();
                    internship.updateProgress(progress);
                    break;

                case 2:
                    internship.displayReport();
                    break;

                case 3:
                    internship.checkCompletion();
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}