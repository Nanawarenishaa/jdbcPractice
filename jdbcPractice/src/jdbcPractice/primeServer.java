package jdbcPractice;

import java.net.*;
import java.io.*;

public class primeServer{
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Server is running and waiting for client to connetct...");
			Socket socket = ss.accept();
			System.out.println("client connected..!");
			
			
			BufferedReader input =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
			
			String Line;
			while((Line = input.readLine()) != null ) {
				if(Line.equalsIgnoreCase("exit")) {
					System.out.println("client disconnected!");
					break;
				}
				try {
					int number= Integer.parseInt(Line);
					Boolean isPrime = checkIfPrime(number);
					
					if(isPrime) {
						output.println(number+"is a prime no.");
					}
					
					
				} catch (NumberFormatException e) {
					output.print("invalid input");
				}
			}
			
		} catch (Exception e) {
			
		}
	}

	private static Boolean checkIfPrime(int number) {
		// TODO Auto-generated method stub
		return null;
	}
}