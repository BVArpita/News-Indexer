/**
 * 
 */
package edu.buffalo.cse.irf14.analysis;

import java.util.HashSet;

/**
 * The abstract class that you must extend when implementing your 
 * TokenFilter rule implementations.
 * Apart from the inherited Analyzer methods, we would use the 
 * inherited constructor (as defined here) to test your code.
 * @author nikhillo
 *
 */
public abstract class TokenFilter implements Analyzer {
	
	protected String ClassName=null;
	protected TokenStream stream=null;
	protected boolean processed=false;
	protected HashSet<String> InfoNote=new HashSet<String>(); 
	public TokenFilter()
	{
		
	}
	/**
	 * Default constructor, creates an instance over the given
	 * TokenStream
	 * @param stream : The given TokenStream instance
	 */
	public TokenFilter(TokenStream stream) {
		//TODO : YOU MUST IMPLEMENT THIS METHOD
		this.stream=stream;
		//System.out.println(this.stream+"in tokenfilter");
		this.ClassName=this.getClass().getName();
		/*String str=stream.toString();*/
		
	
		}
	public boolean increment() throws TokenizerException
	{
		return processed;
	}
	
	
	public String toString()
	{
		return this.ClassName;
	}
	public TokenStream getStream()
	{
		if (!processed)processStream();
		stream.reset();
		//System.out.println(stream+ "in tokenfilter");
		return stream;
	}
	protected abstract void processStream();
	
}
