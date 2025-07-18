package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Staff implements Serializable {
    private String name;
    private String staffID;
    private String designation;
    private String subjectExpertise;
    private String origin;
    private List<String> mentoredStudents;

    public Staff(String name, String staffID, String designation, String subjectExpertise, String origin,String mentoredStudents) {
        this.name = name;
        this.staffID = staffID;
        this.designation = designation;
        this.subjectExpertise = subjectExpertise;
        this.origin = origin;
        this.mentoredStudents = new ArrayList<>();
    }



    public Staff(String name, String staffID, String designation, String subjectExpertise, String origin, List<String> mentoredStudents) {
        this.name = name;
        this.staffID = staffID;
        this.designation = designation;
        this.subjectExpertise = subjectExpertise;
        this.origin = origin;
        this.mentoredStudents = mentoredStudents != null ? mentoredStudents : new ArrayList<>();
    }

    public void displayInfo() {
        System.out.println("-------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("ID: " + staffID);
        System.out.println("Designation: " + designation);
        System.out.println("Expertise: " + subjectExpertise);
        System.out.println("Origin: " + origin);
        System.out.println("Mentored Students: " + (mentoredStudents.isEmpty() ? "None" : mentoredStudents));
        System.out.println("-------------------------------------------------");
    }

    public String getName() {
        return name;
    }

    public void addMentoredStudent(String studentName) {
        mentoredStudents.add(studentName);
    }

    public List<String> getMentoredStudents() {
        return mentoredStudents;
    }
}
