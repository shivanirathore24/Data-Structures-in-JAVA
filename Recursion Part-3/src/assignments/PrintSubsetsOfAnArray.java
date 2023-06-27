package assignments;
/*
You are given an sorted integer array of size 'n'.
Your task is to find and return all the unique subsets of the input array.
Subsets are arrays of length varying from 0 to 'n', that contain elements of the array. 
But the order of elements should remain the same as in the input array.
Sample Input 1 :
12 15 20
Sample Output 1 :
[] (this represents an empty array)
12 
12 15 
12 15 20 
12 20 
15 
15 20 
20 
Explanation Of Sample Input 1 :
Since there are no repeated numbers, 8 subsets are generated.
Sample Input 2 :
3
1 1 2
Sample Output 2 :
[]    
1 
1 1 
1 1 2 
1 2 
2 
Explanation Of Sample Input 2 :
Since there are repeated numbers, the total number of unique subsets is 6.

Expected Time Complexity :
The expected time complexity is O(k * 2^n), where n is the size of the array and 'k' is the average size of a subset.
Expected Space Complexity :
The expected time complexity is O(k * 2^n), where n is the size of the array and 'k' is the average size of a subset.
 */

public class PrintSubsetsOfAnArray 
{
	public static void printSubsetsArray(int input[])
	{
		int output[] = new int[0];
		printSubsetsArrayHelper(input, 0, output);
	}
	
	public static void printSubsetsArrayHelper(int input[] , int beginIndex, int[] output)
	{
		if(beginIndex == input.length)
		{   //print
			for(int i : output)
			{
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		int[] newOutput = new int[output.length+1];
		int i =0;
		for(; i < output.length; i++)
		{
			newOutput[i] = output[i];
		}
		newOutput[i] = input[beginIndex];
//		int k=0;
//		for(int i =0; i < output.length; i++)
//		{
//			newOutput[k] = output[i];
//			k++;
//		}
//		newOutput[k] = input[beginIndex];
		
		printSubsetsArrayHelper(input, beginIndex+1 , output);
		printSubsetsArrayHelper(input,beginIndex+1, newOutput);
	}
	
	public static void main(String[] args) {
		int arr[] = {15, 20, 12};
		printSubsetsArray(arr);	
	}
}
