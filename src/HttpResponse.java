import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {

    private BufferedWriter output;

    public HttpResponse(Socket socket) throws IOException {
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void ok(String message) throws IOException {
        output.write("HTTP/1.1 200 OK\r\n");
        output.flush();
    }

    public void notFound(String message) throws IOException {
        output.write("HTTP/1.1 404 Not Found\r\n");
        output.flush();
    }

    public void sendContent(String contentType, String content) throws IOException {
        output.write(contentType + "\r\n");
        output.write(content + "\r\n");
        output.flush();
    }

}
