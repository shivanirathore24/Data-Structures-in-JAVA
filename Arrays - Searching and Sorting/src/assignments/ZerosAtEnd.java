package assignments;

//You have been given a random integer array/list(ARR) of size N. You have been required to push all the zeros that are present in the array/list to the end of it. Also, make sure to maintain the relative order of the non-zero elements.
public class ZerosAtEnd {
	
	public static void pushZerosAtEnd(int [] arr)
	{
		int nonZero = 0;
		
		for(int i =0; i< arr.length; i++)
		{
			if(arr[i] != 0)
			{
				int temp = arr[i];
				arr[i] = arr[nonZero];
				arr[nonZero] = temp;
				nonZero++;
			}
		}
		
	}
	
	public static void printArray(int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,0,4,5,6,0,0,4,0,1};
		pushZerosAtEnd(arr);
		printArray(arr);
	}

}
