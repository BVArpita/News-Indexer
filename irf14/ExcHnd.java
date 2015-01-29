package edu.buffalo.cse.irf14;

public final class ExcHnd {

	public static char strchkr(String tststr, Class clasz,boolean xtrach) 
	{
		if(tststr==null || tststr.length() ==0)
			return 'F';
		return xtrach?allPass(tststr,clasz)?IRConst.K
				:'F'
					:IRConst.K;
	}
	public static boolean allPass(String tststr, Class clasz) {
		// TODO Auto-generated method stub
		return true; //TODO : checks need to be added
	}
}


/*return IRConstants.NULLERR+" "+clasz;
return xtrach?allPass(tststr,clasz)?IRConstants.OK
		:IRConstants.CHKFAIL
			:IRConstants.OK;
}*/