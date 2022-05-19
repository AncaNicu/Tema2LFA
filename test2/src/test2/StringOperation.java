package test2;

//clasa pt a realiza diferite operatii si verificari
//pe stringuri
public class StringOperation {
	private String s;

	public StringOperation(String s) {
		this.s = s;
	}
	
	//pt a verifica daca s este de tip numar
	public boolean checkIfNumber()
	{
		if(s == null)
		{
			return false;
		}
		try {
			int nr = Integer.parseInt(s);
		}catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	
	//pt a returna numarul reprezentat de acel string
	public int sAsNumber()
	{
		if(checkIfNumber() == true)
		{
			return Integer.parseInt(s);
		}
		return -1;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
}
