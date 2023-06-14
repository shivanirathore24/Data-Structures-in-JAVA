package assignments;

import java.util.HashMap;

/*
 * You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
Note: Take absolute difference between the elements of the array.
Sample Input 1 :
5 1 2 4
3
Sample Output 1 :
2
Sample Input 2 :
4 4 4 4 
0
Sample Output 2 :
6
 */
public class PairsWithDifferenceK 
{
	/*
	 * Time Complexity: O(N)
	 * Space Complexity : O(N)
	 * where N is the size of input array
	 */
	public static int getPairsWithDifferenceK(int arr[], int k) 
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int pairCount = 0;
		for (int item : arr) 
		{
			int p1 = item + k;
			boolean flag = false;
			if (item == p1) 
			{
				flag = true; // this case is there for k=0
			}
			if (map.containsKey(p1))
			{
				pairCount += map.get(p1);
			}
			
			int p2 = item - k;
			if (map.containsKey(p2) && !flag) 
			{
				pairCount += map.get(p2);
			}
			if (map.containsKey(item)) 
			{
				map.put(item, map.get(item) + 1);
			} else
			{
				map.put(item, 1);
			}
		}
		return pairCount;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,-1, 3, 5, 6, 0, -1, 2, 6};
		int k = 3;
		System.out.println(getPairsWithDifferenceK(arr, k));
	}

}
