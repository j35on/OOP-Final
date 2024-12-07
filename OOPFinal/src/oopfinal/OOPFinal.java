/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopfinal;
import java.util.*;
/**
 *
 * @author jmgia
 */
public class OOPFinal {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        UserList userList = new UserList();
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);
        int currentUserId = 0;
        User currentUser = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Reset Password");
            System.out.println("4. Create Task");
            System.out.println("5. Edit Task");
            System.out.println("6. Add Comment to Task");
            System.out.println("7. Add Reminder to Task");
            System.out.println("8. View Report");
            System.out.println("9. View Task");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
           
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    userList.register();
                    break;
                case 2:
                    currentUser = userList.login(taskList.getTasks());
                    currentUserId = currentUser != null ? currentUser.getUserId() : 0;
                    break;
                case 3:
                    userList.resetPassword();
                    System.out.println("For your safety you have been logged out!");
                    break;
                case 4:
                    if (currentUser == null) {
                        System.out.println("You need to log in first.");
                        break;
                    }
                    taskList.createTask();
                    System.out.println("For your safety you have been logged out!");
                    break;
                case 5:
                    if (currentUser == null) {
                        System.out.println("You need to log in first.");
                        break;
                    }
                    taskList.editTask();
                    System.out.println("For your safety you have been logged out!");
                    break;
                case 6:
                    if (currentUser == null) {
                        System.out.println("You need to log in first.");
                        break;
                    }
                    taskList.addComment();
                    System.out.println("For your safety you have been logged out!");
                    break;
                case 7:
                    if (currentUser == null) {
                        System.out.println("You need to log in first.");
                        break;
                    }
                    taskList.addReminder();
                    System.out.println("For your safety you have been logged out!");
                    break;
                case 8:
                    if (currentUser == null) {
                        System.out.println("You need to log in first.");
                        break;
                    }
                    Report report = new Report(1, currentUserId, new Date(System.currentTimeMillis() - 172800000), new Date(System.currentTimeMillis()));
                    report.viewReport(taskList.getTasks()); // Pass taskList tasks here
                    System.out.println("For your safety you have been logged out!");
                    break;
                case 9:
                    if(currentUser == null){
                        System.out.println("You need to log in first");
                        break;
                    }
                    System.out.println("Enter taskID to view: ");
                    int t = scanner.nextInt();
                    
                    taskList.findTaskById(t).displayTask();
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        }
    }
}