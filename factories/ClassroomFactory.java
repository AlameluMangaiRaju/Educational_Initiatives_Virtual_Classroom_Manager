/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import models.Classroom;

public class ClassroomFactory {
    public static Classroom createClassroom(String name) {
        return new Classroom(name);
    }
}

