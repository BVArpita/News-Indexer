package edu.buffalo.cse.irf14.index;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.buffalo.cse.irf14.analysis.Token;
import edu.buffalo.cse.irf14.analysis.TokenStream;

public final class AuthorIndex extends Indxr{
	private  HashSet <Integer>pl;
	private static AuthorIndex ti=null;
	
	static HashMap<String,HashSet>IMap;
	
	private AuthorIndex()
	{
	this.IMap=new HashMap<String,HashSet>(10000);
	}
	
	public static AuthorIndex getInst()
	{
		return ti==null?(ti=new AuthorIndex()):ti;
	
	}
	public void doIndexing(Integer dID, TokenStream stream)
	{
		//synchronized{
		String[] strarr=stream.getStrArray();
		HashSet <Integer> tmppl;
		for(String tmpstr:strarr)
		{
			tmppl=IMap.get(tmpstr);
			if(tmppl==null || tmppl.size()==0)
			{
					pl=new HashSet<Integer>();
			}
					pl.add(dID);
					IMap.put(tmpstr, pl);
		}
	}
		//}
	}
	

