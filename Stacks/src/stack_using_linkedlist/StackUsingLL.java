package stack_using_linkedlist;

public class StackUsingLL<T> {
	
	private LinkedListNode<T> head;
	private int size;
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		if( size == 0)
			return true;
		else
			return false;
		//return size == 0;
	}
	
	//push operation is happening at beginning of the LinkedList   -- O(1)
	public void push(T elem)
	{
		LinkedListNode<T> newNode = new LinkedListNode<T>(elem);
		newNode.next = head;  // this will handle case : if head == null
		head = newNode;
		size++;	
		System.out.println(head.data);
	}
	
	//push operation is happening at beginning of the LinkedList , so return first node data  
	public T top() throws StackEmptyException   //O(1)
	{
		if( head == null)
		{
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	public T pop() throws StackEmptyException  //O(1)
	{
		if( head == null)
		{
			throw new StackEmptyException();
		}
		//as we are pushing data from front, so remove it from front 
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	
	
	

}
