package edu.buffalo.cse.irf14.analysis;


import edu.buffalo.cse.irf14.analysis.Token;
import edu.buffalo.cse.irf14.analysis.TokenFilter;
import edu.buffalo.cse.irf14.analysis.TokenStream;

public class Stopword extends TokenFilter{

	
	//ArrayList<String> listofstopwords = new ArrayList<String>();
	
	//static String s1="this is the test";
	Token tok;
	//TokenStream stream;
	//Stopword sw;
	
	String[] stopwords={"a","able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","dear","did","do","does"
			,"either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","however","i","if","in","into","is","it","its","just"
			,"least","let","like","likely","may","me","might","most","must","my","neither","no","nor","not","of","off","often","on","only","or","other","our","own",
			"rather","said","say","says","she","should","since","so","some","than","that","the","their","them","then","there","these","they","this","tis","to","too",
			"twas","us","wants","was","we","were","what","when","where","which","while","who","whom","why","will","with","would","yet","you","your"};
	
	public Stopword(TokenStream tksstr)
	{
		super(tksstr);
	}
	
	
		
	
	public void processStream()
	{
		if(stream!=null)
		{
		  while(stream.hasNext())
		  {
			tok=stream.next();
			String str=tok.getTermText();
			//System.out.println(str);
			for(int i=0;i<stopwords.length;i++)
			{
				//System.out.println("Inside for loop");
			  if(str.equalsIgnoreCase(stopwords[i]))
			  {
				//  System.out.println(str+"is a stopword");
				  stream.remove();
			  }
			
			}
			//tok.setTermText(str);
	       }
		  //System.out.println(stream.toString());
		}
		
		}
	
}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(stream!=null)
		{
		  while(stream.hasNext())
		  {
			tok=stream.next();
			String str=tok.getTermText();
			for(i=0;i<stopwords.length;i++)
			{
			  if(stopword[i]==str)
			  {
				  stream.remove();
			  }
			
			tok.setTermText(str);
			
			stream.next();
			
		  }
		}
		
		s1=s1.replaceAll("of|the|this|a|all|is","");
		System.out.println(s1);
	}

}*/

