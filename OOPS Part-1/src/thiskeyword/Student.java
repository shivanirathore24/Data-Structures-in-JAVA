package thiskeyword;

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
			//System.out.println("Invalid rollno !");
			return;
		}
		System.out.println("this "+ this);
		rollno = rn;
	}

}
