package questions;

public class PrintFactorial 
{
	//way-1
	public static void factorial1(int n)
	{
		int output = factorialHelper(n);
		System.out.println(output);
	}
	
	public static int factorialHelper(int input)
	{
		if(input == 0)
		{
			return 1;
		}
		return input * factorialHelper(input-1);
	}
	
	//way-2
	public static void factorial2(int input, int answer)
	{
		if(input == 0)
		{
			System.out.println(answer);
			return;
		}
		answer = answer * input;
		factorial2(input-1, answer);
	}
	
	public static void main(String[] args) {
		int n = 5;
		factorial1(n);
		factorial2(n, 1);
	}
}
