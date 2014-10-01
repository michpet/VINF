import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import edu.jhu.nlp.wikipedia.PageCallbackHandler;
import edu.jhu.nlp.wikipedia.WikiPage;
import edu.jhu.nlp.wikipedia.WikiXMLParser;
import edu.jhu.nlp.wikipedia.WikiXMLParserFactory;


public class SAXParserDemo {
        /**
         * @param args
         */
	
	
	static ArrayList<String> listOfTitles = new ArrayList<String>();
	static ArrayList<String> listOfCategories = new ArrayList<String>();
	static ArrayList<String> listOfLinks = new ArrayList<String>();
	static ArrayList<String> vktoromsubore = new ArrayList<String>();
	static String spracovanysubor = "";
	static boolean IndexFunction = true;
	File file = new File ("D:/Trash/WikiParse/index.txt");
        public static void main(String[] args) {
                
                if(args.length != 1) {
                    //    System.err.println("Usage: Parser <XML-FILE>");
                      //  System.exit(-1);
                }
                
                
                Date date = new Date();
                
                // display time and date using toString()
                System.out.println(date.toString());
                
             
                File path = new File("D:/Trash/wiki");
                PageCallbackHandler handler = new DemoSAXHandler();
                File [] files = path.listFiles();
                for (int i = 0; i < files.length; i++){
                    if (files[i].isFile()){ //this line weeds out other directories/folders
                        System.out.println(files[i]);
                        spracovanysubor = files[i].toString();
                        
                        
                        String cesta= files[i].toString();
                        WikiXMLParser wxsp = WikiXMLParserFactory.getSAXParser(cesta);
                
                      
                        try {
                        	
                        	    
                                wxsp.setPageCallback(handler);
                                wxsp.parse();
                                
                        }catch(Exception e) {
                                e.printStackTrace();
                        }
                        
                        
                        
                    }
                }
                
            
          Search a = new Search();
          try {
			a.generate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
                
                
              /*  
               */
        }
}
