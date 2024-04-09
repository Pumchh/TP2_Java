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
            String line = "";

            do {
                line = input.readLine();
                response += line;
            } while(!line.isEmpty());

            String[] lineSplit = response.split(" ");

            this.method = lineSplit[0];
            this.url = lineSplit[1];

            System.out.println("Method: " + this.method + " URL: " + this.url);
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
