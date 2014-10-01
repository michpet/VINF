
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.jhu.nlp.wikipedia.PageCallbackHandler;


public class Search extends SAXParserDemo {
	
	
	static Map<String, String> hashMap2 = new HashMap<String,  String>(); 
	public void generate() throws IOException{
	
		List<String[]> myList = new ArrayList<String[]>();
		
		 File path = new File("D:/Trash/WikiParse");
         
         File [] files = path.listFiles();
         for (int i = 0; i < files.length; i++){
             if (files[i].isFile()){ 
                 
                 spracovanysubor = files[i].toString();
                 String cesta= files[i].toString();
                 final BufferedReader reader = new BufferedReader(new FileReader(cesta));
                 final StringBuilder contents = new StringBuilder();
                 while(reader.ready()) {
                     contents.append(reader.readLine());
                     if(reader.readLine().contains("T:")){
                     String[] cely = reader.readLine().toString().split("\\|");
                    
                     hashMap2.put(cely[0], cely[2]);}
                    
                     
                 }
                 reader.close();
                 final String stringContents = contents.toString();
            //  System.exit(0);
                //tu mame obsah suboru indexu ... 
                 
                 System.out.println("Process list of links of every page"+" | PAGES Count:"+listOfLinks.size());
                 for(int z=0;z<listOfLinks.size();z++){
                	 
                	
                	 
             	String linky = listOfLinks.get(z);
             	linky.replaceAll("\\[", "");
             	linky.replaceAll("\\]", "");
             	//System.out.println(linky);
             	String[] polelinkov = linky.split(",");
             	//System.out.println(linky);
             	for(int k = 0;k<polelinkov.length;k++){
             		String jedenlink = polelinkov[k].trim();
             		
             		if(hashMap2.containsKey("T:"+jedenlink)){
             			
             		
                 		
                 		String hladanysubor = hashMap2.get("T:"+jedenlink);
               		  String[] array = new String[3];
               		  array[0]=listOfTitles.get(z);
               		 array[1]=hladanysubor;
               		 array[2]=jedenlink;
               		 	myList.add(array);
             			
             		}
             	
             		/*
             		String pattern1 = "T:"+jedenlink+"|";
                    String pattern2 = "|>"; 
                    Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
                 	//Pattern p = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
            		Matcher matcher = p.matcher(stringContents);
            		while(matcher.find())
            		{
            			   String[] pomoc = matcher.group().toString().split("\\|");
                 		  String hladanysubor = pomoc[pomoc.length-2];
                 		  String[] array = new String[3];
                 		  array[0]=listOfTitles.get(z);
                 		 array[1]=hladanysubor;
                 		 array[2]=jedenlink;
                 		 	myList.add(array);

                 		            		}*/
             		
            		
             		 
             		
             		
             		
             		
             		
             	}
             	
             	
             			
 				} 
                 System.out.println("Final parse");
                 FinalParse fp = new FinalParse();
         		 fp.finalize_parse(myList);
                 
             }
         }
		
	}

}
