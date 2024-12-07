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

public class Comment extends Notation{
    /*private int commentId;
    private int taskId;
    private int userId;*/
    private String content;
    private Date timestamp;

    // Constructor
    public Comment(int commentId, int taskId, int userId, String content) {
        super(commentId, taskId, userId);
        this.content = content;
        this.timestamp = new Date(); // Automatically set to the current timestamp
    }

    // Getters and Setters
    

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

