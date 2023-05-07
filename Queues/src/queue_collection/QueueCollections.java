package queue_collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {
	public static void main(String[] args) {
		
		//Queue is an interface in collection framework, which is implemented by LinkedList class
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);  //adding element
		queue.add(20);
		queue.add(30);   // in Queue : 10-->20-->30
		System.out.println(queue.size());       //present in Collection interface
		System.out.println(queue.isEmpty());    //present in Collection interface
		System.out.println(queue.remove());     //throws exception "NoSuchElementException" if queue is empty
		System.out.println(queue.poll());       // same as remove() but returns "null" if queue is empty
		System.out.println(queue.peek());       // returns null if queue is empty
		System.out.println(queue.element());    // same as peek() but returns throws exception "NoSuchElementException" if queue is empty
		
	}

}
