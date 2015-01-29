package edu.buffalo.cse.irf14.index;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.buffalo.cse.irf14.analysis.Token;
import edu.buffalo.cse.irf14.analysis.TokenStream;

public final class TermIndex extends Indxr {
	
	private  static TermIndex ti=null;
	public static final String iname="content";
	private TermIndex()
	{
	this.IMap=new HashMap<String,HashSet>(2000,0.95f);
	}
	
	public static TermIndex getInst()
	{
		return ti==null?(ti=new TermIndex()):ti;
	
	}
	
	}
		//}

	

