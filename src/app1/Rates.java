package app1;

public class Rates {

	String firstCurren;
	String secondCurren;
	double Rate ;
	
	public Rates ()
	{
		
	}
	
	public void setfirstCurren (String F)
	{
		firstCurren=F;
	}
	public void setsecondCurren (String S)
	{
		secondCurren=S;
	}
	
	public void setRate (double R)
	{
		Rate=R;
	}
	
	
	
	public String  getfirstCurren ()
	{
		return firstCurren;
				
	}
	public String  getsecondCurren ()
	{
		return secondCurren;
	}
	
	public double  getRate ()
	{
		return Rate;
	}
	
	
}
