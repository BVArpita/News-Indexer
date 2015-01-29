package edu.buffalo.cse.irf14.index;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import edu.buffalo.cse.irf14.analysis.TokenStream;
import edu.buffalo.cse.irf14.document.FieldNames;

public class Indxr {
	private static Indxr iobj;
	private  HashSet <Integer>pl=new HashSet<Integer>();
	private int termcount;
	public boolean isFile=false;
	static HashMap<String,HashSet>IMap=new HashMap<String, HashSet>();
	
	public Indxr()
	{
		
	}
	Indxr(IndexType type)
	{
		
		if (type==IndexType.TERM)
				{
		iobj=TermIndex.getInst();
				}
		else if (type==IndexType.AUTHOR)
		{
			iobj=AuthorIndex.getInst();
		}
		else if (type==IndexType.CATEGORY)
		{
			iobj=CategoryIndex.getInst();
		}

		else if (type==IndexType.PLACE)
		{
			iobj=PlaceIndex.getInst();
		}

	}
	public static  Indxr getIndexType(){
		return iobj;
	}
	protected boolean filemap(HashMap<String, HashSet> i_Map, String name) {
		try{
			String filename=System.getProperty("INDEX.DIR")+name;
			System.out.println(System.getProperty("INDEX.DIR"));
			PrintWriter pw=new PrintWriter(new File(filename));
			Iterator itr=i_Map.keySet().iterator();
			String ikey;
				while(itr.hasNext())
				{
					ikey=(String)itr.next();
					pw.append(itr.next().toString()+"->"+i_Map.get(ikey));
					pw.println();
				}
			ikey=null;
			pw.close();pw=null;
			return true;
		}catch(Exception e){
				return false;
				}	
		finally{}
	}

	public void doIndexing(DocID dID, TokenStream stream)
	{
		//synchronized{
		String[] strarr=stream.getStrArray();
		HashSet <Integer> tmppl;
		HashSet <String> tmpks;
		
		for(String tmpstr:strarr)
		{
			//System.out.println(iobj.IMap.size() +" -"+iobj.getClass().getName()+"-"+tmpstr);
		System.out.println(tmpstr.equals("home")?"====":"");
			tmppl=iobj.IMap.get(tmpstr);
			tmpks=(HashSet<String>)iobj.IMap.keySet();
			if(tmppl==null)
			{
					tmppl=new HashSet<Integer>();
			}
			if (tmpks.contains(tmpstr))
			{
			IndexWriter.termMap.put(tmpstr,IndexWriter.termMap.get(tmpstr)+1);
			System.out.println(tmpstr.equals("home")?tmpstr+"-..........."+dID.termfreq:"");
			}
			else	
			{
				tmppl.add(dID.getdID());
				System.out.println(dID.termfreq+"temrfreq----");
			}
			
			
					if (iobj.IMap.size()>1900){
						if (filemap(iobj.IMap, iobj.getClass().getName()))iobj.IMap.clear();
						isFile=true;
					}
					iobj.IMap.put(tmpstr, tmppl);
		}
		
	}
	}
