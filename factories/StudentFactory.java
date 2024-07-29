/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import models.Student;

public class StudentFactory {
    public static Student createStudent(String id) {
        return new Student(id);
    }
}
