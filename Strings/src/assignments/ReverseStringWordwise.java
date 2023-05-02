package assignments;

public class ReverseStringWordwise {
	
public static String reverseWordWise(String input) {
		
		String reverseString = "";
		for(int i = input.length()-1; i>=0; i--)
		{
			//reverseString = reverseString + str.charAt(i);
			reverseString += input.charAt(i);
		}

		String ans = "";
		int currentWordStart = 0;
		int i =0;
		for(; i<reverseString.length();i++)
		{
			if(reverseString.charAt(i) == ' ')
			{
				//reverse current word
				int currentWordEnd = i-1;
				String reverseWord = "";
				for(int j = currentWordEnd; j>= currentWordStart; j--)
				{
					reverseWord += reverseString.charAt(j);
				}

				//add to final string ans
				ans += 	reverseWord+ " ";
				currentWordStart = i+1;

			}
		}

		//reverse last word
		int currentWordEnd = i-1;
		String reverseWord = "";
		for(int j = currentWordEnd; j>= currentWordStart; j--)
		{
			reverseWord += reverseString.charAt(j);
		}
		ans += reverseWord;

	return ans;

	}
	public static void main(String args[]) {
	      String str="abc def ghi jkl";
	      System.out.println(reverseWordWise(str));
	} 


}
