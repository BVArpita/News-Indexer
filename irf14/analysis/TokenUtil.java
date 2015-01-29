package edu.buffalo.cse.irf14.analysis;

public class TokenUtil {

	public static boolean[] CapsNote(Token tmptok) {
		
		
		String strtok=null;
		int len=(strtok=tmptok.toString()).length();
		boolean caps[]=new boolean[len];
		char tmp=0;
		for(int i=0;i<len;i++)
		{
			tmp=strtok.charAt(i);
			caps[i]=(tmp>='A'&&tmp<='Z')?true:false;
		}
			return caps;
	}

	
public static Token reCaps(boolean[] caps,Character[] chr) {
		
		int len=caps.length;
		Token tkn=new Token();
		char[] chrtok=new char[len];
		char tmp=0;
		for(int i=0;i<len;i++)
		{
			chrtok[i]=caps[i]?Character.toUpperCase(chr[i]):chr[i];
		}
			 tkn.setTermBuffer(chrtok);
			 return tkn;
	}
}
