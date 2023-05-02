package assignments;

import java.util.Scanner;

/*Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
Do this recursively.*/

public class FindPower {
	public static int power(int x, int n)
	{
		 if(n == 0)
		 {
			 return 1;
		 }
		 
		
		 int smallOutput = power(x,n-1);
		 int output = x * smallOutput;

		 return output;
	}
	
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int x = sc.nextInt();
	  int n = sc.nextInt();
	  int output = power(x,n);
	 System.out.println(output);
	  

}
}
