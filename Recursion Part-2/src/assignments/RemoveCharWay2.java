package assignments;

import java.util.Scanner;

public class RemoveCharWay2 {
	public static String removeX(String input){
		// Write your code here
		if(input.length() == 0)
		{
			return input;
		}

		//String smallOutput = removeX(input.substring(1));
		if(input.charAt(0) == 'x')
		{
			return removeX(input.substring(1));
		}
		return input.charAt(0) + removeX(input.substring(1));
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(removeX(input));
	}

}
