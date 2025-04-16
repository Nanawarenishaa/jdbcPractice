package jdbcPractice;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chatClient {
    private static JTextArea chatArea;
    private static JTextField inputField;
    private static Socket socket;
    private static BufferedReader reader;
    private static PrintWriter writer;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });

        try {
            socket = new Socket("localhost", 5000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                chatArea.append(message + "\n");
            }
        } catch (Exception ex) {
            chatArea.append("Error: " + ex.getMessage());
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Chat Client");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Chat area to display messages
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Input field for typing messages
        inputField = new JTextField();
        frame.add(inputField, BorderLayout.SOUTH);

        // Action listener to send messages to the server
        inputField.addActionListener(e -> {
            String message = inputField.getText();
            writer.println("Client: " + message);
            chatArea.append("Client: " + message + "\n");
            inputField.setText(""); // Clear input field
        });

        frame.setVisible(true); // Make sure everything is visible
    }
}
