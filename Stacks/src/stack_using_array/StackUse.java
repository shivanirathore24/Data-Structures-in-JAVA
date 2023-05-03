package stack_using_array;

public class StackUse {
	
	public static void main(String[] args) throws StackFullException, StackEmptyException {
		//StackUsingArray stack = new StackUsingArray();
		StackUsingArray stack = new StackUsingArray(40);  //user is adding size of stack
		
		int arr [] = {7, 8, 5, 4, 6};
		for(int i =0; i<arr.length; i++)
		{
			stack.push(arr[i]);  //pushing element in  stack
		}
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		
		try {            //here we are handling exception
			stack.top();
		}
		catch(StackEmptyException e)
		{
			System.out.println("Stack is empty, so can't return topmost Element !");
		}
		
		stack.pop();  //we are propogating exception to main using thrpws
		
//		stack.push(10);
//		System.out.println(stack.top());
//		stack.pop();
//		System.out.println(stack.size());
//		System.out.println(stack.isEmpty());
		
		
	}

}
