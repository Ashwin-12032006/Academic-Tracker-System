package model;

import java.util.List;

public class HOD extends Staff {

    public HOD(String name, String staffID, String designation, String subjectExpertise, String origin, List<String> mentoredStudents) {
        super(name, staffID, designation, subjectExpertise, origin,mentoredStudents);
        for (String student : mentoredStudents) {
            addMentoredStudent(student);
        }
    }

    public void assignMentor(String studentName, Staff mentor) {
        mentor.addMentoredStudent(studentName);
        System.out.println("Mentor " + mentor.getName() + " assigned to " + studentName);
    }

    public void generateReport() {
        System.out.println("Report Generation Feature Coming Soon!");
    }
}
