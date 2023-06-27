package assignments;
/*
Print Permutations of a String
Given a string, find and print all the possible permutations of the input string.
 */
import java.util.Scanner;

public class PrintPermutationOfString 
{
	/*
	 * Time Complexity : O(n*n!) 
	 * There are n! permutation and it requires O(n) to print permutation.
	 */
	public static void permutationsOfString(String input)
	{
		permutationOfStringHelper(input,"");
	}
	
	public static void permutationOfStringHelper(String input, String output)
	{
		if(input.length() == 0)
		{
			System.out.println(output);
			return;
		}
		for(int i=0; i<input.length(); i++)
		{
			permutationOfStringHelper((input.substring(0,i)+ input.substring(i+1)), output+input.charAt(i));
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		permutationsOfString(input);
	}
}
