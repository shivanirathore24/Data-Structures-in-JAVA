package questions;

public class PrintMinimumInArray
{
	//way-1
	public static void printMin1(int[] arr)
	{
		int min = findMin(arr, 0);
		System.out.println(min);
	}
	
	public static int findMin(int[] input, int startIndex)
	{
		if(startIndex == input.length)
		{
			return Integer.MAX_VALUE;
		}
		
		int minSmallArray = findMin(input, startIndex + 1);
		if(input[startIndex] < minSmallArray)
		{
			return input[startIndex];
		}
		else {
			return minSmallArray;
		}	
	}
	
	public static void printMin2(int[] arr, int startIndex, int minimum)
	{
		if(startIndex == arr.length)
		{
			System.out.println(minimum);
			return;
		}
		
		int newMinimum = minimum;
		if(arr[startIndex] < minimum)
		{
			newMinimum = arr[startIndex];
		}
		printMin2(arr, startIndex + 1, newMinimum);
	}
	
	public static void main(String[] args) {
		int arr[] = {3, 4, 2, 1, 7, 8};
		printMin1(arr);
		printMin2(arr, 0, Integer.MAX_VALUE);
	}
}
