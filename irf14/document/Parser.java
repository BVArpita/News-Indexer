/**
 * 
 */
package edu.buffalo.cse.irf14.document;

import java.io.BufferedReader;
import java.io.FileReader;

import edu.buffalo.cse.irf14.document.Document;
import edu.buffalo.cse.irf14.document.ParsConstants;
import edu.buffalo.cse.irf14.document.ParserException;
import edu.buffalo.cse.irf14.document.ParserUtil;

/**
 * @author nikhillo
 * Class that parses a given file into a Document
 */
public class Parser {
	/**
	 * Static method to parse the given file into the Document object
	 * @param filename : The fully qualified filename to be parsed
	 * @return The parsed and fully loaded Document object
	 * @throws ParserException In case any error occurs during parsing
	 */
	
	
	public static void main(String[] args) throws ParserException {
		Parser.parse("C:\\Users\\Arpita\\workspace\\ir_1809\\training\\acq\\0000005");
	}
	
	
	public static Document parse(String filename) throws ParserException {
		if (filename==null || filename.length()==0) throw new ParserException("Null FILE !");
		ParserUtil putil=new ParserUtil();
		String content=null;;
		Document doc=new Document();
		boolean bruteforce=false;
		String line = null;
		int line_num=0;
		String checklin[]=new String[6];
		boolean contchek=true;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			doc=putil.setFilCat(doc,filename);
									
		line = reader.readLine();
		System.out.println(line);
		
		line_num=0;
		int hitcount=0,totcount=0,faultcnt=0;
		while (line!=null) 
		{
			line.replaceAll(String.valueOf((char) 160)," ");
			line.replaceAll("\u0020"," ");
			
			if (line.matches("^\\W*$")) 
			{
			line=reader.readLine();
			continue;
			}
			checklin[line_num]=line;
			line_num++;
			if(line.toLowerCase().matches(ParsConstants.FIND_CONTENT_START))
			{
				hitcount++;//test
			contchek=false;
			content=putil.splitDPC(doc,line);
			checklin[line_num]=" ";
			System.out.println(" wfsgerger"+checklin[0]);
			line_num=0;
			doc=putil.setTitle_AUT_ORG(doc,checklin);
			break;
			}

			if(line_num==8)
			{
				bruteforce=true;
				break;
			}
			line=reader.readLine();
			//matchdd++;
		//matchddd=matchddd+"\n"+f+"\t" +line;
		
		}	
			
		/*if(bruteforce){
		putil.bruteForce(filename);
		bruteforce=false;
		}
		*/
		while(line!=null){
		content+=(line=reader.readLine());
		}
								System.out.println(content);
		reader.close();	
		putil.print();
		//remove
	return putil.updateDoc(doc,(content=content.trim()));
	
		} catch (Exception e) {
			// TODO : need to do something !
			System.out.println(e.getMessage());
			if (e instanceof NullPointerException || e instanceof StringIndexOutOfBoundsException || e instanceof ArrayIndexOutOfBoundsException ) System.out.println("encountered"+ e.getMessage());;
		throw new ParserException("ERROR !"+ e.getMessage());
		}
		//remove
	}



}
