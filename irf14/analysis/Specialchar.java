package edu.buffalo.cse.irf14.analysis;

import edu.buffalo.cse.irf14.analysis.Analyzer;
import edu.buffalo.cse.irf14.analysis.Token;
import edu.buffalo.cse.irf14.analysis.TokenFilter;
import edu.buffalo.cse.irf14.analysis.TokenStream;

public class Specialchar extends TokenFilter implements Analyzer {

	//static String s1="pray to __/\\__";
	Token tok;
	
	
	
	public Specialchar(TokenStream tksstr)
	{
		super(tksstr);
		
	}

	/*static{
		TokenFilterFactory.getInstance().regToken(TokenFilterType.SPECIALCHARS, this);
	}*/
	@Override
	/*public boolean increment()
	{
		//TokenStream stream=getStream();
		if(stream!=null)
		{
			while(stream.hasNext())
				return true;
			return false;
		}
		return false;
	}
	@Override
	public TokenStream getStream()
	{
		
		return stream;
		
		
	}*/
	public void processStream()
	{
		if(stream!=null)
		{
			while(stream.hasNext())
			{
				tok=stream.next();
				String str=tok.getTermText();
				str=str.replaceAll("[~()`!@#$%^&*_+\\\\:\"\'?/<>|{}=;]","");
				/*if(str.matches("[~()`!@#$%\\^&\\*_+\\\\:\"\'?/<>|{}=;]*"))
					stream.remove();
				if(str.matches(":"))
					stream.remove();*/
				str=str.replaceAll("([A-Za-z])([-])([A-Za-z])","$1$3");
				str=str.replaceAll("([A-Za-z])([+])([A-Za-z])","$1$3");
				str=str.replaceAll("([A-Za-z])(^*)([A-Za-z0-9])","$1$3");
				tok.setTermText(str);
				//System.out.println(stream.toString());
				processed=true;
				
			}
			stream.reset();
		}
		
		//System.out.println(stream+"is output");
	}
	
	/*public static void main(String[] args) {
		//String spechar="`~!@#$%^&*()_+[]\\;\',./{}|:\"<>?";
		s1=s1.replaceAll("[~()`!@#$%^&*_+\\\\:\"\'?/<>|{}=;]","");
		s1=s1.replaceAll("([A-Za-z])([-])([A-Za-z])","$1$3");
		String[] s2=s1.split(" +");
		System.out.println(Arrays.toString(s2));

	}*/

}
