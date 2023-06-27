package assignments;
/*
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Sample Input:
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 
 */
public class ReturnSubsetOfAnArray 
{
	
	//Time Complexity : O(2^N) where N is size of  input array.
	public static int[][] subsetsArray(int[] input)
	{
		return subsetsArrayHelper(input,0);
	}
	
	public static int[][] subsetsArrayHelper(int[] input, int startIndex)
	{
		if(startIndex == input.length)
		{
			int[][] output = new int[1][0];
			return output;
		}
		
		int[][] smallerOutput = subsetsArrayHelper(input, startIndex+1);
		int[][] output = new int[2*smallerOutput.length][];
		
		int k = 0;
		for(int i = 0; i < smallerOutput.length; i++)
		{
			output[k] = new int[smallerOutput[i].length];
			for(int j =0; j< smallerOutput[i].length; j++)
			{
				output[k][j] = smallerOutput[i][j];
			}
			k++;
		}
		
		for(int i=0; i< smallerOutput.length; i++)
		{
			output[k] = new int[smallerOutput[i].length+1];
			output[k][0] = input[startIndex];
			for(int j =1; j <= smallerOutput[i].length; j++)
			{
				output[k][j] = smallerOutput[i][j-1];
			}
			k++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		int arr[] = {15, 20, 12};
		int output[][] = subsetsArray(arr);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
