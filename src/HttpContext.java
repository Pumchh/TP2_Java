import java.io.IOException;
import java.net.Socket;

public class HttpContext {
    private final Socket socket;
    private final HttpRequest request;
    private final HttpResponse response;

    public HttpContext(Socket socket) throws IOException {
        this.socket = socket;
        request = new HttpRequest(socket);
        response = new HttpResponse(socket);
    }

    public HttpRequest getRequest() throws IOException{
        return request;
    }

    public HttpResponse getResponse() throws IOException {
        return response;
    }

    public void close(){
        try {
            socket.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
