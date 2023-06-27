package assignments;
/*
Print Subset Sum to K
Given an array A and an integer K, print all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print them in different lines.
 */
public class PrintSubsetsSumToK 
{
	/*
	Time Complexity: O(2^N), where N is the size of the input array. Since, for every index i, two
	recursive cases originate, hence the time complexity is O(2^N).
	 */
	public static void printSubsetsSumToK(int input[], int k)
	{
		int[] output = new int[0];
		printSubsetsSumToKHelper(input, 0, output, k);
	}
	public static void printSubsetsSumToKHelper(int[] input, int beginIndex, int[] output, int k) 
	{
		if(beginIndex == input.length)
		{
			if(k == 0)
			{
				for(int i : output)
				{
					System.out.print(i+" ");
				}
				System.out.println();
				return;
			}
			else {
				return;
			}
		}
		
		int[] newOutput = new int[output.length + 1];
		int i =0;
		for(; i<output.length;i++)
		{
			newOutput[i] = output[i];
		}
		newOutput[i] = input[beginIndex];
		printSubsetsSumToKHelper(input, beginIndex+1, output, k);
		printSubsetsSumToKHelper(input, beginIndex+1, newOutput, k- input[beginIndex]);
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17 };
		int k = 6;
		printSubsetsSumToK(arr, k);
	}

}
