package assignments;
/*
 * Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. 
 * The respective order of characters should remain same, as in the input string.
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde
 */
import java.util.HashMap;
public class ExtractUniqueCharacters 
{
	/*
	 * Time Complexity: O(N)
	 * Space Complexity : O(N)
	 * where N is the size of input string
	 */
	public static String uniqueChar(String str) 
	{
		if(str.length() == 0)
		{
			return "";
		}
		
		String ans = "";
		HashMap<Character, Boolean> hm = new HashMap<>();
		for( int i = 0; i < str.length(); i++)
		{
			char currChar = str.charAt(i);
			if(!hm.containsKey(currChar))
			{
				hm.put(currChar, true);
				ans += currChar;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String str = "ababacde";
		System.out.println(uniqueChar(str));
	}

	

}
