package question1;

/**
 *
 * @authors Beatriz Gonçalves Fontes and Vitória Carla Costa de lira
 */

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;


public class UDPServer1 {
	
	public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        
        byte[] r1 = new byte[1];
        byte[] s1 = new byte[1];
        byte[] r2 = new byte[1];
        byte[] r3 = new byte[1];
        
        
        //Client's information
        while(true)
            {
                
                //First Value
                DatagramPacket receive1 = new DatagramPacket(r1, r1.length);
                serverSocket.receive(receive1);
                
                //Second Value
                DatagramPacket receive2 = new DatagramPacket(r2, r2.length);
                serverSocket.receive(receive2);
                
                //Operation
                DatagramPacket receive3 = new DatagramPacket(r3, r3.length);
                serverSocket.receive(receive3);
                
                //Data
                String v1 = new String(receive1.getData());
                String v2 = new String(receive2.getData());
                String op = new String(receive3.getData());
                
                //Conversion
                int port = receive1.getPort();
                int value1 = Integer.parseInt(v1);
                int value2 = Integer.parseInt(v2);
                
                int res = 0;
                
                //Sum
                if(op.contains("1")) {
                	
                    res = (value1 + value2);
                    String sumResult = Integer.toString(res);
                    s1 = sumResult.getBytes();                    
                }
                
                //Division
                if(op.contains("2")) {
                	 
                    res = (value1 / value2);
                    String divResult = Integer.toString(res);
                    s1 = divResult.getBytes();
                }
                
                //Multiplication
                if(op.contains("3")) {
                	
                    res = (value1 * value2);
                    String multResult = Integer.toString(res);
                    s1 = multResult.getBytes(); 
                }
                
                InetAddress ip = receive1.getAddress();
                DatagramPacket sendPacket = new DatagramPacket(s1,s1.length, ip, port);
                serverSocket.send(sendPacket);
                System.out.println("Result = " + res);
                
            }
	}
}