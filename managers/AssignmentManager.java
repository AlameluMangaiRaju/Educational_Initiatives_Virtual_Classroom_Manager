/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import utils.Logger;
import models.Classroom;

public class AssignmentManager {

    public void scheduleAssignment(Classroom classroom, String details) {
        classroom.addAssignment(details);
        Logger.getInstance().log("Assignment for " + classroom.getName() + " has been scheduled.");
    }

    public void submitAssignment(Classroom classroom, String studentId, String details) {
        classroom.submitAssignment(studentId, details);
        Logger.getInstance().log("Assignment submitted by Student " + studentId + " in " + classroom.getName() + ".");
    }
}
