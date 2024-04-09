import java.net.Socket;

public class RequestProcessor {

    private HttpContext context;

    private void process(){
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
