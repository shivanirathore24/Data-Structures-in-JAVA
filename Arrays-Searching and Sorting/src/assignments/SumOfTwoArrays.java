package assignments;
/*Two random integer arrays/lists have been given as ARR1 and ARR2 of size N and M respectively.
Both the arrays/lists contain numbers from 0 to 9(i.e. single digit integer is present at every index).
The idea here is to represent each array/list as an integer in itself of digits N and M.
You need to find the sum of both the input arrays/list treating them as two integers and put the result
in another array/list i.e. output array/list will also contain only single digit at every index.*/

public class SumOfTwoArrays {
	
	public static void printArray(int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			System.out.print(arr[i]);
		}
	}
	
	
	public static void sumOfTwoArrays(int [] arr1, int [] arr2, int [] output)
	{
		int i = arr1.length -1;
		int j = arr2.length - 1;
		int k = Math.max(arr1.length, arr2.length);
		int carry = 0;
		
		while(i>= 0 && j >= 0)
		{
			int sum = arr1[i] + arr2[j] + carry;
			output[k] = sum % 10;
			carry = sum / 10;
			i--;
			j--;
			k--;	
		}
		while(i >=0)
		{
			int sum = arr1[i]  + carry;
			output[k] = sum % 10;
			carry = sum / 10;
			i--;
			k--;	
		}
		while(j >= 0)
		{
			int sum = arr2[j] + carry;
			output[k] = sum % 10;
			carry = sum / 10;
			j--;
			k--;
		}
		output[0] = carry;
	}
	
	
	public static void main(String[] args) {
		int arr1[] = { 9, 9, 9, 1, 3, 4};
		int arr2[] = {2, 0, 6, 6};
		int output[] = new int[1+ Math.max(arr1.length, arr2.length)];
		sumOfTwoArrays(arr1,arr2,output);
		printArray(output);
		
		
	}

}
