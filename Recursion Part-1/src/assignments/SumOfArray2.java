package assignments;

/*Given the number 'n', write a code to print numbers from 1 to n in increasing order recursively.*/

public class SumOfArray2 {
	public static int sum(int input[]) {
		int n = input.length;
		
		if(n == 1)
		{
			return input[0];
		}

		int smallArray[] = new int[n-1];
		for(int i = 0; i<n-1;i++)
		{
			smallArray[i] = input[i];
		}

		int smallOutput = sum(smallArray);

		return smallOutput +input[n-1];
		
	}
public static void main(String[] args) {
	int arr[] = {7,4,9,11,-3};
	System.out.println(sum(arr));
}

}
