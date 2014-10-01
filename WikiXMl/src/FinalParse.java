import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.jhu.nlp.wikipedia.PageCallbackHandler;
import edu.jhu.nlp.wikipedia.WikiXMLParser;
import edu.jhu.nlp.wikipedia.WikiXMLParserFactory;


public class FinalParse {
	 static Map<String, ArrayList<String>> hashMap = new HashMap<String,  ArrayList<String>>(); 
	 static ArrayList<String> findme = new ArrayList<String>();
	 static ArrayList<String> findme2 = new ArrayList<String>();
	 String WHERE = "";
	 private static void addValues(String key, String value)  
	 {   
	  ArrayList<String> tempList = null;        
	  if(hashMap.containsKey(key)){    
	   tempList=hashMap.get(key);   
	   if(tempList == null)      
	     tempList = new ArrayList<String>();       
	   tempList.add(value);      
	  }  
	  else  
	  {       
	   tempList = new ArrayList();    
	   tempList.add(value);       
	   }       
	  hashMap.put(key,tempList);  
	 } 
	
	public void finalize_parse(List<String[]> myList)
	{
		PageCallbackHandler handler = new DemoSAXHandler_parse();
		System.out.println(myList.size()+" Final parse - unique key - duplicate");
		for(int i = 0;i<myList.size();i++){
			
			
			String[] help = myList.get(i);
			
			
			
			String parent = help[0];
			String subor = help[1];
			String hladanynazov = help[2];
			
			addValues(subor,hladanynazov+"|"+parent);
			
			
		}
		
		System.out.println("Iterate in hashmap and search for pages");
		 Iterator<String> it = hashMap.keySet().iterator();   
		  ArrayList<String> tempList = null;  
		  
		       while(it.hasNext()){   
		           String key = it.next().toString();  
		             tempList = hashMap.get(key);  
		             
		             String FINDFILE = key;
		             findme.clear();
		             findme2.clear();
		             
		            if(tempList != null){  
		            	
		                for(String value: tempList){ 
		                	
		                  String[] rozdel = value.split("\\|");
		                  String FINDER = rozdel[0];
		                  findme.add(FINDER);
		                   WHERE = rozdel[1];
		                   
		                  findme2.add(WHERE);
		                  
		                	}  
		               }  
		         
		            
		            
		            
		            String cesta = key;
		            System.out.println("Parsujeme finalne | cesta:"+cesta);
	                if(new File(cesta).exists()){
	                WikiXMLParser wxsp = WikiXMLParserFactory.getSAXParser(cesta);
	                
                    
                    try {
                    	
                    	    
                            wxsp.setPageCallback(handler);
                            wxsp.parse();
                            
                    }catch(Exception e) {
                            e.printStackTrace();
                    }
		            
	                }
		            
		        }  
		
		       Date date = new Date();
               
               // display time and date using toString()
               System.out.println(date.toString());
		
		
		
	}
	
	
}
