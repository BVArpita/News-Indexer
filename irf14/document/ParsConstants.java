package edu.buffalo.cse.irf14.document;

import java.util.regex.Pattern;

//import edu.buffalo.cse.irf14.IRConstants;

public interface ParsConstants {//extends IRConstants {

	public static final String DEFAULTPARS = "(\\s*)([A-Z]+(\\s)*[A-Z*])(\\s+)";
	public static final String ISALFANUM = ".*\\w.*";
//	public static final String FIND_CONTENT_START = "(^.*)([0-9]{2})( \\- )(\\w+)";
	public static final String MONTH_REG = "Jan|Feb|Mar|Apr|May|Jun|Jul|Sep|Aug|Oct|Nov|Dec";
	public static final String MONTH_REGG = "jan|feb|mar|apr|may|jun|jul|sep|aug|oct|nov|dec" ;
	public static final String FIND_CONTENT_START = "^    (.+)((("+MONTH_REGG+")([A-Za-z]*))+)"
													+" ([0-9]{1,2})( \\-)(.*$)";
	public static final String REG_WS="^\\W*$";
	/*public static final String REG_CATEG="(^.+):([a-zA-Z0-9])+(:)([a-zA-Z0-9]+)$";
	public static final String REG_PLACE = "(^.*)([A-Z]+(( |.)+)[A-Z]+), "+MONTH_REGG+"(.+)$";
	public static final String REG_TIT = "((( )*[A-Z]+)( )+)+$";
	public static final String REG_DATE = "("+MONTH_REGG+")(.+)(\\d{1,2})( )(\\-)(.*$)";
	public static final String REG_CNTSTART ="(^.+)( - )(\\w+)" ;
	*/
	public static final String REG_AUTH = "(\\s+)(<AUTHOR>)(\\s+)(By )([A-Za-z]+)(.+)$";
	public static final String filesep_pat = Pattern.quote(System.getProperty("file.separator"));
	public static final String COMMA = ",";
}
	