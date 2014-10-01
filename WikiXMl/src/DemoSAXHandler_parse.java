import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.jhu.nlp.wikipedia.PageCallbackHandler;
import edu.jhu.nlp.wikipedia.WikiPage;




public class DemoSAXHandler_parse extends FinalParse implements PageCallbackHandler {
	
        public void process(WikiPage page) {
        	
        	// System.out.print(page.getTitle()+"---");
    	
        if(findme.contains(page.getTitle().trim())){
        	
        	int index =findme.indexOf(page.getTitle().trim());
        	String rodic = findme2.get(index);
        
        	//System.out.println("NASLO SA!!!"+page.getTitle());
        	Pattern p = Pattern.compile("\\{anchor(.*?)\\}",Pattern.DOTALL);
    		
    		Matcher matcher = p.matcher(page.getWikiText());
    		String anchor = "";
    		while(matcher.find())
    		{
    		 anchor = anchor+matcher.group(1);
    		}
        	
        	try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Trash/sparsovane.txt", true)))) {
    		   out.println("DSPAGE: "+rodic.trim());
    		   out.println("TITLE: "+""+page.getTitle().trim());
    		   
    		   out.println("ANCHOR"+anchor);
    		   out.println("______________________");
    		   out.println("");
    		}catch (IOException e) {
    		    //exception handling left as an exercise for the reader
    		}
        	
        	
        	
        }
        	
                    
        	}
        }

