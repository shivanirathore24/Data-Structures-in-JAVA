package assignments;

import java.util.Stack;

public class BracketBalancedType2 {
	
	public static boolean isBalanced(String expression)
	{
		Stack<Character> stack = new Stack<>();  // present in collections
		for(int i = 0; i < expression.length(); i++)
		{
			char currChar = expression.charAt(i);
			if( currChar == '[' || currChar == '{' || currChar == '(')
			{
				stack.push(currChar);
			}
			else if (currChar == ']' || currChar == '}' || currChar == ')')
			{
				if(stack.isEmpty())
				{
					return false;
				}
				else {
					char topChar = stack.pop();
					if(currChar == ')'&& topChar == '(' || currChar == '}'&& topChar == '{' || currChar == ']'&& topChar == '[')
					{
						continue;
					}
					else
					{
						return false;
					}
				}
			} //end of else-if
		} //end of for loop
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String str1 = "[{(a+b)+c*d}+(e+f)]";
		String str2 = "[{a+b)}";
		String str3 =  "(a+b)}";
		
		System.out.println(isBalanced(str1));
		System.out.println(isBalanced(str2));
		System.out.println(isBalanced(str3));
	}

}
