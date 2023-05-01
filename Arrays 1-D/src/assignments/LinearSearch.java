package arrays1;

/*
 You have been given a random integer array/list(ARR) of size N, and an integer X. You need to search for the integer X in the given array/list using 'Linear Search'.
 You have been required to return the index at which X is present in the array/list. If X has multiple occurrences in the array/list, then you need to return the index at which the first occurrence of X would be encountered. In case X is not present in the array/list, then return -1.
 */
public class LinearSearch {
	
		public static int linearSearch(int arr[], int x) 
		{
	    int n = arr.length;
	    for(int i =0; i < arr.length; i++)
	    {
	      if(x == arr[i])
	      {
	        return i;
	      }
	    }
	    return -1;
	    }
	
		public static void main(String[] args) {
			
			int arr[] = { 1,6,7,8,3,9,5};
			int arr1[] = { 4,6,8};
			int x = 3;
			System.out.println(linearSearch(arr,x));
			System.out.println(linearSearch(arr1,x));
		}

}
