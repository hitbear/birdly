package hitbear.birdly;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
	
	
	//unencrypted case
	/*
	 * @Override
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
    }*/
	
	
	
	@SuppressWarnings("deprecation")
	//encrypted case
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		String encrypted_data = "";
		String data = "";
		if(req.getParameter("enc").compareTo("true") == 0) {
			System.out.println("encrypted traffic");
			if(req.getParameter("client") != null) {
				System.out.println(req.getParameter("client"));
				//System.out.println(req.getReader().toString());
			}
			if(req.getParameter("information")!=null) {
				
				//try to decrypt with private key
				try {
					//TODO: .replace(" ", "+"); is not nice...
					encrypted_data = req.getParameter("information").toString().replace(" ", "+").replace("\n", "");
					data = Decryptor.prepareDecryption(encrypted_data);
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				fileWriter.writeToFile("/home/mh/Dokumente/information1.txt",data);
			}
			if(req.getParameter("information2")!=null) {
				
				//try to decrypt with private key
				data = "";
				try {
					//TODO: .replace(" ", "+"); is not nice...
					encrypted_data = req.getParameter("information2").toString().replace(" ", "+").replace("\n", "");
					data = Decryptor.prepareDecryption(encrypted_data);
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				fileWriter.writeToFile("/home/mh/Dokumente/information2.txt",data);
			}
		}

		
    }
}
