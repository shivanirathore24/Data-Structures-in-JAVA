package assignments;
/*You are given an integer array/list(ARR) of size N. It contains only 0s, 1s and 2s. 
 Write a solution to sort this array/list in a 'single scan'.
'Single Scan' refers to iterating over the array/list just once or to put it in other words, 
you will be visiting each element in the array/list just once.*/

public class SortZeroOneTwo {
	
	
	public static void printArray(int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

	
	public static void sort012(int[] arr)
	{
		int nextZero = 0;
		int i = 0;
		int nextTwo = arr.length -1;
		
		while(i <= nextTwo)
		{
			if(arr[i] == 0)
			{
				int temp = arr[i];
				arr[i] = arr[nextZero];
				arr[nextZero] = temp;
				i++;
				nextZero++;
			}
			else if ( arr[i] == 2)
			{
				int temp = arr[i];
				arr[i] = arr[nextTwo];
				arr[nextTwo] = temp;
				nextTwo--;
			}
			else {
				// if arr[i] == 1
				i++;
			}
			
		}
	}
	
	public static void main(String[] args) {
		int arr [] = { 0, 1, 2, 0, 2, 0, 1};
		sort012(arr);
		printArray(arr);
	}

}
