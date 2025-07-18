package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private String rollNo;
    private int year;
    private int leetCodeSolved;
    private List<String> internships = new ArrayList<>();
    private List<String> projects = new ArrayList<>();
    private String mentor;

    
    public Student(String name, String rollNo, int year, int leetCodeSolved, int internshipsCount, int projectsCount, String mentor) {
        this.name = name;
        this.rollNo = rollNo;
        this.year = year;
        this.leetCodeSolved = leetCodeSolved;
        this.mentor = mentor;

        
        for (int i = 1; i <= internshipsCount; i++) {
            internships.add("Internship " + i);
        }

        
        for (int i = 1; i <= projectsCount; i++) {
            projects.add("Project " + i);
        }
    }

   
    public void displayInfo() {
        System.out.println("-------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Year: " + year);
        System.out.println("LeetCode Solved: " + leetCodeSolved);
        System.out.println("Internships: " + internships);
        System.out.println("Projects: " + projects);
        System.out.println("Mentor: " + (mentor != null ? mentor : "Not Assigned"));
        System.out.println("-------------------------------------------------");
    }

   
    public void addInternship(String internship) {
        internships.add(internship);
    }

    public void addProject(String project) {
        projects.add(project);
    }

    public void updateLeetCode(int newCount) {
        this.leetCodeSolved = newCount;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

   
    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }
}
