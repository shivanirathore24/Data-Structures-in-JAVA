package assignments;
//You have been given a random integer array/list(ARR) of size N. Write a function that rotates the given array/list by D elements(towards the left).
public class RotateArray {
	
	public static void printArray(int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void rotateArray(int [] arr,int d)
	{
		int temp[] = new int[d];
		for(int i = 0; i<d; i++)
		{
			temp[i] = arr[i];
		}
		
		for(int i = d; i< arr.length;  i++)
		{
			arr[i-d] = arr[i];
		}
		
		for(int i = 0; i<d; i++)
		{
			arr[arr.length -d +i] = temp [i];
		}
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		int d = 2;
		rotateArray(arr,d);
		printArray(arr);
	}
	
	

}
