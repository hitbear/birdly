package hitbear.birdly;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
 
import hitbear.birdly.BirdlyServlet;
 
public class App {
 
    public static void main(String[] args) throws Exception {
 
        Server server = new Server(7070);
        ServletContextHandler handler = new ServletContextHandler(server, "/upload");
        handler.addServlet(BirdlyServlet.class, "/");
        //if message is too long...
        //server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", 1000000);
        //10MB
        handler.setMaxFormContentSize(10000000);
        server.start();
 
    }
 
}