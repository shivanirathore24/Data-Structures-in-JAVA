package assignments;
/*Given an array of length N, you need to find and return the sum of all elements of the array.
Do this recursively.*/

public class SumOfArray1 {
		public static int sum(int input[]) {
			if(input.length == 1)
			{
				return input[0];
			}

			int smallArray[] = new int[input.length-1];
			for(int i =1; i<input.length;i++)
			{
				smallArray[i-1] = input[i];
			}

			int smallOutput = sum(smallArray);

			return input[0] + smallOutput;
			
		}
	public static void main(String[] args) {
		int arr[] = {7,4,9,11,-3};
		System.out.println(sum(arr));
	}

}
