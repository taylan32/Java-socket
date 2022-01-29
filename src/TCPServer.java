import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TCPServer{
    public static void main(String[] args){
		
		// initially empty strings
		String clientMessage="", serverMessage="";
		Scanner scanner = new Scanner(System.in);
		
		try {
			// establish the connection
			ServerSocket serverSocket = new ServerSocket(SystemConfig.getPort());
			Socket socket = serverSocket.accept();
			System.out.println("Start typing");
			System.out.println("Type EXIT to terminate the connection.");
			JOptionPane.showMessageDialog(null, "Client connected","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			
			while(!serverMessage.equals("EXIT")) {
				
				// read the message from client
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				clientMessage = reader.readLine();
				System.out.println("Client: " + clientMessage);
				
				//send a message to client
				System.out.println("Server: ");
				serverMessage = scanner.nextLine();
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(serverMessage);
				writer.flush();
			} // end while
			
			// terminate the connection
		 	System.out.println("Quitting...");
			socket.close();
			serverSocket.close();
			scanner.close();
			
		} // end try
		catch(IOException exception) {
			System.out.println("Error Message: " + exception.getMessage());
		}
		
		
	}
}