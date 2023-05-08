package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementQueue {
	
	public static Queue<Integer> reverseKElementQueue(Queue<Integer> queue , int k)
	{
		if(queue.isEmpty() || k > queue.size())
		{
			return queue;
		}
		
		if( k <= 0)
		{
			return queue;
		}
		
		Stack<Integer> stack = new Stack<>(); //using stack to reverse all element
		for( int i = 0; i < k; i++)
		{
			stack.push(queue.poll());
		}
		
		while(!stack.isEmpty())
		{
			queue.add(stack.pop());
		}
		
		for( int i = 0; i < queue.size()-k; i++)
		{
			queue.add(queue.poll());
		}
		return queue;
	}
	
	public static void main(String[] args) {
		int k = 3;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		System.out.println(reverseKElementQueue(queue, k));

	}

}
