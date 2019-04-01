package hitbear.birdly;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;


public class BirdlyServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	MFileWriter fileWriter = new MFileWriter();
	
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
        resp.setStatus(HttpStatus.OK_200);
        resp.getWriter().println("EmbeddedJetty");
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
		if(req.getParameter("client") != null) {
			System.out.println(req.getParameter("client"));
			//System.out.println(req.getReader().toString());
		}
		if(req.getParameter("information")!=null) {
			fileWriter.writeToFile("/home/mh/Dokumente/information1.txt",req.getParameter("information").toString());
		}
		if(req.getParameter("information2")!=null) {
			fileWriter.writeToFile("/home/mh/Dokumente/information2.txt",req.getParameter("information2").toString());
		}
    }
}
