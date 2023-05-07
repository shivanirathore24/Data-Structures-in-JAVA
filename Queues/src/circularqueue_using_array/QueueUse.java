package circularqueue_using_array;

public class QueueUse {

	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		CircularQueueUsingArray queue = new CircularQueueUsingArray();
		int curr[] = {10, 20, 30, 40, 50};
		for(int elem : curr)
		{
			queue.enqueue(elem);
		}
		
		System.out.println("Size :"+ queue.size());
		System.out.println("Is Empty ? "+queue.isEmpty());
		System.out.println("First element in Queue : "+queue.front());
		
		//deleting two element  - 10,20
		queue.dequeue();
		queue.dequeue();
//		while(!queue.isEmpty())
//		{
//			try {
//				System.out.println(queue.dequeue());
//			} catch (QueueEmptyException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		System.out.println("Size :"+queue.size());  //size became 3 after deleting two element space is available , we can utilize it
		queue.enqueue(60);  // will show error as rear is pointing to data.length -- array bound of index
		queue.enqueue(70);
		System.out.println(queue.front());
		System.out.println("Size :"+queue.size());
		
		
		

	}

}
