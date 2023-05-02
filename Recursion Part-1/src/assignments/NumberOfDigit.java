package assignments;

import java.util.Scanner;

/*Given the number 'n', find out and return the number of digits present in a number .*/

public class NumberOfDigit {
	public static int count(int n)
	{
		if(n%10 == 0)
		{
			return 0;
		}
		
		int smallOutput = count(n/10);
		return 1 + smallOutput;
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	 System.out.println(count(n)); 
	  
	
}

}
