import java.io.*; 
import java.net.*;

class UDPClient2 { 

	public static void main(String args[]) throws Exception {
	 
	  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
	  DatagramSocket clientSocket = new DatagramSocket();
	  InetAddress IPAddress = InetAddress.getByName("localhost");
	  
	  byte[] sendData = new byte[1024]; 
	  byte[] receiveData = new byte[1024];
	  
	  String sentence = inFromUser.readLine();
	  while(!sentence.equals("quit")) {
		   sendData = new byte[1024]; 
		   receiveData = new byte[1024];
		   sendData = sentence.getBytes(); 
		   DatagramPacket sendPacket = 
		   new DatagramPacket(sendData, sendData.length, IPAddress, 1337);
		  clientSocket.send(sendPacket);
		  DatagramPacket receivePacket = 
		   new DatagramPacket(receiveData, receiveData.length);
		  clientSocket.receive(receivePacket);
		  String modifiedSentence = 
		   new String(receivePacket.getData());
		  System.out.println("Server says:" + modifiedSentence.trim()); 
		  sentence = inFromUser.readLine();
		}
	  clientSocket.close();
	}
}