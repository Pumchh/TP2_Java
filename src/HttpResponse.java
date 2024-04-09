import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {

    private final BufferedWriter output;

    public HttpResponse(Socket socket) throws IOException {
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void ok(String message){
        try{
            this.output.write("HTTP/1.1 200 " + message + "\n");
            this.output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void notFound(String message){
        try {
            this.output.write("HTTP/1.1 404 " + message + "\n");
            this.output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void sendContent(String contentType, String content){
        try {
            this.output.write("Content-Type: " + contentType + "\n\n");
            this.output.write(content);
            this.output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
