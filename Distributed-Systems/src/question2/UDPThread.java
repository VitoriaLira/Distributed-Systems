package question2;

/**
 *
 * @authors Beatriz Gonçalves Fontes and Vitória Carla Costa de lira
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


class UDPThread extends Thread{
    
    Socket serverClient;
    int clientNumber;
    int square;

    UDPThread(Socket inSocket, int count) {
        
        serverClient = inSocket;
        clientNumber = count;
        
    }

    public void run() {
        
        try {
            
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMsg = "", serverMsg = "";
            
            while (!clientMsg.equals("Bye")) {
                
                clientMsg = inStream.readUTF();
                System.out.println("From client - " + clientNumber + ": the number is: " + clientMsg);
                square = Integer.parseInt(clientMsg) * Integer.parseInt(clientMsg);
                serverMsg = "From server to client - " + clientNumber + " the square of " + clientMsg + " is: " + square;
                outStream.writeUTF(serverMsg);
                outStream.flush();
                
            }
            
            inStream.close();
            outStream.close();
            serverClient.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            System.out.println("The client - " + clientNumber + " is out!!! ");
            
        }
    }
}
