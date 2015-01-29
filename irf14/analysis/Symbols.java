package edu.buffalo.cse.irf14.analysis;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Symbols extends TokenFilter {

	//static String S1="Frank's";
	//String pretain="[A-Z][-][0-9]|[0-9][-][A-Z]|[0-9][-][0-9]";
	//String punctuation="[^\\p{Punct}*(.*?)\\p{Punct}*$]";
	//TokenStream stream;
	Token tok;
	
	
	public Symbols(TokenStream tksstr)
	{
		super(tksstr);
	}
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
	public TokenStream getStream()
	{
		
		return stream;
		
		
	}*/

	public void processStream()
	{
		//System.out.println("inside processstream of symbols");
		if(stream!=null)
		{
			while(stream.hasNext())
			{
				tok=stream.next();
				String str=tok.getTermText();
				System.out.println(str);
				//tests for hyphen
				System.out.println(str);
				if(str.matches("[A-Z]+[-][0-9]+|[0-9]+[-][A-Z]+|[0-9]+[-][0-9]+|[A-Za-z]*[-][A-Za-z]+[0-9]"))
				{
					System.out.println(str+" retained");
					tok.setTermText(str);
					return;
				}
				str=str.replaceAll("([A-Za-z]+)(\\-){1,}([A-Za-z]+)","$1 $3");//replace week-day=week day
				str=str.replaceAll("(\\-+)(\\w+)","$2");//--c kind of input
				str=str.replaceAll("(\\w+)(\\-+)","$1");//c-- kind of input
				str=str.replaceAll("([\\w])(\\s+)(\\-+)(\\s+)([\\w])","$1 $5");//hyphen padded with spces kind of input
				//if(str.matches("-"));
					
				
				//test for apostrophe
				 if(str=="isn't")str=str.replaceAll("isn't","is not");
				 if(str=="don't")str=str.replaceAll("don't","do not");
				 if(str=="won't")str=str.replaceAll("won't","will not");
				 if(str=="shan't")str=str.replaceAll("shan't","shall not");
				 if(str=="I'm")str=str.replaceAll("I'm","I am");
				 if(str=="we're")str=str.replaceAll("we're","we are");
				 if(str=="they're")str=str.replaceAll("they're","they are");
				 if(str=="I've")str=str.replaceAll("I've","I have");
				 if(str=="Should've")str=str.replaceAll("Should've","Should have");
				 if(str=="They'd")str=str.replaceAll("They'd","They would");
				 if(str=="She'll")str=str.replaceAll("She'll","She will");
				 if(str=="Put 'em")str=str.replaceAll("Put 'em","Put them");
				 
				 if((str.matches("([A-Za-z]+)(['])([A-Za-z]{0,1})")))
				 str=str.replaceAll("([A-Za-z])(['])([A-Za-z]{0,1})","$1");//failing for 'quote test' and last tc
				 else if((str.matches("(['])([A-Za-z]+)")))
					 str=str.replaceAll("(['])([A-Za-z]+)","$2");
				 else if((str.matches("([A-Za-z])(')(.*)")))
					 str=str.replaceAll("([A-Za-z])('){1,}(.*)","$1$3");
				 System.out.println(str);
				 
					 
				 
				 //test for punctuation
				 str=str.replaceAll("(.*?)(\\w)(\\p{Punct}*$)","$1$2");
				 
				 tok.setTermText(str);
				 
				  
				  
				  
				  
				
			}
			System.out.println(stream+"is output1");
		}
	}
/*	public static void main(String[] args) {
		/*Pattern p1= Pattern.compile("^(\\p{Punct})*([A-Z][.][A-Z])(\\p{Punct})*");
		Matcher m1=p1.matcher("!?This is@ a.out test!!?");
		if (m1.matches()) {
	        System.out.println(m1.group(1));
	    }*/

		//test for hyphen
		//System.out.println("hello");
		
		//System.out.println(str.matches("[a-z]\\-\\-"));
		//S1=S1.replaceAll("([A-Za-z])(\\-\\-)([A-Za-z]*)","$1");/working
		//System.out.println("hello arpita");
		//retain
		//S1=S1.replaceAll("([A-Za-z]+)(\\-+)([A-Za-z]*)([0-9]+)","");
		//S1="33fsf-c";
		//S1=S1.replaceAll("([0-9]+)[A-Za-z]*(\\-+)([A-Za-z]+)","");
		//S1="564--3536";
		//System.out.println(S1+"\t"+S1.matches("([0-9]+)(\\-+)([0-9]+)"));
		
		
		//S1="week-day";
		/*System.out.println(S1.matches("([A-Za-z]+)(\\-+)([A-Za-z]+)"));
		S1=S1.replaceAll("([A-Za-z]+)(\\-+)([A-Za-z]+)","$1 $3");//replace
		
		//remove
		//S1="--c";
		System.out.println(S1.matches("(\\-+)(\\w+)"));
		System.out.println(S1.replaceAll("(\\-+)(\\w+)","$2"));
		//S1="c--";
		System.out.println(S1.matches("(\\w+)(\\-+)"));
		//S1="a -- b";
		System.out.println(S1.matches("([\\w])(\\s+)(\\-+)(\\s+)([\\w])"));
		System.out.println(S1.replaceAll("([\\w])(\\s+)(\\-+)(\\s+)([\\w])","$1 $5"));
		
		System.out.println("bye arpita");
		//S1=S1.replaceAll("(\\-{0,})([A-Za-z])(\\-{0,})([A-Za-z]*)","$2");
		//S1=S1.replaceAll("([A-Za-z])(\\s*)([\\-]{0,})(\\s{0,})([A-Za-z])","$1 $5");//week-day=week day

		//System.out.println("bye" +S1);
		
		//S1=S1.replaceAll("([\\s])+([-])([\\s])+","");
		//System.out.println(S1);*/		
		
		//test for punctuation
		
		//System.out.println(S1.matches("([])"));
		//S1=S1.replaceAll("(.*?)(\\w)(\\p{Punct}*$)","$1$2");
		//Pattern p=Pattern.compile("(^\\p{Punct})|(\\p{Punct}$)");
		//if(matcher.find())
				
		//System.out.println(S1);
		
		//test for apostrophe
		/*S1="f''(x) = df'/dx";
		if(S1=="isn't")S1=S1.replaceAll("isn't","is not");
		if(S1=="dont't")S1=S1.replaceAll("don't","do not");
		if(S1=="won't")S1=S1.replaceAll("won't","will not");
		if(S1=="shan't")S1=S1.replaceAll("shan't","shall not");
		if(S1=="I'm")S1=S1.replaceAll("I'm","I am");
		if(S1=="we're")S1=S1.replaceAll("we're","we are");
		if(S1=="they're")S1=S1.replaceAll("they're","they are");
		if(S1=="I've")S1=S1.replaceAll("I've","I have");
		if(S1=="Should've")S1=S1.replaceAll("Should've","Should have");
		if(S1=="They'd")S1=S1.replaceAll("They'd","They had");
		if(S1=="She'll")S1=S1.replaceAll("She'll","She will");
		if(S1=="Put'em")S1=S1.replaceAll("Put'em","Put them");
		System.out.println("hi");
		/*if(S1.matches("([']{0,1})([A-Za-z])(['])([A-Za-z]{0,1})"))
		S1=S1.replaceAll("([']{0,1})([A-Za-z])(['])([A-Za-z]{0,1})","$2");
		System.out.println(S1);
		
		//S1=S1.replaceAll("([A-Za-z])(['])([.*])","$1");
		//System.out.println(S1);
		
		//S1=S1.replaceAll("([A-Za-z])(['])([m])","$1 am");
		System.out.println((S1.matches("([']{0,1})([A-Za-z])(['])([A-Za-z]{0,1})")));
		S1=S1.replaceAll("([']{0,})([A-Za-z])(['])([A-Za-z]{0,1})","$2");
		
		System.out.println(S1);
		
	}*/

}
