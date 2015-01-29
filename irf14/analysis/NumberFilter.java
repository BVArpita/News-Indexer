package edu.buffalo.cse.irf14.analysis;

import edu.buffalo.cse.irf14.analysis.NumberFilter;
import edu.buffalo.cse.irf14.analysis.Token;
import edu.buffalo.cse.irf14.analysis.TokenConst;
import edu.buffalo.cse.irf14.analysis.TokenFilter;
import edu.buffalo.cse.irf14.analysis.TokenStream;


public class NumberFilter extends TokenFilter {

	//static String s1=new String("The App Store offered more than 2004 apps by Apple and third parties.");
	Token tok;
	
	NumberFilter nr;
		public NumberFilter(TokenStream tksstr)
	{
		super(tksstr);
	}
	
	
	
	protected void processStream()
	{
		if(stream!=null)
		{
			while(stream.hasNext())
			{
				if((tok=stream.next())==null) return;
				String str=tok.getTermText();
				if(str.matches(TokenConst.REGNUM))
					{stream.remove();}
				else if(str.matches(TokenConst.REGNUM1))
				{//System.out.println(str);
					str=str.replaceAll(TokenConst.REGNUM1,"$4");
					//System.out.println(str);
					}
				else if(str.matches(TokenConst.REGNUM2))
				{
					//System.out.println(str);
					str=str.replaceAll(TokenConst.REGNUM2,"$2");
					//System.out.println(str);
				}
				tok.setTermText(str);
				processed=true;
				//stream.append(tok);
				
			}
			stream.reset();
	}
		//System.out.println(stream+"is output");
		
	}
}
	/*public static void main(String[] args) {
		
		s1=(s1.replaceAll("(\\d+,\\d+)|([0-9][.][0-9])|(\\d)",""));
		System.out.println(s1);
		//String[] s2=s1.replaceAll("\\s\\s", "\\s");
		String[] s2=s1.split(" +");
		System.out.println(Arrays.toString(s2));
	}*/

	