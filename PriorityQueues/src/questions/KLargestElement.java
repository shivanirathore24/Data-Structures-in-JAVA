package questions;
/*
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).
 */
import java.util.ArrayList;
/*
 * You are given with an integer k and an array of integers that contain numbers in random order. 
 * Write a program to find k largest numbers from given array. You need to save them in an array and 
 * return it.Time complexity should be O(nlogk) and space complexity should be not more than O(k)
 */
import java.util.PriorityQueue;
public class KLargestElement 
{
	public static void printKLargest1(int[] arr, int k) 
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for( int i=0; i<k; i++)
		{
			pq.add(arr[i]);
		}
		//System.out.println(pq);
		for(int i=k; i< arr.length; i++)
		{
			if(pq.peek() < arr[i])
			{
				pq.poll();
				pq.add(arr[i]);
			}
		}
		
		//printing 
		while(!pq.isEmpty())
		{
			System.out.println(pq.poll());
		}
	}
	
	public static ArrayList<Integer> printKLargest2(int[] arr, int k) 
	{
		ArrayList<Integer> output = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for( int i=0; i<k; i++)
		{
			pq.add(arr[i]);
		}
		//System.out.println(pq);
		for(int i=k; i< arr.length; i++)
		{
			if(pq.peek() < arr[i])
			{
				pq.poll();
				pq.add(arr[i]);
			}
		}
		while(!pq.isEmpty())
		{
			output.add(pq.poll());
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 1, 6, 3, 7, 2, 9, 8};
		int k = 3;
		//printKLargest1(arr,k);
		
		ArrayList<Integer> output = printKLargest2(arr, k);
		for( int i : output)
		{
			System.out.println(i);
		}
	}
}
