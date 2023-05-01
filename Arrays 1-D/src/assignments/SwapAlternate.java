package arrays1;

/*
 You have been given an array/list(ARR) of size N. You need to swap every pair of alternate elements in the array/list.
You don't need to print or return anything, just change in the input array itself.
 */

public class SwapAlternate {
	
	public static void swapAlternate(int arr[]) {
        int len = arr.length;

        for( int i = 0; i < len-1; i += 2)
        {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }
	
	public static void printArray(int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2,4,7,1,8,5};
		swapAlternate(arr);
		printArray(arr);
	}

}
