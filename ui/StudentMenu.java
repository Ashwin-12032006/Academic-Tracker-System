package ui;

import model.Student;
import utils.ConsoleStyle;
import utils.FileManager;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private static Scanner sc = new Scanner(System.in);

    public static void show(List<Student> students) {
        System.out.print("Enter your Roll Number: ");
        String roll = sc.nextLine();
        Student loggedIn = null;

        for (Student s : students) {
            if (s.getRollNo().equalsIgnoreCase(roll)) {
                loggedIn = s;
                break;
            }
        }

        if (loggedIn == null) {
            ConsoleStyle.printError("Student not found.");
            return;
        }

        while (true) {
            ConsoleStyle.printHeader("Student Panel");
            System.out.println("1. View Profile");
            System.out.println("2. Add Internship");
            System.out.println("3. Add Project");
            System.out.println("4. Update LeetCode Progress");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    loggedIn.displayInfo();
                    break;
                case 2:
                    System.out.print("Enter Internship details: ");
                    String intern = sc.nextLine();
                    loggedIn.addInternship(intern);
                    FileManager.saveStudents(students);
                    ConsoleStyle.printSuccess("Internship added.");
                    break;
                case 3:
                    System.out.print("Enter Project Title and Description: ");
                    String proj = sc.nextLine();
                    loggedIn.addProject(proj);
                    FileManager.saveStudents(students);
                    ConsoleStyle.printSuccess("Project added.");
                    break;
                case 4:
                    System.out.print("Enter new LeetCode problem count: ");
                    int lc = sc.nextInt();
                    sc.nextLine();
                    loggedIn.updateLeetCode(lc);
                    FileManager.saveStudents(students);
                    ConsoleStyle.printSuccess("Progress updated.");
                    break;
                case 5:
                    return;
                default:
                    ConsoleStyle.printError("Invalid choice.");
            }
        }
    }
}
