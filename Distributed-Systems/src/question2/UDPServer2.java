package question2;

/**
 *
 * @authors Beatriz Gonçalves Fontes and Vitória Carla Costa de lira
 */

import java.net.ServerSocket;
import java.net.Socket;

public class UDPServer2 {
    
    public static void main(String[] args) throws Exception {
        
        try {
            
            ServerSocket server = new ServerSocket(8888);
            int count = 0;
            System.out.println("The server is on...");
            
            while (true) {
                
                count++;
                Socket serverClient = server.accept(); 
                System.out.println(" >> " + "Client N°: " + count + " started!");
                UDPThread t = new UDPThread(serverClient, count); 
                t.start();
                
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
    }
}
