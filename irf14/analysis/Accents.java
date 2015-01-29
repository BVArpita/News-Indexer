package edu.buffalo.cse.irf14.analysis;
import java.text.Normalizer;

public class Accents extends TokenFilter {

	public Accents(TokenStream stream) {
		super(stream);
		// TODO Auto-generated constructor stub
	}
	//static String s1="The urban counterpart of château is palais";
	Token tok;
	TokenStream stream;
	//TokenStream tks=new TokenStream();
	
	@Override
	public boolean increment()
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
	@Override
	public TokenStream getStream()
	{
		
		return stream;
		
		
	}
	public void normalize(TokenStream stream)
	{
		
		if(stream!=null)
		{
		  while(stream.hasNext())
		  {
			tok=stream.next();
			String str=tok.getTermText();
			str=Normalizer.normalize(str, Normalizer.Form.NFD);
			str=str.replaceAll("[\\p{M}]","");
			tok.setTermText(str);
			
			//stream.next();
			
		  }
		  stream.reset();
			
		}
		
	}
	/*public static void main(String[] args)
	{
		String s2[]=normalize();
		/*s1= Normalizer.normalize(s1, Normalizer.Form.NFD);
		s1=s1.replaceAll("[\\p{M}]","");
		String[] s2=s1.split(" +");*/
		/*System.out.println(Arrays.toString(s2));
	}*/
	@Override
	protected void processStream() {
		// TODO Auto-generated method stub
	normalize(this.stream)	;
	processed=true;
	}

}
