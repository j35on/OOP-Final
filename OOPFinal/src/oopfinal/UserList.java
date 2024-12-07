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
import java.util.Scanner;

public class UserList {
    private ArrayList<User> users;

    // Constructor
    public UserList() {
        this.users = new ArrayList<>();
    }

    // Register a new user
    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Role: ");
        String role = scanner.nextLine();

        // Create and add the new user
        User newUser = new User(userId, name, email, password, role);
        users.add(newUser);

        System.out.println("User registered successfully!");
    }

    // Login with email and password
    public User login(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                for(Task task: tasks){
                    for(int i = 0; i<task.getReminders().size(); i++){
                        if(task.getReminders().get(i).getUserId() == user.getUserId()){
                            task.getReminders().get(i).displayReminder();
                        }
                    }
                }
                return user;
            }
        }
        System.out.println("Invalid email or password.");
        return null;
    }

    // Reset password
    public void resetPassword() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.print("Enter new Password: ");
                String newPassword = scanner.nextLine();
                user.setPassword(newPassword);
                System.out.println("Password updated successfully.");
                return;
            }
        }

        System.out.println("Email not found.");
    }
}

