# Compte rendu du TP2 de Java

## Ce n'est pas une chaussette

### WebServerApplication.java
```java

public class WebServerApplication {

    public static void main(String[] args) {
        System.out.println("Demarrage du serveur web...");
        WebServer webServer = new WebServer();
        webServer.run(80);
    }
}
```
### WebServer.java
```java

public class WebServer {
    private void readRequest(Socket socket){
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
}

```

## Réorganisation

### RequestProcessor.java
```java

import java.io.IOException;
import java.net.Socket;

public class RequestProcessor {

    private HttpContext context;

    private void process() {
        try {
            HttpRequest request = context.getRequest();
            HttpResponse response = context.getResponse();
            if (request.getMethod().equals("GET") && request.getUrl().equals("/")) {
                response.ok("Fonctionne");
            } else {
                response.notFound("Ne fonctionne pas");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public RequestProcessor(Socket socket){
        try {
            context = new HttpContext(socket);
            process();
            context.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
```