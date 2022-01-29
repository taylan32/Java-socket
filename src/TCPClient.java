import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient{
	
	public static void main(String[] args) {
		
		//initially empty strings
		String clientMessage="", serverMessage="";
		Scanner scanner= new Scanner(System.in);
		try {
			//create a socket
			Socket socket = new Socket(SystemConfig.getAddress(), SystemConfig.getPort());
			
			System.out.println("Start typing...");
			System.out.println("Type EXIT to terminate the connection.");
				
			while(!clientMessage.equals("EXIT")) {		
				// send a message to server
				System.out.println("Client: ");
				clientMessage = scanner.nextLine();
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(clientMessage);
				writer.flush();
								
				// read the message from server
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				serverMessage = reader.readLine();
				System.out.println("Server: " + serverMessage);
			}
			// terminate the connection
			System.out.println("Quitting...");
			socket.close();
			scanner.close();
			
			}
			catch(IOException exception) {
				System.out.println("Error Message: " + exception.getMessage());
			}
				
		}
		
		
	}
	
