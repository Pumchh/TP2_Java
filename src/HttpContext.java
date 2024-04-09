import java.io.IOException;
import java.net.Socket;

public class HttpContext {
    private final Socket socket;
    private final HttpRequest request;
    private final HttpResponse response;

    public HttpContext(Socket socket) throws IOException {
        this.socket = socket;
        this.request = new HttpRequest(socket);
        this.response = new HttpResponse(socket);
    }

    public HttpRequest getRequest() throws IOException{
        return this.request;
    }

    public HttpResponse getResponse() throws IOException {
        return this.response;
    }

    public void close(){
        try {
            this.socket.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
