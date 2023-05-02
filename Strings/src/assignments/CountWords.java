package assignments;

import java.util.Scanner;

public class CountWords {
	
	public static int countWords(String str)
	{
		int count = 0;
		if( str.length() == 0)
		{
			return 0;
		}
		
		for(int i=0 ; i<str.length(); i++)
		{
			if(str.charAt(i) == ' ')
			{
				count++;
				
			}
		}
		return count+1;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int count = countWords(str);
		System.out.println(count);
	}

}
