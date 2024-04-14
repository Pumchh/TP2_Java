import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Demarre sur le port " + portNumber);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestProcessor requestProcessor = new RequestProcessor(socket);
                Thread thread = new Thread(requestProcessor);
                thread.start();
                System.out.println("Nouvelle requete");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
