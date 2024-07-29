/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import factories.ClassroomFactory;
import factories.StudentFactory;
import managers.ClassroomManager;
import managers.StudentManager;
import managers.AssignmentManager;
import models.Classroom;
import models.Student;

import java.util.Scanner;

public class CommandProcessor {
    private final ClassroomManager classroomManager;
    private final StudentManager studentManager;
    private final AssignmentManager assignmentManager;
    private final Scanner scanner;

    public CommandProcessor() {
        this.classroomManager = new ClassroomManager();
        this.studentManager = new StudentManager();
        this.assignmentManager = new AssignmentManager();
        this.scanner = new Scanner(System.in);
    }

    public void processCommands() {
        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();

            try {
                if (command.startsWith("add_classroom")) {
                    String className = command.split(" ")[1];
                    Classroom classroom = ClassroomFactory.createClassroom(className);
                    classroomManager.addClassroom(classroom);
                } else if (command.startsWith("remove_classroom")) {
                    String className = command.split(" ")[1];
                    classroomManager.removeClassroom(className);
                } else if (command.startsWith("add_student")) {
                    String[] parts = command.split(" ");
                    String studentId = parts[1];
                    String className = parts[2];
                    Classroom classroom = classroomManager.findClassroomByName(className);
                    if (classroom != null) {
                        Student student = StudentFactory.createStudent(studentId);
                        studentManager.enrollStudent(classroom, student);
                    } else {
                        Logger.getInstance().log("Classroom " + className + " not found.");
                    }
                } else if (command.startsWith("schedule_assignment")) {
                    String[] parts = command.split(" ");
                    String className = parts[1];
                    String details = parts[2];
                    Classroom classroom = classroomManager.findClassroomByName(className);
                    if (classroom != null) {
                        assignmentManager.scheduleAssignment(classroom, details);
                    } else {
                        Logger.getInstance().log("Classroom " + className + " not found.");
                    }
                } else if (command.startsWith("submit_assignment")) {
                    String[] parts = command.split(" ");
                    String studentId = parts[1];
                    String className = parts[2];
                    String details = parts[3];
                    Classroom classroom = classroomManager.findClassroomByName(className);
                    if (classroom != null) {
                        assignmentManager.submitAssignment(classroom, studentId, details);
                    } else {
                        Logger.getInstance().log("Classroom " + className + " not found.");
                    }
                } else if (command.startsWith("list_students")) {
                    String className = command.split(" ")[1];
                    Classroom classroom = classroomManager.findClassroomByName(className);
                    if (classroom != null) {
                        studentManager.listStudents(classroom);
                    } else {
                        Logger.getInstance().log("Classroom " + className + " not found.");
                    }
                } else if (command.startsWith("list_classrooms")) {
                    classroomManager.listClassrooms();
                } else if (command.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    Logger.getInstance().log("Unknown command.");
                }
            } catch (Exception e) {
                ExceptionHandler.getInstance().handleException(e);
            }
        }
    }
}