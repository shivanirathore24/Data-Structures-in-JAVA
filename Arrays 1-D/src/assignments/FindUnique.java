package arrays1;
/*
 You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].
Now, in the given array/list, 'M' numbers are present twice and one number is present only once.
You need to find and return that number which is unique in the array/list.
 */
public class FindUnique {
	public static int findUnique(int[] arr){
	for(int i =0; i<arr.length;i++)
	{
		int j;
		for( j =0;j<arr.length;j++)
		{
			if(i != j)
			{

			if(arr[i] ==arr[j])
				{
					break;
				}
			}
		}
		if(j == arr.length)
		{
		return arr[i];
		}
	}
	return Integer.MIN_VALUE;
	}
	public static void main(String[] args) {
		int [] arr = {6,6,2,5,8,8,5};
		System.out.println(findUnique(arr));
		
	}

}

