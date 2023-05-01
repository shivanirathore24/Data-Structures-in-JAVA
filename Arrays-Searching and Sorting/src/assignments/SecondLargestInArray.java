package assignments;

public class SecondLargestInArray {
	
	public static int secondLargestElement(int [] arr)
	{
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		if(arr.length == 0)
		{
			return Integer.MIN_VALUE;
		}
		
		for(int i =1; i< arr.length; i++)
		{
			if(arr[i]>largest)
			{
				secondLargest = largest;
				largest = arr[i];
			}
			else if (arr[i] < largest && arr[i]> secondLargest)  //or else if (arr[i] > secondLargest && arr[i] != largest)
			{
				secondLargest = arr[i];
			}
		}
		return secondLargest;	
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 3, 5, 6, 1, 10, 7 ,24, 25, 18};
		int secondLargest  =  secondLargestElement(arr);
		System.out.println(secondLargest);
	}

}
