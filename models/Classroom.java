/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author USER
 */


import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private String name;
    private Map<String, Student> students;
    private Map<String, Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashMap<>();
        this.assignments = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(String studentId) {
        students.remove(studentId);
    }

    public void addAssignment(String details) {
        assignments.put(details, new Assignment(details));
    }

    public void submitAssignment(String studentId, String details) {
        Assignment assignment = assignments.get(details);
        if (assignment != null && students.containsKey(studentId)) {
            assignment.submit();
        }
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, Assignment> getAssignments() {
        return assignments;
    }
}