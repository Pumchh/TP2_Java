import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    /*private void readRequest(Socket socket){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = "";
            while((response = input.readLine()) != null)
                System.out.println(response);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private void sendResponse(Socket socket){
        try {
            if(socket.isConnected()){
                OutputStream output = socket.getOutputStream();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void run(int portNumber){
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Demarre sur le port " + portNumber);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Nouvelle requete");
                readRequest(socket);
                sendResponse(socket);
                socket.close();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

     */

    public void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Demarre sur le port " + portNumber);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nouvelle requete");
                new RequestProcessor(socket);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
