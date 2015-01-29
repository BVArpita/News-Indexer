package edu.buffalo.cse.irf14.analysis;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Capitalization extends TokenFilter  {
	
	public Capitalization(TokenStream stream) {
		super(stream);
		// TODO Auto-generated constructor stub
	}

	public void processStream() {
		Pattern ALCAPS=Pattern.compile("((\\s)+[A-Z]{2,}((.|\\n)$))");//pattern to match if it is all capital letters. To be retained
		Pattern CAMELCASE=Pattern.compile("(^[A-Z]{1})([a-z])*([A-Z]{1,})?");
		
		String[] str=stream.getStrArray();
		for(String tmpstr:str)
		{
			if (tmpstr.matches(TokenConst.ALL_LET_CAPS))
			{
				
			}
		}
		//String strarr[];
		//Pattern p2=Pattern.compile("^[A-Z]{1}");//to match sentence starting with a capital letter. To be converted to lowercase
		//Pattern p3=Pattern.compile([A-Za-z][\\s][A-Z]) to match capital letters in between the sentence. To be retained
		///////TODO
		//if (PLACES.contains(strarr[0]))continue;
		//else
			//strarr[0].toLowerCase();
		
		Matcher AC=ALCAPS.matcher("KtHE");
		Matcher cc=CAMELCASE.matcher("San Francisco");
		if(AC.find()) {
	        System.out.println(AC.group());
	    }
		else if(cc.find()) {
	        System.out.println(cc.group());
	    }
		
		
		//System.out.println(Arrays.toString(s2));
	}
	

}
