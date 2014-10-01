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




public class DemoSAXHandler extends SAXParserDemo implements PageCallbackHandler {
	
        public void process(WikiPage page) {
        	
        //	System.out.println(page.isDisambiguationPage());
        	
        
    		
    		
    		
    		//Pattern p = Pattern.compile("\\{anchor(.*?)\\}",Pattern.DOTALL);
    		//Pattern p = Pattern.compile("\\<span id=(.*?)\\>",Pattern.DOTALL);
    		//Pattern p = Pattern.compile("<page>(.+?)</page>",Pattern.DOTALL);
    		/*Matcher matcher = p.matcher(page.getWikiText());
    		while(matcher.find())
    		{
    		    System.out.println("found match:"+matcher.group(1));
    		}*/
    		
    		////WRITER INDEXU
    		if(IndexFunction==true){
    			
    			String titleforme = page.getTitle().trim();
        		String titleid = page.getID();
    			
    		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Trash/WikiParse/index.txt", true)))) {
    		    out.println("T:"+titleforme+"|"+titleid+"|"+spracovanysubor+"|>");
    		}catch (IOException e) {
    		    //exception handling left as an exercise for the reader
    		}
    		
    		}
        	
        	
        	if(page.getTitle().indexOf("disambiguation")>=0 || page.getCategories().indexOf("disambiguation")>=0){
        	
        		
        		
               
        		
        		listOfTitles.add(page.getTitle());
        		listOfCategories.add(page.getCategories().toString());
        		listOfLinks.add(page.getLinks().toString());
        		//vktoromsubore.add(spracovanysubor);
        		
               
               // System.out.println(page.getText());
                
                    
        	}
        }

}