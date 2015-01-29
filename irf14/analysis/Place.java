package edu.buffalo.cse.irf14.analysis;

public class Place implements Analyzer {

	
	private TokenFilter tf;
	private TokenStream stream;
	private boolean processed=false;
	public Place(TokenStream tksstr) {
		// TODO Auto-generated constructor stub
		this.stream=stream;
		this.stream=processStream();
	}

	
	public TokenStream processStream()
	{
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.CAPITALIZATION,stream);
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.SPECIALCHARS,tf.getStream());
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.SYMBOL,tf.getStream());
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.ACCENT,tf.getStream());
	 processed=true;
	 stream.reset();
		
	 return (stream=tf.getStream());
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
