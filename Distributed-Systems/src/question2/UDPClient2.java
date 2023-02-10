package question2;

/**
 *
 * @authors Beatriz Gonçalves Fontes and Vitória Carla Costa de lira
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class UDPClient2 {

    public static void main(String[] args) throws Exception {
        
        try {
            
            int PORT = 8888;
            String HOST_NAME = "127.0.0.1";
            String clientMsg = "", serverMsg = "";

            Socket socket = new Socket(HOST_NAME, PORT);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));

            while (!clientMsg.equals("Bye")) {
                
                System.out.println("Enter a number : ");
                clientMsg = bfrd.readLine();
                outStream.writeUTF(clientMsg);
                outStream.flush();
                serverMsg = inStream.readUTF();
                System.out.println(serverMsg);
                
            }

            outStream.close();
            outStream.close();
            socket.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
    }
}
