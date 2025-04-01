package jdbcPractice;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chatServer {
    private static JTextArea chatArea;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static BufferedReader reader;
    private static PrintWriter writer;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat Server");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JTextField inputField = new JTextField();
        frame.add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(e -> {
            String message = inputField.getText();
            writer.println("Server: " + message);  // Send server message to client
            chatArea.append("Server: " + message + "\n");  // Display on server side
            inputField.setText("");  // Clear input field
        });

        frame.setVisible(true);

        try {
            serverSocket = new ServerSocket(5000);
            chatArea.append("Waiting for client...\n");
            socket = serverSocket.accept();
            chatArea.append("Client connected!\n");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                chatArea.append(message + "\n");  // Display client message
            }
        } catch (Exception ex) {
            chatArea.append("Error: " + ex.getMessage());
        }
    }
}
