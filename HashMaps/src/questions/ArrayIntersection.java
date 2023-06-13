package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. 
 * You need to print their intersection; An intersection for this problem can be defined when both the
 * arrays/lists contain a particular value or to put it in other words, 
 * when there is a common value that exists in both the arrays/lists.
Note :
Input arrays/lists can contain duplicate elements.
The intersection elements printed would be in ascending order.
 */
public class ArrayIntersection 
{
	public static void printIntersection(int[] arr1, int[] arr2) 
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr1.length; i++)
		{
			if(map.containsKey(arr1[i]))
			{
				int value = map.get(arr1[i]);
				map.put(arr1[i], value + 1);
			}
			else{
				map.put(arr1[i], 1);
			}
		}
		ArrayList<Integer> output = new ArrayList<>();
		for(int i = 0; i < arr2.length; i++)
		{
			if(map.containsKey(arr2[i]))
			{
				int freq = map.get(arr2[i]);
				if(freq > 0){
					output.add(arr2[i]);
					map.put(arr2[i], freq -1);
				}
			}
		}
		Collections.sort(output);
		for(int i:output){
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr1[] = {1, 4, 5, 2, 2, 3, 6, 5, 3, 2};
		int arr2[] = {0, 2, 3, 2, 6, 6, 5, 1};
		printIntersection(arr1, arr2);
	}
}
