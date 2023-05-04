package stack_collection;

import java.util.Stack;

public class StackCollections {
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();   //Stack class present in Collection framework of JAVA
		int arr[] = {7, 8, 2, 4, 9};
		for( int elem : arr)
		{
			stack.push(elem);
		}
		
		while(!stack.isEmpty())   //isEmpty() , size() inherits from Vector class
		{
			System.out.println(stack.pop());
		}
		
//		stack.push(10);
//		stack.push(20);
//		System.out.println(stack.size());
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.isEmpty());
		
	}

}
