/*
 * For a given expression in the form of a string, find if there exist any redundant brackets or not. 
 * It is given that the expression contains only rounded brackets or parenthesis and the input expression
 * will always be balanced.A pair of the bracket is said to be redundant when a sub-expression is
 * surrounded by unnecessary or needless brackets.

 */


package assignments;

import java.util.Stack;

public class RedundantBracket {
	
	public static boolean checkRedundantBrackets(String expression)
	{
		Stack<Character> stk = new Stack<>();
		for( int i = 0; i < expression.length(); i++)
		{
			if(expression.charAt(i) == '(' || find(expression.charAt(i)))
			{
				stk.push(expression.charAt(i));
			}
			else if(expression.charAt(i) == ')')
			{
				boolean hasOperator = false;
				while(!stk.isEmpty() && stk.peek() != '(') 
				{
					stk.pop();
					hasOperator = true;
				}
				
				if(!hasOperator)
				{
					return true;  
				}
				if(!stk.isEmpty())
				{
					stk.pop();
				}
				
			} //end of elseif
		} //end of for loop
		return false;
	}
	
	private static boolean find(char ch)
	{
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str1 = "a+(b)+c";
		String str2 = "(a+b)";
		String str3 =  "(a+(b+c))";
		
		System.out.println(checkRedundantBrackets(str1));
		System.out.println(checkRedundantBrackets(str2));
		System.out.println(checkRedundantBrackets(str3));
	}
	

}
