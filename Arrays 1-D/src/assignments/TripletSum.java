package arrays1;

//You have been given a random integer array/list(ARR) and a number X. Find and return the number of triplets in the array/list which sum to X.
public class TripletSum {
	
	public static int findTriplet(int[] arr, int x) 
	{
		int n = arr.length;
		int sum = 0;
		int count = 0;
		
		for(int i =0; i<n; i++)
		{
			for( int j = i+1; j<n; j++)
			{
				for(int k = j+1; k<n; k++)
				{
					if(x == arr[i]+ arr[j] + arr[k])
					{
						count++;
					}
				}
			}
		}
		return count;
	}
		
	public static void main(String[] args) {
		int arr[] = {1,5,4,7,9,6,2,1,4,5};
		int x = 10;
		int count = findTriplet(arr,x);
		System.out.println(count);
	}
	

}
