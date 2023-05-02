package assignments;

/*Given the number 'n', write a code to print numbers from 1 to n in increasing order recursively.*/

public class SumOfArrayBetterApproach {
	
	public static int sum(int input[], int si)
	{
		if(si == input.length)
		{
			return 0;
		}
		int smallOutput = sum(input, si+1);
		return input[si] + smallOutput;
	}
	
	public static void main(String[] args) {
		int arr[] = {7,4,9,11,-3};
		System.out.println(sum(arr,0));
	}

}
