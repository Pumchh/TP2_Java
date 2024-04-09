

public class WebServerApplication {

    public static void main(String[] args) {
        System.out.println("Demarrage du serveur web...");
        WebServer webServer = new WebServer();
        webServer.run(80);

    }
}
