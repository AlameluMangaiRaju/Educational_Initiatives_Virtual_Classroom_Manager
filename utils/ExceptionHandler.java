/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author USER
 */
public class ExceptionHandler {
    private static ExceptionHandler instance;

    private ExceptionHandler() {}

    public static ExceptionHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionHandler();
        }
        return instance;
    }

    public void handleException(Exception e) {
        Logger.getInstance().log("An error occurred: " + e.getMessage());
    }
}
