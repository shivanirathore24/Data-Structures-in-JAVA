/*
 * For a given a string expression containing only round brackets or parentheses, check if they are 
 * balanced or not.Brackets are said to be balanced if the bracket which opens last, closes first.
Example:
Expression: (()())
Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence
the output will be, 'true'.You need to return a boolean value indicating whether the expression
is balanced or not
 */


package assignments;

import java.util.Stack;

public class BracketBalancedType1 {
	
	public static boolean isBalanced(String expression)
	{
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < expression.length(); i++)	
		{
 
			if( expression.charAt(i) == '(')
			{
				stack.push(expression.charAt(i));
			}
			else if ( expression.charAt(i) == ')')
			{
				if(stack.isEmpty()) {
					return false;
				}
				
				char topChar = stack.pop();
				if( expression.charAt(i) == ')' && topChar == '(')
				{
					continue;
				}
				else {
					return false;
				}
				
				
			}
		}
		
		return stack.isEmpty();
//		if(stack.isEmpty())
//		{
//			return true;
//		}
//		else {
//			return false;
//		}
	}
	
	public static void main(String[] args) {
		
		String str1 = "(()()())";
		String str2 = "()()(()";
		System.out.println(isBalanced(str1));
		System.out.println(isBalanced(str2));
	}

}
