package queue_using_linkedlist;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException {
	
		QueueUsingLL<Integer> queue = new QueueUsingLL<>();
		int curr[] = {10, 20, 30, 40, 50, 60 , 70};
		for(int elem : curr)
		{
			queue.enqueue(elem);
		}
		
		while(!queue.isEmpty())
		{
			System.out.println(queue.dequeue());
		}
	}

}
