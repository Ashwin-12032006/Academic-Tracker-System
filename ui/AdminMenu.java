package ui;

import model.Student;
import model.Staff;
import utils.ConsoleStyle;
import utils.FileManager;

import java.util.*;

public class AdminMenu {
    private static Scanner sc = new Scanner(System.in);

    public static void show(List<Student> students, List<Staff> staffList) {
        while (true) {
            ConsoleStyle.printHeader("Admin Panel");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Staff");
            System.out.println("4. View All Staff");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Roll No: ");
                    String roll = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    System.out.print("Leetcode Solved: ");
                    int leetCodeSolved = sc.nextInt();
                    System.out.print("Internships: ");
                    int internships = sc.nextInt();
                    System.out.print("Projects: ");
                    int projects = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Mentor: ");
                    String mentor = sc.nextLine();

                    Student stu = new Student(name, roll, year, leetCodeSolved, internships, projects, mentor);
                    students.add(stu);
                    FileManager.saveStudents(students);
                    ConsoleStyle.printSuccess("Student added.");
                    break;

                case 2:
                    for (Student s : students) {
                        s.displayInfo();
                    }
                    break;

                case 3:
                    System.out.print("Name: ");
                    String sname = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Expertise: ");
                    String exp = sc.nextLine();
                    System.out.print("Origin: ");
                    String origin = sc.nextLine();
                    System.out.print("Mentored Students: ");
                    String mentoredStudents = sc.nextLine();
                    



                    Staff stf = new Staff(sname, id, desig, exp, origin,mentoredStudents);
                    staffList.add(stf);
                    FileManager.saveStaff(staffList);
                    ConsoleStyle.printSuccess("Staff added.");
                    break;

                case 4:
                    for (Staff st : staffList) {
                        st.displayInfo();
                    }
                    break;

                case 5:
                    return;

                default:
                    ConsoleStyle.printError("Invalid choice.");
            }
        }
    }
}
