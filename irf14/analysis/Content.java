package edu.buffalo.cse.irf14.analysis;

import edu.buffalo.cse.irf14.analysis.Analyzer;
import edu.buffalo.cse.irf14.analysis.TokenFilter;
import edu.buffalo.cse.irf14.analysis.TokenFilterFactory;
import edu.buffalo.cse.irf14.analysis.TokenFilterType;
import edu.buffalo.cse.irf14.analysis.TokenStream;
import edu.buffalo.cse.irf14.analysis.TokenizerException;

public class Content implements Analyzer{
	private boolean processed=false;
	private TokenStream stream =null;
	private TokenFilter tf;
		
	
		
	public Content(TokenStream stream) {
		// TODO Auto-generated constructor stub
		//this.stream=stream;
		this.stream=stream;
		this.stream=processStream();
	
	}

	
	public TokenStream processStream()
	{
	// tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.DATE,stream);
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.CAPITALIZATION,stream);
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.SPECIALCHARS,tf.getStream());
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.SYMBOL,tf.getStream());
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.NUMERIC,tf.getStream());
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.ACCENT,tf.getStream());
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.STOPWORD,tf.getStream());
	 //tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.STEMMER,tf.getStream());
	 processed=true;
	 stream.reset();
		
	 return (stream=getStream());
	}


	@Override
	public boolean increment() throws TokenizerException {
		// TODO Auto-generated method stub
		return !processed;
	}


	@Override
	public TokenStream getStream() {
		// TODO Auto-generated method stub
		return !processed?processStream():stream;
	}
}
