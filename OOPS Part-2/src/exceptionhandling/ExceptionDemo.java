package exceptionhandling;

public class ExceptionDemo {
	
	public static int divide(int a, int b) throws DivideByZeroException
	{
		if( b == 0)
		{
			throw new DivideByZeroException();
			//throw new ArithmeticException();
		}
		
		return a/b;
	}
	
	public static void main(String[] args) {
		try {
			divide(10,0);
			System.out.println("Within Try");
		}
		catch(DivideByZeroException e)
		{
			System.out.println("Divide By zero Exception raised !");
		}
		
		System.out.println("Main");
	}

}
