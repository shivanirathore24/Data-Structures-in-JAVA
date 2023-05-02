package assignments;

/*Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
Do this recursively.*/

public class CheckNumberInArray {
	
	public static boolean checkNumber(int input[], int x)
	{
		if(input.length == 0)
		{
			return false;
		}
		if(input[0] == x)
		{
			return true;
		}
		int smallArray[] = new int[input.length -1];
		for(int i = 1; i< input.length; i++)
		{
			smallArray[i-1] = input[i];
		}
		
		boolean smallOutput = checkNumber(smallArray, x);
		return smallOutput;	
	}
	
	public static boolean checkNumberBetter(int input[], int x, int si)
	{
		if(si == input.length)
		{
			return false;
		}
		if(input[si] == x)
		{
			return true;
		}
		boolean smallOutput = checkNumberBetter(input, x , si+1);
		return smallOutput;
	}
	
	public static void main(String[] args) {
		int arr [] = {2,8,-5,7,-9};
		System.out.println(checkNumber(arr,7));
		System.out.println(checkNumberBetter(arr,10,0));
	}

}
