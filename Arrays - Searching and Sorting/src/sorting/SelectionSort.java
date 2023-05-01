package sorting;

public class SelectionSort {
	
	public static void selectionSort(int [] arr)
	{
		
		int n = arr.length;
		for ( int i =0; i < n-1; i++)
		{
			//Insert element at ith position
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			for(int j=i; j<n; j++)
			{ //finding minimum element among j position
				
				if( arr[j] < min)
				{
					min = arr[j];
					min_index = j;
				}
			}
			////swap element at min_index with ith element
			int temp = arr [i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
			
		}
	}
	
	public static void printArray( int [] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,6,4,8,0,3};
		selectionSort(arr);
		printArray(arr);
		
		
		
	}

}
