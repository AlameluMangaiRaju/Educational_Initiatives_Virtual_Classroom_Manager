/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import utils.Logger;
import models.Student;
import models.Classroom;

public class StudentManager {

    public void enrollStudent(Classroom classroom, Student student) {
        classroom.addStudent(student);
        Logger.getInstance().log("Student " + student.getId() + " has been enrolled in " + classroom.getName() + ".");
    }

    public void listStudents(Classroom classroom) {
        Logger.getInstance().log("Students in " + classroom.getName() + ":");
        for (Student student : classroom.getStudents().values()) {
            Logger.getInstance().log("Student ID: " + student.getId());
        }
    }
}