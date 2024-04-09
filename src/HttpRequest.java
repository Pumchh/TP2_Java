import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest {

    private String method;
    private String url;

    public HttpRequest(Socket socket){
        readClientRequest(socket);
    }

    private void readClientRequest(Socket socket){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = "";
            int line = 0;
            while((response = input.readLine()) != null) {
                if (line == 0) {
                    String[] parts = response.split(" ");
                    if (parts.length >= 2) {
                        method = parts[0];
                        url = parts[1];
                    }
                    System.out.println("Method: " + method + " URL: " + url);
                }
            line++;
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
