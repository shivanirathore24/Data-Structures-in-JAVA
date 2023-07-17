package setter_getter;

public class Student {
	String name;
	private int rollno;
	
	public int getRollno()
	{
		return rollno;
	}
	
	public void setRollno( int rn)
	{
		if( rn <= 0)
		{
			System.out.println("Invalid rollno !");
			return;
		}
		rollno = rn;
	}

}
