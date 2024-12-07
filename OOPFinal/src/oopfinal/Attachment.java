/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinal;

/**
 *
 * @author jmgia
 */
public abstract class Attachment {
    private int attachmentId;
    private String fileName;

    public Attachment(int attachmentId, String fileName) {
        this.attachmentId = attachmentId;
        this.fileName = fileName;
    }

    public int getAttachmentId() {
        return attachmentId;
    }

    public String getFileName() {
        return fileName;
    }

    public abstract void view();
}
