package edu.buffalo.cse.irf14.analysis;


import java.util.regex.Pattern;

import edu.buffalo.cse.irf14.IRConst;

public interface TokenConst extends IRConst {//TODO : extends IndexConst,////
public static final Pattern SPAC=Pattern.compile("( )+");
public static final Pattern HYP_REPL=Pattern.compile("([A-Za-z]+)[-]([A-Za-z]+)");
public static final Pattern HYP_RET=Pattern.compile(
		"([0-9])+[-]([0-9])+|([A-za-z]+)[-]([0-9]+)|([0-9]+)[-]([A-za-z]+)");
public static final String REGNUM = "(\\d+)|(\\d+,\\d+)";
public static final String REGNUM1 ="([0-9]+)(\\.)([0-9]+)(.*)";
public static final String REGNUM2="([0-9]+)(\\/)([0-9]+)";
public static final String ALL_LET_CAPS = "[A-Z]+";

}
