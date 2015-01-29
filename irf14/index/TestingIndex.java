package edu.buffalo.cse.irf14.index;

import edu.buffalo.cse.irf14.document.Document;
import edu.buffalo.cse.irf14.document.FieldNames;

public class TestingIndex {

	public TestingIndex() {}
		// TODO Auto-generated constructor stub
		public static void main(String[] args) throws IndexerException
		{
			
				String[] strs = {"new home sales top sales forecasts", "home sales rise in july", 
						"increase in home sales in july", "july new home sales rise"};
				int len = strs.length;
				Document d;
				String dir = "D:\\IRTesting";
				IndexWriter writer = new IndexWriter(dir); //set this beforehand
				for (int i = 0; i < len; i++) {
					d = new Document();
					d.setField(FieldNames.FILEID, "0000"+(i+1));
					d.setField(FieldNames.CONTENT, strs[i]);
					writer.addDocument(d);
					
				}
				
				writer.close();
		
		}

}
