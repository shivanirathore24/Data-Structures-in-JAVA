package assignments;
/*
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array.
But the order of elements should remain same as in the input array.
Sample Input :
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1
Note : The order of subsets are not important.
 */
public class ReturnSubsetsSumtoK 
{
	/*
	 * Time Complexity : O(2^N) where N is size of  input array.
	 * Since, for every index i, two recursive cases originate hence the time complexity is O(2^N).
	 */
	public static int[][] subsetsSumK(int input[], int k)
	{
		return subsetsSumKHelper(input, 0, k);
	}
	
	public static int[][] subsetsSumKHelper(int[] input, int startIndex, int k)
	{
		if(startIndex == input.length)
		{
			if(k == 0)
			{
				return new int[1][0];  // If k is 0, return an array with an empty subset
			}
			else {
				return new int[0][0];
			}
		}
		
		int[][] smallOutput1 = subsetsSumKHelper(input, startIndex+1, k);
		int[][] smallOutput2 = subsetsSumKHelper(input, startIndex+1, k - input[startIndex]);
		int index = 0;
		int[][] output = new int[smallOutput1.length + smallOutput2.length][];
		for(int i=0; i < smallOutput1.length; i++)
		{
			output[index++] = smallOutput1[i];
		}
		for(int i=0; i<smallOutput2.length; i++)
		{
			output[index] = new int[smallOutput2[i].length+1];
			output[index][0] = input[startIndex];
			for(int j=0; j <smallOutput2[i].length; j++)
			{
				output[index][j+1] = smallOutput2[i][j];
			}
			index++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17 };
		int k = 6;
		int output[][] = subsetsSumK(arr, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
			
	}
}

/*
Last nexted for loop:
1)It iterates through each subset in smallOutput2.

2)For each subset, a new array is created in output with a length of smallOutput2[i].length + 1. The additional length is for accommodating the current input[startIndex].

3)The value of input[startIndex] is assigned to the first element of the new array, output[index][0].

4)A nested loop iterates through the elements of the current subset smallOutput2[i].

5)The elements from smallOutput2[i] are assigned to the new array in output, starting from index 1 (output[index][j + 1] = smallOutput2[i][j]).

6)After assigning the elements, the index is incremented to move to the next position in output.


this nested loop combines the current element (input[startIndex]) with each subset in smallOutput2, creating new subsets that include the current element. These subsets are added to the output array to be returned as the final result.
 */
