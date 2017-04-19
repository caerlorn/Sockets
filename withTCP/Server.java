import java.io.*; 
import java.net.*; 

class TCPServer { 

	public static void main(String argv[]) throws Exception { 
		
		String clientSentence; 
		String reflectSentence; 

		ServerSocket welcomeSocket = new ServerSocket(1337);
		System.out.println("Server online");
		while(true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromUser = 
					new BufferedReader(new InputStreamReader(System.in));
			BufferedReader inFromClient = new BufferedReader(new
					InputStreamReader(connectionSocket.getInputStream())); 
			DataOutputStream outToClient = 
				new DataOutputStream(connectionSocket.getOutputStream()); 
			while(connectionSocket.isConnected()){
				clientSentence = inFromClient.readLine();
				System.out.println("The clients send their regards:"+ clientSentence);
				reflectSentence=inFromUser.readLine();
				outToClient.writeBytes(reflectSentence+'\n');
				
			} 
		}
	} 
} 