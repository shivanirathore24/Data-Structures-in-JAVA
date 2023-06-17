package inBuild_PriorityQueue;

import java.util.PriorityQueue;

/*Bydefault : minPriorityQueue , Internally implemented as minHeap
 * Heap : should be Complete Binary Tree (CBT)
 *		: should maintain Heap-Order Property
 * Heap-Order Property: 
 * For MinHeap : every node's priority should be lesser than child's priority.
 * For MaxHeap : every node's priority should be greater than child's priority.
 */

public class InBuildPQ 
{
	public static void main(String[] args) {
		int arr[] = {4, 3, 7, 6, 9, 10, 1, 2};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<arr.length; i++)
		{
			pq.add(arr[i]);
		}
		System.out.println(pq);
		//System.out.println(pq.peek());
		
		while(!pq.isEmpty())
		{
			System.out.println(pq.peek());
			pq.poll();
		}
		
	}

}
