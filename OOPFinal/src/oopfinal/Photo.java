/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinal;

/**
 *
 * @author jmgia
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.io.File;

public class Photo extends Attachment {
    private String resolution;

    public Photo(int attachmentId, String fileName, String resolution) {
        super(attachmentId, fileName);
        this.resolution = resolution;
    }

    @Override
    public void view() {
        JFrame frame = new JFrame("Viewing Photo: " + getFileName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon(getFileName());  // Load image
        JLabel label = new JLabel(imageIcon);

        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}

