package assignments;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
	
	public static void reverseQueue(Queue<Integer> input)
	{
		if(input.size() <= 1)
		{
			return;
		}
		
		int front = input.poll();
		reverseQueue(input);
		input.add(front);
		
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		reverseQueue(queue);
		
		//you can verify element is reversed, as after reverse first element to be removed will be 40 
		while(!queue.isEmpty())
		{
			System.out.println(queue.poll());
		}

	}

}
