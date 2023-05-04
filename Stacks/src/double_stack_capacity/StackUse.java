package double_stack_capacity;

public class StackUse {
	
	public static void main(String[] args) throws StackEmptyException {
		//StackUsingArray stack = new StackUsingArray();
		StackUsingArray stack = new StackUsingArray(6);  //user is adding size of stack
		
		int arr [] = {7, 8, 5, 4, 6};
		for(int i =0; i<arr.length; i++)
		{
			stack.push(arr[i]);  //pushing element in  stack
			System.out.println(arr[i]);
		}
		System.out.println("No.of elements in stack:"+stack.size());
//		while(!stack.isEmpty())
//		{
//			System.out.println(stack.pop());
//		}
		
	}

}
