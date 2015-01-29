/**
 * 
 */
package edu.buffalo.cse.irf14.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.buffalo.cse.irf14.analysis.Analyzer;
import edu.buffalo.cse.irf14.analysis.AnalyzerFactory;
import edu.buffalo.cse.irf14.analysis.TokenFilter;
import edu.buffalo.cse.irf14.analysis.TokenFilterFactory;
import edu.buffalo.cse.irf14.analysis.TokenStream;
import edu.buffalo.cse.irf14.analysis.Tokenizer;
import edu.buffalo.cse.irf14.analysis.TokenizerException;
import edu.buffalo.cse.irf14.document.Document;
import edu.buffalo.cse.irf14.document.FieldNames;
/**
 * @author nikhillo
 * Class responsible for writing indexes to disk
 */
public class IndexWriter {
	/**
	 * Default constructor
	 * @param indexDir : The root directory to be sued for indexing
	 */
	String indexDir;
	IndexUtil iutil;
	boolean isvaliddir=false;
	static ArrayList<String> docs=new ArrayList<String>();
	static HashMap<String,Integer> termMap=new HashMap<String, Integer>();
	IndexReader a_indexrd=null;
	IndexReader c_indexrd= null;
	IndexReader p_indexrd= null;
	IndexReader t_indexrd= null;
	AnalyzerFactory factory;
	Tokenizer tkizer ;
	/*
	private HashSet <Integer>pl=new HashSet<Integer>();
	private HashMap<String,Set>tdMap=new HashMap<String,Set>();*/
	public IndexWriter(String indexDir) {
		//TODO : YOU MUST IMPLEMENT THIS
	if (indexDir!=null)
	{System.setProperty("INDEX.DIR",(this.indexDir=indexDir));
	isvaliddir=true;
	iutil=new IndexUtil(indexDir);
	}
	
	}
	
	/**
	 * Method to add the given Document to the index
	 * This method should take care of reading the filed values, passing
	 * them through corresponding analyzers and then indexing the results
	 * for each indexable field within the document. 
	 * @param d : The Document to be added
	 * @throws IndexerException : In case any error occurs
	 */
	public void addDocument(Document d) throws IndexerException {
		
	//if (!isvaliddir) {System.out.println("INVALID PATH/execution !");return;}
	
	
	//Tokenizing
	//one thgread
	DocID did=new DocID(d.getField(FieldNames.FILEID),
			d.getField(FieldNames.CATEGORY),
			d.getField(FieldNames.AUTHOR));
	
	TokenStream stream=tokenize(FieldNames.CATEGORY,d);
	Analyzer analyz=analyze(FieldNames.CATEGORY, stream);
	CategoryIndex.getInst().doIndexing(did.getdID(), stream);
	/*	}catch(Exception e)
	{
		if (e instanceof NullPointerException ||e instanceof StringIndexOutOfBoundsException
				||e instanceof ArrayIndexOutOfBoundsException ||e instanceof  IllegalArgumentException
				);
	}
	try{*/TokenStream stream1=tokenize(FieldNames.AUTHOR,d);
	Analyzer analyz1=analyze(FieldNames.AUTHOR, stream1);
	AuthorIndex.getInst().doIndexing(did.getdID(), stream1);
	/*}catch(Exception e)
	{
		if (e instanceof NullPointerException ||e instanceof StringIndexOutOfBoundsException
				||e instanceof ArrayIndexOutOfBoundsException ||e instanceof  IllegalArgumentException
				);}
	try{*/TokenStream stream2=tokenize(FieldNames.PLACE,d);
	Analyzer analyz2=analyze(FieldNames.PLACE, stream2);
	PlaceIndex.getInst().doIndexing(did.getdID(), stream2);
/*}catch(Exception e)
	{
	if (e instanceof NullPointerException ||e instanceof StringIndexOutOfBoundsException
			||e instanceof ArrayIndexOutOfBoundsException ||e instanceof  IllegalArgumentException
			);}
	try{*/tkizer = new Tokenizer();
	TokenStream stream3=tokenize(FieldNames.CONTENT,d);
	factory = AnalyzerFactory.getInstance();
	Analyzer analyz3=analyze(FieldNames.CONTENT, stream3);
	new Indxr(IndexType.TERM).doIndexing(did, stream3);
	/*}	catch(Exception e)
	{
		if (e instanceof NullPointerException ||e instanceof StringIndexOutOfBoundsException
				||e instanceof ArrayIndexOutOfBoundsException ||e instanceof  IllegalArgumentException
				);}
	*/
	docs.add(did==null?" ":did.toString());
	 
	
a_indexrd= new IndexReader(System.getProperty("INDEX.DIR"), IndexType.AUTHOR);
c_indexrd= new IndexReader(System.getProperty("INDEX.DIR"), IndexType.CATEGORY);
p_indexrd= new IndexReader(System.getProperty("INDEX.DIR"), IndexType.PLACE);
t_indexrd= new IndexReader(System.getProperty("INDEX.DIR"), IndexType.TERM);
		}
	
	
	private Analyzer analyze(FieldNames fnames, TokenStream stream) {
		// TODO Auto-generated method stub

		Analyzer filter = factory.getAnalyzerForField(
				fnames, stream);		
//													System.out.println(filter.getClass().getName());
		return filter;
	}

	private TokenStream tokenize( FieldNames fntype,Document d) {
		// 
		try {
			TokenStream tstream ;
			int i=1;
			String str=null;
			if (fntype==FieldNames.AUTHOR ||fntype==FieldNames.PLACE )
			{
			String[] atrar=d.getField(fntype);
			int len=atrar.length;
			str=atrar[0];
			while(i<len)
				{
				str+=" #next#"+atrar[i];
				}
			}
			else
			{
				//if
				str=d.getField(fntype)[0]==null?" ":d.getField(fntype)[0];
			}
			tstream = tkizer.consume(str);
			str=null;						
			return tstream;
		}
		catch (TokenizerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			}

	/**
	 * Method that indicates that all open resources must be closed
	 * and cleaned and that the entire indexing operation has been completed.
	 * @throws IndexerException : In case any error occurs
	 */
	public void close() throws IndexerException {
		//TODO
		
	}
}
