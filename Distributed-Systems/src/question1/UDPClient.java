package question1;

/**
 *
 * @authors Beatriz Gonçalves Fontes and Vitória Carla Costa de lira
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
    	
    public static void main(String args[]) throws Exception
    {
    	BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        
    	try{
            
            byte[] despatch1 = new byte[10];
            byte[] despatch2 = new byte[10];
            byte[] despatch3 = new byte[10];
            
            String number1, number2, operation;
            System.out.println("Choose the operation:\n1 - Sum\n2 - Division\n3 - Multiplication\n");
            operation = entry.readLine();
            System.out.println("First Value:");
            number1 = entry.readLine();
            System.out.println("Second Value:");
            number2 = entry.readLine();
            
            despatch1 = number1.getBytes();
            despatch2 = number2.getBytes();
            despatch3 = operation.getBytes();
            
            DatagramPacket packetDespatch1 = new DatagramPacket(despatch1,despatch1.length,ip,9876);
            clientSocket.send(packetDespatch1);
            DatagramPacket packetDespatch2 = new DatagramPacket(despatch2,despatch2.length,ip,9876);
            clientSocket.send(packetDespatch2);
            DatagramPacket packetDespatch3 = new DatagramPacket(despatch3,despatch3.length,ip,9876);
            clientSocket.send(packetDespatch3);
            
            byte[] buffer = new byte[13];
            DatagramPacket result = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(result);
            System.out.println("Result: "+new String(result.getData()));
 	
    	} catch (SocketException e) {
    		e.printStackTrace();
    	} catch (UnknownHostException e){
    		e.printStackTrace();
    	} catch (IOException e){
    		e.printStackTrace();
    	}finally{
    		if(clientSocket!=null){
    			clientSocket.close();
    		}
    	}
    }
}