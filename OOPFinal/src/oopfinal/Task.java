package oopfinal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmgia
 */
import java.util.*;
public class Task {
    private int taskId; // Unique identifier for the task
    private String title;
    private String description;
    private String priority;
    private String status;
    private ArrayList<String> labels;
    private boolean isRecurring;
    private Date dueDate;
    private ArrayList<Comment> comments;
    private ArrayList<Reminder> reminders;
    private ArrayList<Photo> photos;

    // Constructor
    public Task(int taskId, String title, String description, String priority, String status, boolean isRecurring, Date dueDate) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.labels = new ArrayList<>();
        this.isRecurring = isRecurring;
        this.dueDate = dueDate != null ? dueDate : new Date();
        this.comments = new ArrayList<>();
        this.reminders = new ArrayList<>();
        this.photos = new ArrayList<>();
    }

    // Add a comment to the task
    public void addComment(int commentId, int userId, String content) {
        Comment comment = new Comment(commentId, this.taskId, userId, content);
        this.comments.add(comment);
        System.out.println("Comment added successfully.");
    }

    // Add a reminder to the task
    public void addReminder(int reminderId, Date reminderDate, int userId) {
    Reminder reminder = new Reminder(reminderId, this.taskId, userId, reminderDate);
    this.reminders.add(reminder);
    System.out.println("Reminder added successfully.");
    }
    public void addPhoto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter photoID");
        int id = scanner.nextInt(); 
        scanner.nextLine();
        System.out.println("Enter file name");
        String file = scanner.nextLine();
        System.out.println("Enter resolution");
        String rez = scanner.nextLine();
        Photo p = new Photo(id, file, rez);
        photos.add(p);
    }


    // Display all reminders for the task
    public void displayReminders() {
        if (reminders.isEmpty()) {
            System.out.println("No reminders set for this task.");
            return;
        }
        for (Reminder reminder : reminders) {
            reminder.displayReminder();
        }
    }
    
    public void displayTask(){
        System.out.println("Title: " + this.title + "\nDescription: " + this.description+"\nPriority: " + this.priority +"\nStatus: " + this.status + "\nComments: ");
        if(comments.size() >0){
        for(Comment comment: comments){
            System.out.println(comment.getContent());
        }
        }
        if(photos.size()>0){
        for(Photo photo: photos){
            photo.view();
        }
        }
    }

    // Getters and Setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }
    
    
}
