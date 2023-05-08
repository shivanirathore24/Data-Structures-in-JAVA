package stack_using_2Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	private Queue<Integer> q1;   //Queue from CollectionFramework
	private Queue<Integer> q2;
	private int size;
	
	public StackUsingQueue()
	{
		q1 = new LinkedList<>();   //as Queue is interface so it implements LinkedList class
		q2 = new LinkedList<>();
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void push(int element)
	{
		q1.add(element);
		size++;
	}
	
	public int pop()
	{
		if(q1.isEmpty())
		{
			return -1;
		}
		
		while(q1.size() > 1)
		{
			q2.add(q1.poll());  // or you can use remove()
		}
		
		int ans = q1.poll();
		while(!q2.isEmpty())
		{
			q1.add(q2.poll());
		}
		size--;
		return ans;
	}
	
	public int top()
	{
		if(q1.isEmpty())
		{
			return -1;
		}
		while(q1.size() > 1)
		{
			q2.add(q1.poll());
		}
		int ans = q1.poll();
		q2.add(ans);
		
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
	return ans;
	}
}
