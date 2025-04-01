package jdbcPractice;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chatClient {
    private static JTextArea chatArea;
    private static Socket socket;
    private static BufferedReader reader;
    private static PrintWriter writer;

    public static void main(String[] args) {
        // Create the frame for the chat client window
        JFrame frame = new JFrame("Chat Client");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the text area to display messages
        chatArea = new JTextArea();
        chatArea.setEditable(false);  // Messages cannot be typed here, only displayed
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Create the input field for typing messages
        JTextField inputField = new JTextField();
        frame.add(inputField, BorderLayout.SOUTH);

        // Set up an action listener for the input field
        inputField.addActionListener(e -> {
            String message = inputField.getText();  // Get the message typed by the user
            writer.println("Client: " + message);  // Send the message to the server
            chatArea.append("Client: " + message + "\n");  // Display the message in the client window
            inputField.setText("");  // Clear the input field
        });

        // Make the frame visible
        frame.setVisible(true);

        try {
            // Connect to the server running on localhost, port 5000
            socket = new Socket("localhost", 5000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            // Continuously listen for messages from the server
            while ((message = reader.readLine()) != null) {
                chatArea.append(message + "\n");  // Display the server's message in the chat area
            }
        } catch (Exception ex) {
            chatArea.append("Error: " + ex.getMessage());
        }
    }
}
