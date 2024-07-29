/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import utils.Logger;
import models.Classroom;
import models.Student;
import java.util.ArrayList;
import java.util.List;

public class ClassroomManager {
    private List<Classroom> classrooms = new ArrayList<>();

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
        Logger.getInstance().log("Classroom " + classroom.getName() + " has been created.");
    }

    public void addStudent(Classroom classroom, Student student) {
        classroom.addStudent(student);
        Logger.getInstance().log("Student " + student.getId() + " has been enrolled in " + classroom.getName() + ".");
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            Logger.getInstance().log("No classrooms available.");
        } else {
            for (Classroom classroom : classrooms) {
                Logger.getInstance().log("Classroom Name: " + classroom.getName());
            }
        }
    }

    public void removeClassroom(String className) {
        Classroom classroomToRemove = findClassroomByName(className);
        if (classroomToRemove != null) {
            classrooms.remove(classroomToRemove);
            Logger.getInstance().log("Classroom " + className + " has been removed.");
        } else {
            Logger.getInstance().log("Classroom " + className + " does not exist.");
        }
    }

    public void listStudents(Classroom classroom) {
        Logger.getInstance().log("Students in " + classroom.getName() + ":");
        if (classroom.getStudents().isEmpty()) {
            Logger.getInstance().log("No students enrolled.");
        } else {
            for (Student student : classroom.getStudents().values()) {
                Logger.getInstance().log("Student ID: " + student.getId());
            }
        }
    }

    public Classroom findClassroomByName(String className) {
        for (Classroom classroom : classrooms) {
            if (classroom.getName().equals(className)) {
                return classroom;
            }
        }
        return null;
    }
}
