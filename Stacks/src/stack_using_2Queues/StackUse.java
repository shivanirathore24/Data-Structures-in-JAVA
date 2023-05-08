package stack_using_2Queues;



public class StackUse {
	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		System.out.println(stack);
		System.out.println(stack.pop());  //removes last element
		System.out.println(stack.size());
		System.out.println(stack.top());
		System.out.println();
	}

}
