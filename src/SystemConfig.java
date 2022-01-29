public class SystemConfig {

    private final static int PORT = 4444;
	private final static String SERVER_ADDRESS="localhost";
	
	
	public static int getPort() {
		return PORT;
	}
	
	public static String getAddress() {
		return SERVER_ADDRESS;

	}
}
