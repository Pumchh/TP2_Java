import java.io.IOException;
import java.net.Socket;

public class RequestProcessor {

    private HttpContext context;

    private void process() throws IOException {
        HttpRequest request = this.context.getRequest();
        HttpResponse response = this.context.getResponse();
        if (request.getMethod().equals("GET")) {
            if (request.getUrl().equals("/")) {
                response.ok("OK");
                response.sendContent("text/html", "<strong>HelloWorld</strong>");
            } else {
                response.notFound("Page not found");
            }
        } else {
            response.notFound("Method not supported");
        }

        context.close();

    }

    public RequestProcessor(Socket socket){
        try {
            this.context = new HttpContext(socket);
            process();
            //socket.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
