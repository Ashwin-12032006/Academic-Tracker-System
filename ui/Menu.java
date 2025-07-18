package ui;

import model.Student;
import model.Staff;
import model.HOD;
import utils.ConsoleStyle;
import utils.FileManager;

import java.util.*;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static List<Student> students = FileManager.loadStudents();
    private static List<Staff> staffList = FileManager.loadStaff();

    public static void showWelcome() {
        while (true) {
            ConsoleStyle.printHeader("Welcome to Academic Department Tracker System (ADTS)");
            System.out.println("1. Admin");
            System.out.println("2. Staff");
            System.out.println("3. Student");
            System.out.println("4. HOD");
            System.out.println("5. Exit");
            System.out.print("Select Role: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: AdminMenu.show(students, staffList); break;
                case 2: showStaffMenu(); break;
                case 3: StudentMenu.show(students); break;
                case 4: showHODMenu(); break;
                case 5: System.exit(0);
                default: ConsoleStyle.printError("Invalid choice.");
            }
        }
    }

    private static void showStaffMenu() {
        sc.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = sc.nextLine();
        for (Staff s : staffList) {
            if (s.getName().equalsIgnoreCase(name)) {
                ConsoleStyle.printHeader("Welcome " + s.getName());
                s.displayInfo();
                return;
            }
        }
        ConsoleStyle.printError("Staff not found.");
    }

    private static void showHODMenu() {
        sc.nextLine();
        System.out.print("Enter HOD Name: ");
        String name = sc.nextLine();
        if (!name.equalsIgnoreCase("Dr.S.Prakash")) {
            ConsoleStyle.printError("Unauthorized HOD access.");
            return;
        }

        HOD hod = new HOD("Dr.S.Prakash", "HOD001", "Professor", "Software Engineering", "Tamil Nadu", new ArrayList<>());

        while (true) {
            ConsoleStyle.printHeader("Welcome HOD - Dr.S.Prakash");
            System.out.println("1. View All Students");
            System.out.println("2. Assign Student to Mentor");
            System.out.println("3. Generate Report (Stub)");
            System.out.println("4. Exit HOD Menu");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    for (Student stu : students) stu.displayInfo();
                    break;
                case 2:
                    System.out.print("Enter Student Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter Mentor Name: ");
                    String mName = sc.nextLine();
                    Staff mentor = staffList.stream().filter(s -> s.getName().equalsIgnoreCase(mName)).findFirst().orElse(null);
                    if (mentor != null) {
                        hod.assignMentor(sName, mentor);
                        FileManager.saveStaff(staffList);
                    } else {
                        ConsoleStyle.printError("Mentor not found.");
                    }
                    break;
                case 3:
                    hod.generateReport();
                    break;
                case 4:
                    return;
                default:
                    ConsoleStyle.printError("Invalid option.");
            }
        }
    }
}
