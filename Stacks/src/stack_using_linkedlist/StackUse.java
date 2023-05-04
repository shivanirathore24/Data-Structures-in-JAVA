package stack_using_linkedlist;

public class StackUse {
	
	public static void main(String[] args) throws  StackEmptyException
	{
		StackUsingLL<String> stack1 = new StackUsingLL<String>();
		String arr1 [] = {"MS DHoni", "Neeraj Chopra", "Shivani Rathore"};
		System.out.println("Push Operation : ");
		for(int i =0; i<arr1.length; i++)
		{
			stack1.push(arr1[i]);  //pushing element in  stack
		}
		System.out.println();
		System.out.println("Pop Operation :");
		while(!stack1.isEmpty())
		{
			System.out.println(stack1.pop());
		}
		
		System.out.println();
		
		StackUsingLL<Integer> stack = new StackUsingLL<Integer>();
		int arr [] = {7, 8, 5, 4, 6};
		System.out.println("Push Operation : ");
		for(int i =0; i<arr.length; i++)
		{
			stack.push(arr[i]); //pushing element in  stack
		}
		System.out.println("Pop Operation :");
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		
		
//		try {            //here we are handling exception
//			stack.top();
//		}
//		catch(StackEmptyException e)
//		{
//			System.out.println("Stack is empty, so can't return topmost Element !");
//		}
//		
//		stack.pop();  //we are propogating exception to main using throws
//		
		
//		stack.push(10);
//		System.out.println(stack.top());
//		stack.pop();
//		System.out.println(stack.size());
//		System.out.println(stack.isEmpty());
		
		
	}

}
