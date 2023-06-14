package assignments;

import java.util.HashMap;

/*
 * Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
Sample Input 1:
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 
 */
public class LongestSubArrayZeroSum 
{
	/*
	 * Time Complexity: O(N)
	 * Space Complexity : O(N)
	 * where N is the size of input array
	 */
	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) 
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		for(int i=1; i < n; i++)
		{
			arr[i] += arr[i-1];
		}
		int len = 0;
		for(int i = 0; i < n; i++)
		{
			if(arr[i] == 0)
			{
				if(len < i+1)
				{
					len = i+1;
				}
			}
			else if(map.containsKey(arr[i])) 
			{
				if(len < i - map.get(arr[i]))
				{
					len = i - map.get(arr[i]);
				}
			}
			else {
				map.put(arr[i], i);
			}
		}
		return len;
	}
	public static void main(String[] args) {
		int arr[] = {6, 3, -1, 2, -4, 3, 1, -2, 20};
		System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
	}

}
