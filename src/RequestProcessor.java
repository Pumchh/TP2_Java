import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class RequestProcessor {

    private HttpContext context;

    private void process() throws IOException {
        HttpRequest request = this.context.getRequest();
        HttpResponse response = this.context.getResponse();
        File file = new File(request.getUrl().substring(1));

        if (file.getPath().equals("")) {
            response.ok("OK");
            response.sendFile("text/html", "src\\public\\index.html");
        } else if (file.isFile()) {
            String[] path = file.getPath().split("\\.");
            String ext = path[path.length - 1];
            response.ok("OK");

            switch (ext) {
                case "html":
                    response.sendFile("text/html", file.getPath());
                    break;
                case "css":
                    response.sendFile("text/css", file.getPath());
                    break;
                case "png":
                    response.sendFile("image/png", file.getPath());
                    break;
                case "jpg":
                    response.sendFile("image/jpg", file.getPath());
                    break;
                case "jpeg":
                    response.sendFile("image/jpeg", file.getPath());
                    break;
                case "svg":
                    response.sendFile("image/svg+xml", file.getPath());
                    break;
                case "webp":
                    response.sendFile("image/webp", file.getPath());
                    break;
                case "mp4":
                    response.sendFile("video/mp4", file.getPath());
                    break;
                default:
                    response.sendContent("text/plain", "File type not supported");
                    break;
            }
        } else {
            response.notFound("Page not found");
        }

        context.close();

    }

    public RequestProcessor(Socket socket) throws IOException {
        context = new HttpContext(socket);
        process();
    }

}
