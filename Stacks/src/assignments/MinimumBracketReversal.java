/*
 * For a given expression in the form of a string, find the minimum number of brackets that can be reversed
 * in order to make the expression balanced. The expression will only contain curly brackets.
If the expression can't be balanced, return -1.
Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get balanced.
 Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket
 and hence will not be able to make the expression balanced and the output will be -1.
 */


package assignments;

import java.util.Stack;

public class MinimumBracketReversal {
	
	public static int countBracketReversals(String input) {
		// Only even number of bracket can be balanced
		if (input.length() % 2 != 0) {
			return -1;
		}
		
		Stack<Character> stack = new Stack<Character>();
	
		for (int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			if (c == '{')   //opening bracket always push
			{
				stack.push(c);
			} 
			else 
			{
				if(!stack.isEmpty() && stack.peek() == '{')
				{
					stack.pop();
				}
				else {
					stack.push(c);
				}
				
				//or
//				if (stack.isEmpty()) {  
//					stack.push(c);
//				} else if (stack.peek() == '}') {
//					stack.push(c);
//				} else if (stack.peek() == '{') {
//					stack.pop();
//				}
				
			}
		}

		int count = 0;
		
		//only unbalanced brackets are there now
		while (!stack.isEmpty()) {
			char c1 = stack.pop();
			char c2 = stack.pop();
			
			//when c2 == '}' and c1 == '{' , then we need to reverse both of them , so count will be increase by 2.
			if (c1 != c2) {
				count += 2;
			} else {
				// c1 == c2 
				//eg: c1 == '{' and c2 == '{' we need to reverse only c1 so increase by 1.
				// c1 == '}' and c2 == '}' we need to reverse only c2 so increase by 1.
				count += 1;  
			}
		}
		return count;

	}

	public static void main(String[] args) {
		
		String str1 = "}{";
		String str2 = "{{";
		String str3 = "{{{}}{{";
		String str4 = "}}}{{{";
		
		System.out.println(countBracketReversals(str1));
		System.out.println(countBracketReversals(str2));
		System.out.println(countBracketReversals(str3));
		System.out.println(countBracketReversals(str4));
		
		
		
		
	}

}
