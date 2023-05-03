package double_stack_capacity;

public class StackUsingArray {
	
	private int data[];
	private int topIndex;
	
	public StackUsingArray()  //deafult constructor
	{
		data = new int[10];
		topIndex = -1;
	}
	
	public StackUsingArray(int size)
	{
		data = new int[size];
		topIndex = -1;
	}

	public int size()       //O(1)    
	{
		return topIndex + 1;
	}
	
	public boolean isEmpty()      //O(1) 
	{
//		if(topIndex == -1)
//		{
//			return true;
//		}else {
//			return false;
//		}
		return topIndex == -1;
	}
	
	public void push( int elem)     //O(1) 
	{ //if stack is full  -- case
		if( topIndex == data.length-1)
		{ 
			doubleCapacity();
		}
		
//		topIndex++;
//		data[topIndex] = elem;
		data[++topIndex] = elem;
	}
	
	private void doubleCapacity()
	{
		System.out.println("Size of stack before Doubling Capacity:"+ data.length);
		int temp[] = data;
		data = new int[2 *temp.length];	 
		for( int i = 0; i < temp.length; i++)
		{
			data[i] = temp[i];
		}
		System.out.println("Size of stack before after Capacity:"+ data.length);
	}
	
	public int top() throws StackEmptyException     //O(1) 
	{ // if stack is empty  --case
		if(topIndex == -1)
		{
			throw new StackEmptyException();
		} 
		return data[topIndex];
	}
	
	public int pop() throws StackEmptyException    //O(1) 
	{// if stack is empty  --case
		if(topIndex == -1)
		{
			throw new StackEmptyException();
		}		
//		int temp = data[topIndex];
//		topIndex--;
		int temp = data[topIndex--];
		return temp; // return deleted element
		
	}
	
	
	

}
