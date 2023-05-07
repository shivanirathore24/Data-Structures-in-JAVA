package circularqueue_using_array;

public class CircularQueueUsingArray {
	
	private int[] data;
	private int front;
	private int rear;
	private int size;
	
	public CircularQueueUsingArray()
	{
		data = new int[10];
		front = -1;
		rear = -1;
	}
	
	public CircularQueueUsingArray(int capacity)
	{
		data = new int[capacity];
		front = -1;
		rear = -1;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void enqueue(int elem) throws QueueFullException
	{
		if( size == data.length)
		{
			throw new QueueFullException();
		}
		if(size == 0)
		{
			front = 0; //front++;
		}
//		rear++;
//		if(rear == data.length)
//		{
//			rear = 0;
//		}
		rear = (rear + 1) % data.length;
		data[rear] = elem;
		size++;
	}
	
	public int front() throws QueueEmptyException 
	{
		if(size == 0)
		{
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	public int dequeue() throws QueueEmptyException
	{
		if(size == 0)
		{
			throw new QueueEmptyException();
		}
		int temp = data[front];
//		front++;
//		if(front == data.length)
//		{
//			front = 0;
//		}
		front = (front + 1)% data.length;
		size --;
		if(size == 0)
		{
			front = -1;
			rear = -1;
		}
		return temp;
	}

}
