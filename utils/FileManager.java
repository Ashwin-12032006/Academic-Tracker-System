package utils;

import model.Student;
import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String STUDENT_FILE = "students.ser";
    private static final String STAFF_FILE = "staff.ser";

    @SuppressWarnings("unchecked")
    public static List<Student> loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENT_FILE))) {
            return (List<Student>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            ConsoleStyle.printError("Failed to save student data.");
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Staff> loadStaff() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STAFF_FILE))) {
            return (List<Staff>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveStaff(List<Staff> staffList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STAFF_FILE))) {
            oos.writeObject(staffList);
        } catch (IOException e) {
            ConsoleStyle.printError("Failed to save staff data.");
        }
    }
}
