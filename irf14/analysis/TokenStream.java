/**
 * 
 */
package edu.buffalo.cse.irf14.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author nikhillo
 * Class that represents a stream of Tokens. All {@link Analyzer} and
 * {@link TokenFilter} instances operate on this to implement their
 * behavior
 */
public class TokenStream implements Iterator<Token>{
	private  ArrayList<Token> Alt=new ArrayList<Token>();
	private ListIterator<Token> itr;
	private Token  curtok=null;
	public TokenStream()
	{
		itr=Alt.listIterator();
	}
	public TokenStream(String strar[])
	{
		//System.out.println(strar[0]);
		Alt=new ArrayList(Arrays.asList(cnvrtStr2ToknArr(strar)));
		Alt.remove(null);
		itr=Alt.listIterator();
		
	}
	
	public void refresh()
	{
		Alt.remove(null);
	}
	
	private Token[] cnvrtStr2ToknArr(String[] strarr) {
		// TODO Auto-generated method stub
		int len=strarr.length;
		Token[] tknarr=new Token[len];
		int i=0;
	while(i<len)
	{ 
		tknarr[i]=new Token();tknarr[i].setTermText(strarr[i]);
		i++;
		}
		
		return tknarr;
	}
	/**
	 * Method that checks if there is any Token left in the stream
	 * with regards to the current pointer.
	 * DOES NOT ADVANCE THE POINTER
	 * @return true if at least one Token exists, false otherwise
	 */
	@Override
	public boolean hasNext() {
		// TODO YOU MUST IMPLEMENT THIS
		return itr.hasNext();
		
	}

	/**
	 * Method to return the next Token in the stream. If a previous
	 * hasNext() call returned true, this method must return a non-null
	 * Token.
	 * If for any reason, it is called at the end of the stream, when all
	 * tokens have already been iterated, return null
	 */
	@Override
	public Token next() {
		return itr.hasNext()?(curtok=itr.next()):null;
		// TODO YOU MUST IMPLEMENT THIS
		
	}
	
	public int length()
	{
		return Alt!=null?Alt.size():0;
	}
	
	
	/**
	 * Method to remove the current Token from the stream.
	 * Note that "current" token refers to the Token just returned
	 * by the next method. 
	 * Must thus be NO-OP when at the beginning of the stream or at the end
	 */
	@Override
	public void remove() {
		curtok=null;
		if(itr.hasPrevious()){itr.remove();}
	}
	
	/**
	 * Method to reset the stream to bring the iterator back to the beginning
	 * of the stream. Unless the stream has no tokens, hasNext() after calling
	 * reset() must always return true.
	 */
	public void reset() {
	itr=null;
	itr=Alt.listIterator();
	curtok=null;
		//TODO : YOU MUST IMPLEMENT THIS
	}
	
	/**
	 * Method to append the given TokenStream to the end of the current stream
	 * The append must always occur at the end irrespective of where the iterator
	 * currently stands. After appending, the iterator position must be unchanged
	 * Of course this means if the iterator was at the end of the stream and a 
	 * new stream was appended, the iterator hasn't moved but that is no longer
	 * the end of the stream.
	 * @param stream : The stream to be appended
	 */
	public void append(TokenStream stream) {
		//TODO : YOU MUST IMPLEMENT THIS
	if (stream==null)return ;
		Token tmptok=null;
		while(stream.hasNext())
		{
			tmptok=stream.next();
			if(!Alt.contains(tmptok))Alt.add(tmptok);
		}
		Alt.remove(null);
		//reset();
	}
	public List<Token> getArrayList()
	{
		return Alt==null||Alt.size()==0?new  ArrayList<Token>():Alt;
	}
	public String toString()
	{
		return Alt.toString();
	}
	/**
	 * Method to get the current Token from the stream without iteration.
	 * The only difference between this method and {@link TokenStream#next()} is that
	 * the latter moves the stream forward, this one does not.
	 * Calling this method multiple times would not alter the return value of {@link TokenStream#hasNext()}
	 * @return The current {@link Token} if one exists, null if end of stream
	 * has been reached or the current Token was removed
	 */
	public Token getCurrent() {
		//TODO: YOU MUST IMPLEMENT THIS
		return curtok;
	}
	public String[] getStrArray() {
		// TODO Auto-generated method stub
		Iterator itr=Alt.iterator();
		String[] str=new String[Alt.size()];
		int i=0;
		while(itr.hasNext())
		{
			Token t=(Token)itr.next();
			String tmpstr=null;
			if(t!=null && (tmpstr=t.getTermText())!=null){
			str[i++]=tmpstr;			
		}
		}
		
		return str;
	}
	
}
