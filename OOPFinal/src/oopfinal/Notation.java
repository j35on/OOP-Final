/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinal;

/**
 *
 * @author jmgia
 */
public abstract class Notation {
    private int notationID;
    private int taskId;
    private int userId;
    
    public Notation(int notationID, int taskId, int userId) {
        this.notationID = notationID;
        this.taskId = taskId;
        this.userId = userId;
    }
    
     // Getters and Setters
    public int getNotationID() {
        return notationID;
    }

    public void setNotationID(int notationID) {
        this.notationID = notationID;
    }

    public int getTaskId() {
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
    }
}
