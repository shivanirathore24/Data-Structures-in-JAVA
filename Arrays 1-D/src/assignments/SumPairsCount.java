package arrays1;

public class SumPairsCount {
	public static int sumPairs( int [] arr, int x)
	{
		int count = 0;
		int n = arr.length;
		for(int i =0;i<n-1;i++)
		{
			for(int j = i+1; j<n;j++)
			{
				if ( arr[i]+ arr[j] == x)
				{
					count++;
				}
			}
		}
		return count;
	}
public static void main(String[] args) {
	int [] arr = {1,4,7,6,5,6};
	int x = 7;
	//find count of pairs whose sum is equal to X
	System.out.println(sumPairs(arr,x));
}
}
