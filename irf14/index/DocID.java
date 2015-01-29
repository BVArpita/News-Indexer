package edu.buffalo.cse.irf14.index;

import java.util.HashMap;

import edu.buffalo.cse.irf14.document.Document;

public final class DocID implements Comparable<DocID>{
static  int dID=10000;
 int termfreq=0;
String fileID=new String("");
String catID=new String("");
String author[]=new String[3];
static HashMap infoMap=new HashMap<Integer,String>();
public DocID(String[] fileID,String[] catID,String[] auth) {
	this.fileID=fileID[0]!=null?fileID[0]:"";
	//this.catID=catID[0]!=null?catID[0]:"";
	try{
		this.author=auth;
	}catch(ArrayIndexOutOfBoundsException ie)
	{
		System.out.println("MULTIPLE AUTHORS");
	}
}
public int getdID()
{return dID++;}

public String getdfileID()
{return fileID;}
public String toString()
{
	return dID+",fileID ;"+fileID+";";
	//+" ;catID:"+catID+" ;Author:"+","+author[0]+","+author[0]+","+author[0]+"#";
}
@Override
public int compareTo(DocID paramT) {
	// TODO Auto-generated method stub
	
	return this.dID ^ paramT.dID ;
}

}
