package maxPriorityQueue;
/*
Code : Max Priority Queue
Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.
SampleInput1:
1 3 1 4 1 63 1 21 1 9 2 3 1 7 2 3 2 -1
SampleOutput1:
63
63
21
21
9
SampleInput2:
1 3 1 4 1 63 1 21 1 9 2 3 1 7 3 4 5 -1
SampleOutput2:
63
63
21
4
false

 */

import java.util.ArrayList;

public class PQ 
{
	private ArrayList<Integer> heap;
	
	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() 
	{
		return heap.size() == 0;
	}

	int getSize() {
		return heap.size();
	}

	int getMax() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) > heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMax()
	 {
		if(isEmpty())
		{
			return Integer.MIN_VALUE;
		}
		int ans =  heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentIndex = 0;
		int leftChildIndex= 2*parentIndex + 1;
		int rightChildIndex = 2*parentIndex + 2;
		
		while(leftChildIndex < heap.size())
		{
			int maxIndex = parentIndex;
			if(heap.get(leftChildIndex) > heap.get(maxIndex))
			{
				maxIndex = leftChildIndex;
			}
			
			if(rightChildIndex < heap.size() && (heap.get(rightChildIndex) > heap.get(maxIndex)))
			{	
				maxIndex = rightChildIndex;
			}
			
			if(maxIndex == parentIndex)
			{
				break;
			}
			
			int temp = heap.get(maxIndex);
			heap.set(maxIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex = maxIndex;
			leftChildIndex = 2*parentIndex + 1;
			rightChildIndex = 2*parentIndex + 2;	
		}
		return ans;
	}	
}