/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinal;

/**
 *
 * @author jmgia
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TaskList {
    private ArrayList<Task> tasks;
    int taskID =0;

    // Constructor
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    // Create a new task
    public void createTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task priority (Low/Medium/High): ");
        String priority = scanner.nextLine();

        System.out.print("Enter task status (Pending/In Progress/Completed): ");
        String status = scanner.nextLine();

        System.out.print("Is the task recurring? (true/false): ");
        boolean isRecurring = scanner.nextBoolean();

        scanner.nextLine(); // Consume leftover newline

        System.out.print("Enter due date (yyyy-mm-dd): ");
        String dueDateInput = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            // Parse the string into a Date object
            date = formatter.parse(dueDateInput);
            
        } catch (ParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
        }

        Task newTask = new Task(taskID++, title, description, priority, status, isRecurring, date);
        tasks.add(newTask);

        System.out.println("Task created successfully with ID of " + (taskID-1)+".");
    }
    
    public Task findTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    // Edit an existing task
    public void editTask() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the index of the task to edit: ");
    int index = scanner.nextInt();
    scanner.nextLine(); // Consume leftover newline

    if (index < 0 || index >= tasks.size()) {
        System.out.println("Invalid task index.");
        return;
    }

    Task task = tasks.get(index);

    while (true) {
        System.out.println("\nEditing Task: " + task.getTitle());
        System.out.println("Select a field to edit:");
        System.out.println("1. Title");
        System.out.println("2. Description");
        System.out.println("3. Priority");
        System.out.println("4. Status");
        System.out.println("5. Is Recurring");
        System.out.println("6. Due Date");
        System.out.println("7. Add Photo");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        switch (choice) {
            case 1:
                System.out.print("Enter new title (current: " + task.getTitle() + "): ");
                task.setTitle(scanner.nextLine());
                System.out.println("Title updated.");
                break;
            case 2:
                System.out.print("Enter new description (current: " + task.getDescription() + "): ");
                task.setDescription(scanner.nextLine());
                System.out.println("Description updated.");
                break;
            case 3:
                System.out.print("Enter new priority (current: " + task.getPriority() + "): ");
                task.setPriority(scanner.nextLine());
                System.out.println("Priority updated.");
                break;
            case 4:
                System.out.print("Enter new status (current: " + task.getStatus() + "): ");
                task.setStatus(scanner.nextLine());
                System.out.println("Status updated.");
                break;
            case 5:
                System.out.print("Is the task recurring? (current: " + task.isRecurring() + ") (true/false): ");
                task.setRecurring(scanner.nextBoolean());
                scanner.nextLine(); // Consume leftover newline
                System.out.println("Recurring status updated.");
                break;
            case 6:
                System.out.print("Enter new due date (current: " + task.getDueDate() + ") (yyyy-mm-dd): ");
                String dueDateInput = scanner.nextLine();
                try {
                    task.setDueDate(new Date(dueDateInput));
                    System.out.println("Due date updated.");
                } catch (Exception e) {
                    System.out.println("Invalid date format. Keeping current due date.");
                }
                break;
            case 7:
                task.addPhoto();
            case 8:
                System.out.println("Exiting edit mode.");
                return; // Exit the edit function
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
    public void addComment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Task ID to add comment:");
        int taskId = scanner.nextInt();
        System.out.println("Enter userID");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Task task = findTaskById(taskId);
        if (task != null) {
            System.out.println("Enter your comment:");
            String content = scanner.nextLine();
            task.addComment(task.getComments().size() + 1, userId, content);
        } else {
            System.out.println("Task not found.");
        }
    }
    
    public void addReminder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Task ID to add reminder:");
        int taskId = scanner.nextInt();
        System.out.println("Enter User ID to add: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Task task = findTaskById(taskId);
        if (task != null) {
            System.out.println("Enter reminder date (YYYY-MM-DD):");
            String reminderDateInput = scanner.nextLine();
            Date reminderDate = new Date(); 
            task.addReminder(task.getReminders().size() + 1, reminderDate, userId);
            System.out.println("Reminder added successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }


    // Delete a task
    public void deleteTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the task to delete: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index.");
            return;
        }

        tasks.remove(index);
        System.out.println("Task deleted successfully.");
    }

    // Mark a task as complete
    public void markAsComplete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the task to mark as complete: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index.");
            return;
        }

        Task task = tasks.get(index);
        task.setStatus("Completed");
        System.out.println("Task marked as complete.");
    }

    // Display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("Task " + i + ":");
            System.out.println("  Title: " + task.getTitle());
            System.out.println("  Description: " + task.getDescription());
            System.out.println("  Priority: " + task.getPriority());
            System.out.println("  Status: " + task.getStatus());
            System.out.println("  Recurring: " + task.isRecurring());
            System.out.println("  Due Date: " + task.getDueDate());
            System.out.println();
        }
    }
    
    public ArrayList<Task> getTasks(){
        return tasks;
    }
}

