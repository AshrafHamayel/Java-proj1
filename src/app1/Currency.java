package app1;

public class Currency {
	String symbol;
	String  Name;
	
	public Currency ()
	{
		symbol="$";
		Name="Unnamed";
	}
	
	public void setSymbol (String S)
	{
		symbol=S;
	}
	public void setName (String N)
	{
		Name=N;
	}
	
	public String getSymbol ()
	{
		return this.symbol;
	}
	public String getName ()
	{
		return this.Name;

	}
	
	
}
