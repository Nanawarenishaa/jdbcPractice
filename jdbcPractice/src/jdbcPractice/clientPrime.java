package jdbcPractice;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class clientPrime {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Enter a number to check if it's prime (or type 'exit' to quit): ");
                String userInput = sc.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    output.println("exit");
                    break;
                }

                // Send the number to the server
                output.println(userInput);

                // Read and print the response from the server
                String response = input.readLine();
                System.out.println("Server says: " + response);
            }

            socket.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
