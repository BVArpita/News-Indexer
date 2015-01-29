package edu.buffalo.cse.irf14.document;

//package edu.buffalo.cse.irf14.document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

 class ParserUtil {
String[] FILEID=new String[1];
String[] CATEGORY=new String[1];
String[]  TITLE=new String[1];
String[]  AUTHOR=new String[10];
String[] AUTHORORG=new String[5];
String[]  PLACE=new String[3];
String[]  NEWSDATE=new String[1];
String[]  CONTENT=new String[1];


//private static String filnam;

//private static long fileID=10000;
private int lastIndex4fil;
private static BufferedReader br;
private  String tmpfileID=null;
	
	public  Document setFilCat(Document doc,String filenam) {
		// TODO Auto-generated method stub
		
		String[] fil=filenam.split(ParsConstants.filesep_pat);
		
		FILEID[0]=fil[fil.length-1];
//		for(int kk=0;kk<=fil.length;kk++)System.out.println(fil[fil.length]);
		//filenam=filenam.substring(0,filenam.lastIndexOf(File.separator)+1);
		System.out.println(FILEID[0]+ "file");
		CATEGORY[0]=fil[fil.length-2];
		System.out.println("cat " + CATEGORY[0]);
		System.out.println(FILEID[0]);
		doc.setField(FieldNames.FILEID, FILEID);
		doc.setField(FieldNames.CATEGORY, CATEGORY);
		return doc;
		/*
		lastIndex4fil=filenam.lastIndexOf(File.separator);
		if (lastIndex4fil!=-1)return (tmpfileID=filenam.substring(lastIndex4fil));
		return null;
	*/}
	/*public String getCATEGORY(String filenam) {
		//no null CHECK
		String fileCat=null;
		int i=0,j=0;
		if (tmpfileID!=null){
			filenam=filenam.
			j=filenam.su
		if (i!=-1)fileCat=tmpfileID.substring();
		}
		else if (filenam.matches(ParsConstants.REG_CATEG))
		fileCat=filenam.replaceAll(ParsConstants.REG_CATEG, "$2"); 
		
		
		return fileCat;
	}
	*/
	
	/*public static String getTITLE(String filenam) {
		// TODO Auto-generated method stub
		String REG_TITLE="(\\s)*(A-Z)+(\\s)*";

		while((line=br.readLine())!=null)
		{
			line.matches(IRConstants.WHIITESP) continue;
			if(line.matches(IRConstants.TITLPAT)){this.TITLE+=line.trim();}
		}
		
		titpat.matches($2)=TITLE;
		return null;
	}
	public static String getAUTHOR(String author) {
		// TODO Auto-generated method stub
		String REG_AUTHMATCH="(.*)*<author>(.*)";
		String REG_AUTHEND="(.*)*</author>(.*)";
		tmpauth=author.toLowerCase();
		tmpauth=searchReg(tmpauth,REG_AUTHMATCH);
		this.author=getAuthor(tmpauth);
		this.authorg=getOrg(tmpauth);
		return null;
	}*/
	
	

	public String splitDPC(Document doc,String lin) {
		String arr[]=new String[2];
		arr=lin.split(" -");
		CONTENT[0]=arr[1];
		if (CONTENT[0]!=null)lin=lin.substring(0, lin.indexOf("-"));else CONTENT[0]=" ";
		
		NEWSDATE[0]=lin.substring(lin.lastIndexOf(',')+1);
		if (NEWSDATE[0]!=null){NEWSDATE[0]=NEWSDATE[0].trim(); PLACE[0]=lin.substring(0, lin.indexOf(NEWSDATE[0])-2);} else PLACE[0]=lin;
		PLACE[0]=PLACE[0].trim();
		
											System.out.println("Place "+PLACE[0]);
											System.out.println(AUTHOR[0]);
											System.out.println("DAT-"+NEWSDATE[0]);
		doc.setField(FieldNames.NEWSDATE,NEWSDATE);
		doc.setField(FieldNames.PLACE,PLACE);
		return CONTENT[0];
		
	}

	public Document updateDoc(Document doc,String cntnt) {
		// TODO Auto-generated method stub
		if (CONTENT[0]!=null)doc.setField(FieldNames.CONTENT,(cntnt=cntnt.trim()));
		if (TITLE[0]!=null||TITLE[0]!=" ")doc.setField(FieldNames.TITLE,(TITLE[0]=TITLE[0].trim()));
		if (AUTHOR[0]!=null)doc.setField(FieldNames.AUTHOR,AUTHOR);
		if (AUTHORORG[0]!=null)doc.setField(FieldNames.AUTHORORG, AUTHORORG);
		if (PLACE[0]!=null)doc.setField(FieldNames.PLACE,PLACE);
		if (NEWSDATE[0]!=null)doc.setField(FieldNames.NEWSDATE,NEWSDATE);
		  
return doc;		
	}
	
	/*
	public void bruteForce(String filename) throws FileNotFoundException,IOException
	{
		BufferedReader reader1 = new BufferedReader(new FileReader(filename));
		String line1 = reader1.readLine();
		
		while(line1!=null){
			
			//doc.setField(FieldNames.TITLE,putil.getTITLE(line1));
			TITLE=null;
			while(line1!=null && line1.trim().matches(ParsConstants.REG_TIT))
			{
				if (line1.matches("^\\W*$")) 
				{
				line1=reader1.readLine();
				continue;
				}
				TITLE=TITLE+line1;
				line1=reader1.readLine();
				
			}
			//doc.setField(FieldNames.AUTHOR,putil.getAUTHOR(filename));
			while(line1.matches("^\\W*$")) 
			{
			line1=reader1.readLine();
			continue;
			}
			String tmpAUTHOR=null;
			if(line1!=null && line1.matches(ParsConstants.REG_AUTH))
			{
				tmpAUTHOR=tmpAUTHOR+line1.replaceAll(ParsConstants.REG_AUTH
						, "$3");
				int li=tmpAUTHOR.lastIndexOf(',');if(li<0)li=tmpAUTHOR.length();
				AUTHORORG=tmpAUTHOR.substring(li);
				AUTHOR=tmpAUTHOR.trim().split(",");
				line1=reader1.readLine();
			}
			//doc.setField(FieldNames.AUTHORORG,putil.getAUTHORG(filename));
			while(line1.matches("^\\W*$")) 
			{
			line1=reader1.readLine();
			continue;
			}
		}
			//if(line1!=null && line1.matches(ParsConstants.REG_PLACE))
			//{
				PL//ACE=line1.replaceAll(ParsConstants.REG_PLACE, "$2");
				//NEWSDATE=line1.substring(line1.indexOf(PLACE)+PLACE.length(),line1.indexOf("-") );
			//}
			//while(line1.matches("^\\W*$")) 
			//{
			//line1=reader1.readLine();
			//continue;
			//}
			
	}*/
		
		
		
	public void print() {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
		try {
			PrintWriter pw=new PrintWriter(new File("D:\\IR\\Abcdddd.txt"));
			pw.append("\n"+FieldNames.FILEID +":"+FILEID);
			pw.append("\n"+FieldNames.CATEGORY +":"+CATEGORY);
			pw.append("\n"+FieldNames.TITLE +":"+TITLE );
			pw.append("\n"+FieldNames.PLACE +":"+PLACE );
			pw.append("\n"+FieldNames.NEWSDATE +":"+NEWSDATE);
			pw.append("\n"+FieldNames.CONTENT +":"+CONTENT);
			pw.append("\n\n\n\n\n=====");
			pw.close();
			/*
			System.out.println("\n"+FieldNames.FILEID +":"+FILEID);
			System.out.println("\n"+FieldNames.CATEGORY +":"+CATEGORY);
			System.out.println("\n"+FieldNames.TITLE +":"+TITLE );
			System.out.println("\n"+FieldNames.PLACE +":"+PLACE );
			System.out.println("\n"+FieldNames.NEWSDATE +":"+NEWSDATE);
			System.out.println("\n"+FieldNames.CONTENT +":"+CONTENT);
			System.out.println("\n\n\n\n\n=====");
			*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	

	public Document setTitle_AUT_ORG(Document d,String[] clin) {
		String tmpstr=null;
		TITLE[0]=" ";
		for(String aut:clin)
	{
			System.out.println(aut);
			if (aut==null) break;
		String tmpAuth=null;	
		String tmpsmal=aut.toLowerCase();
		if (tmpsmal.indexOf("<author>")!=-1)
		{
			String tmpAUTHOR=null;
			int i=aut.lastIndexOf(',')+1;
			if(i<0)
			{
				AUTHORORG=null;
			}
			else {
				int j=tmpsmal.lastIndexOf("</author>");
				if (j<0) {return d;}
				AUTHORORG[0]=aut.substring(i,j).trim();}
			
			int k=tmpsmal.indexOf("by");
			tmpAuth =aut.substring(k+2,i); ;
			AUTHOR=tmpAuth.trim().split(",");
				}
		else if (aut.toUpperCase().equals(aut))
		{TITLE[0]+=aut;}
	}
		TITLE[0]=TITLE[0].trim();
	System.out.println("sfdg -"+TITLE[0]+"sfsv");	
		return d;

	}
	}

	
 

