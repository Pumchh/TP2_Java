import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

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
