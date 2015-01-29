/**
 * 
 */
package edu.buffalo.cse.irf14.analysis;

import java.util.ArrayList;
import java.util.regex.Matcher;

import edu.buffalo.cse.irf14.ExcHnd;
import edu.buffalo.cse.irf14.IRConst;

/**
 * @author nikhillo
 * Class that converts a given string into a {@link TokenStream} instance
 */
public class Tokenizer {
	/**
	 * Default constructor. Assumes tokens are whitespace delimited
	 */
	String dlmtr=" ";
	Token[] tknarr=null;
	TokenStream ts=new TokenStream();
	public Tokenizer() {
		ArrayList<String> a=new ArrayList<String>();
		//TODO : YOU MUST IMPLEMENT THIS METHOD
	}
	
	/**
	 * Overloaded constructor. Creates the tokenizer with the given delimiter
	 * @param delim : The delimiter to be used
	 */
	public Tokenizer(String delim) {
		
		this.dlmtr=delim;
		
		//TODO : YOU MUST IMPLEMENT THIS METHOD
	}
	
	/**
	 * Method to convert the given string into a TokenStream instance.
	 * This must only break it into tokens and initialize the stream.
	 * No other processing must be performed. Also the number of tokens
	 * would be determined by the string and the delimiter.
	 * So if the string were "hello world" with a whitespace delimited
	 * tokenizer, you would get two tokens in the stream. But for the same
	 * text used with lets say "~" as a delimiter would return just one
	 * token in the stream.
	 * @param str : The string to be consumed
	 * @return : The converted TokenStream as defined above
	 * @throws TokenizerException : In case any exception occurs during
	 * tokenization
	 */
	public TokenStream consume(String str) throws TokenizerException {
		
		char c=' ';if (((c=ExcHnd.strchkr(str, this.getClass(), false)))!='k') 
	{throw new TokenizerException(IRConst.NULLERR);}	
	//except
		//Matcher m = TokenConst.HYP_REPL.matcher(str);
		//str.replaceAll("([A-Za-z]+)[-]([A-Za-z]+)","$1 $3");
		//str.replaceAll("([A-Za-z]+)[@]([A-Za-z]+)", "$1$3");
		//StringTokenizer strTkn = new StringTokenizer(str," ");
		//System.out.println(str);
		 TokenStream tknstrob=new TokenStream(str.split(dlmtr));//changed here by Arpita
		 return tknstrob;
		}

}