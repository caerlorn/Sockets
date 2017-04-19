import java.io.*; 
import java.net.*; 

class TCPClient { 

	public static void main(String argv[]) throws Exception	{ 
		String sentence; 
		String modifiedSentence; 

		BufferedReader userInput = 
			new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 1337); 
		
		DataOutputStream toServer = 
			new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader userInput = 
			new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 

		sentence = userInput.readLine();
		while(!sentence.equals("quit"))	{
			toServer.writeBytes(sentence + '\n'); 
			modifiedSentence = userInput.readLine(); 
			System.out.println("Server says: " + modifiedSentence); 
			sentence = userInput.readLine(); 
		}
		clientSocket.close();
	}
}