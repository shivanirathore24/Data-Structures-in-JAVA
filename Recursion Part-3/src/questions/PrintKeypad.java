package questions;

import java.util.Scanner;

public class PrintKeypad 
{
	public static String getOptions(int digit)
	{
		if(digit <1 || digit >10)
		{
			System.exit(0);
		}
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
	
	public static void printKeypadCombinations(int input, String stringSoFar)
	{
		if(input == 0)
		{
			System.out.println(stringSoFar);
			return;
		}
		int lastDigit = input%10;
		int smallInput = input/10;
		String optionsLastDigit = getOptions(lastDigit);
		for(int i=0; i < optionsLastDigit.length(); i++)
		{
			printKeypadCombinations(smallInput, optionsLastDigit.charAt(i) + stringSoFar);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Keypad Number : ");
		int input = sc.nextInt();
		printKeypadCombinations(input, "");
		
		
	}

}
