/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinal;

/**
 *
 * @author jmgia
 */
import java.util.ArrayList;
import java.util.Date;

public class Report {
    private int reportId;
    private int userId;
    private Date startDate;
    private Date endDate;

    // Constructor
    public Report(int reportId, int userId, Date startDate, Date endDate) {
        this.reportId = reportId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // View Report Function
    public void viewReport(ArrayList<Task> tasks) {
        // Mock logic for generating completed and pending task counts
        int completedTasks = 0;
        int pendingTasks = 0;
        
        // Assuming you have a list of tasks for the user (this can be passed to the report method)
        
        for (Task task : tasks) {
            Date dueDate = task.getDueDate();

            // Ensure dueDate is not null before calling any methods on it
            if (dueDate != null) {
                if (dueDate.before(new Date())) {  // Compare with current date
                    completedTasks++;
                } else {
                    pendingTasks++;
                }
            }
        }

        System.out.println("Report for User ID: " + userId);
        System.out.println("Period: " + startDate + " to " + endDate);
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Pending Tasks: " + pendingTasks);
    }
}

