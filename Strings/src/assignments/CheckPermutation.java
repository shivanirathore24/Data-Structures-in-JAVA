package assignments;

import java.util.Scanner;

//For a given two strings, 'str1' and 'str2', check whether they are a permutation of each other or not.

public class CheckPermutation {
	
	public static boolean checkPermutation( String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			return false;
		}
		
		int frequency[] = new int[256];
		for(int i =0; i<256; i++)
		{
			frequency[i] =0;
		}
		
		for(int i = 0; i< str1.length(); i++)
		{
			char ch = str1.charAt(i);
			frequency[ch]++;
		}
		
		for(int i = 0; i< str2.length(); i++)
		{
			char ch = str2.charAt(i);
			frequency[ch]--;
		}
		
		for(int i =0; i<256; i++)
		{
			if(frequency[i] != 0)
			{
				return false;
			}
		}
		
		
		return true;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		 System.out.println(checkPermutation(str1, str2));
	}

}
