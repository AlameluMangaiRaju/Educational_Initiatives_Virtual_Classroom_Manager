/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author USER
 */
public class Assignment {
    private String details;
    private boolean isSubmitted;

    public Assignment(String details) {
        this.details = details;
        this.isSubmitted = false;
    }

    public String getDetails() {
        return details;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void submit() {
        this.isSubmitted = true;
    }
}

   
