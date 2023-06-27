package questions;
/*
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and 
return the count of elements populated in the output array.
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
 */
import java.util.Scanner;
public class ReturnKeypadCombinations 
{
	public static String getOptions(int digit)
	{
		if(digit == 2) {
			return "abc";
		}
		
		if(digit == 3) {
			return "def";
		}
		
		if(digit == 4) {
			return "ghi";
		}
		
		if(digit == 5) {
			return "jkl";
		}
		
		if(digit == 6) {
			return "mno";
		}
		
		if(digit == 7) {
			return "pqrs";
		}
		
		if(digit == 8) {
			return "tuv";
		}
		
		if(digit == 9) {
			return "wxyz";
		}
		return "";
	}
	
	public static String[] keypadCombinations(int input)
	{
		if(input == 0)
		{
			String[] output = new String[1];
			output[0] = "";
			return output;
		}
		
		String[] smallOutput = keypadCombinations(input/10);
		int lastDigit = input%10;
		String lastDigitOptions = getOptions(lastDigit);
		String[] output = new String[smallOutput.length * lastDigitOptions.length()];
		int k = 0;
		for(int i =0; i< smallOutput.length ; i++) {
			for( int j=0; j < lastDigitOptions.length(); j++)
			{
				output[k] = smallOutput[i] + lastDigitOptions.charAt(j);
				k++;
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int input = sc.nextInt();
		
		String[] output = keypadCombinations(input);
		for(String outputString : output)
		{
			System.out.println(outputString);
		}
	}
	

}
