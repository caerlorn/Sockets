import java.io.*; 
import java.net.*;

class UDPServer2 { 

	public static void main(String args[]) throws Exception {
		
		DatagramSocket serverSocket = new DatagramSocket(1337); 
		String capitalizedSentence;
		byte[] receiveData = new byte[1024]; 
		byte[] sendData= new byte[1024];
		while(true){ 
		   sendData = new byte[1024]; 
		   receiveData = new byte[1024];
		   
		   DatagramPacket receivePacket = 
			new DatagramPacket(receiveData, receiveData.length);
		   serverSocket.receive(receivePacket);
		   String sentence = new String(receivePacket.getData());
		   if(sentence.trim().equals("hello"))
			capitalizedSentence="Hello Client!";
		   else if(sentence.trim().equals("bye"))
			capitalizedSentence="GoodBye Client!!";
		   else capitalizedSentence = sentence;
		   InetAddress IPAddress = receivePacket.getAddress();
		   int port = receivePacket.getPort();
		   sendData = capitalizedSentence.getBytes();
		   DatagramPacket sendPacket = 
			new DatagramPacket(sendData, sendData.length, IPAddress, port);
		   serverSocket.send(sendPacket);
		}
	}
}