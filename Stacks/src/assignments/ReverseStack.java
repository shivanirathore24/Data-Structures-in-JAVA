package assignments;

import java.util.Stack;

public class ReverseStack {
	
	public static void reverse(Stack<Integer> stack)
	{
		Stack<Integer> helper = new Stack<>();
		while(!stack.isEmpty())
		{
			helper.push(stack.pop());
		}
		//System.out.println(helper);
		stack.addAll(helper);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int arr[] = {7, 8, 2, 4, 9};
		for( int elem : arr)
		{
			stack.push(elem);
		}
		System.out.println("Stack before reverse: "+stack);
		
		reverse(stack);
		System.out.println("Stack after reverse: "+stack);
	
	}

}
