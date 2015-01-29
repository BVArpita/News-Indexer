package edu.buffalo.cse.irf14.analysis;

public class Category implements Analyzer {
	private boolean processed=false;
	private TokenStream stream =null;
	private TokenFilter tf;
		
	
	public  Category(TokenStream stream)
	{
	this.stream=stream;	
	this.stream=processStream();
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
	public TokenStream processStream()
	{
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.CAPITALIZATION, stream);
			 //getFilterByType(TokenFilterType.CAPITALIZATION,stream);
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.SPECIALCHARS,tf.getStream());
	 tf=TokenFilterFactory.getInstance().getFilterByType(TokenFilterType.SYMBOL,tf.getStream());
	 processed=true;
	 stream.reset();
		
	 return (stream=tf.getStream());
	}
}
