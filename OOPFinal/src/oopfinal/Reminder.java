/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinal;

/**
 *
 * @author jmgia
 */
import java.util.Date;

public class Reminder extends Notation{
    private int reminderId;
    private int taskId;
    private int userId;  // Added userId to associate with a user
    private Date reminderDate;

    // Constructor
    public Reminder(int reminderId, int taskId,int userId, Date reminderDate) {
        super(reminderId, taskId, userId);
        this.reminderDate = reminderDate;
    }

    // Getters and Setters
    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    /*public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }*/

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    // Method to display reminder
    public void displayReminder() {
        System.out.println("Reminder for Task ID: " + taskId + " - Date: " + reminderDate);
    }
}
