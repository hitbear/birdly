package hitbear.birdly;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MFileWriter {

	
	
	public void writeToFile(String fileName, String content) {
		
        try { 
        	  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( new FileWriter(fileName, true)); 
            out.write(content);
            //separator
            //out.write(";::;");
           //out.write("\n---------------\n"); 
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
	}
}
