package questions;
/*
You are given with an integer k and an array of integers that contain numbers in random order. 
Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(n * logk) and space complexity should not be more than O(k).
Note: Order of elements in the output is not important.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElement 
{
	public static ArrayList<Integer> printKSmallest(int n, int[] arr, int k) 
	{
		//making a MaxPQ
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for( int i=0; i<k; i++)
		{
			pq.add(arr[i]);
		}
		//System.out.println(pq);
		for(int i=k; i< n; i++)
		{
			
			if(pq.peek() > arr[i])
			{
				pq.poll();
				pq.add(arr[i]);
			}
		}
		
		ArrayList<Integer> output = new ArrayList<>();
		while(!pq.isEmpty())
		{
			output.add(pq.poll());
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 1, 6, 3, 7, 2, 9, 8};
		int k = 3;
		
		ArrayList<Integer> output = printKSmallest(arr.length, arr, k);
		for( int i : output)
		{
			System.out.println(i);
		}
		
	}

}
