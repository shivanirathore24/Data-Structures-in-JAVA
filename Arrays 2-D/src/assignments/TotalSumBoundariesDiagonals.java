package assignments;

public class TotalSumBoundariesDiagonals {
	
	public static void totalSum(int[][] mat) {
		int n = mat.length;
		if(n == 0)
		{
			System.out.println(0);
			return;
		}

		int totalSum = getBoundarySum(mat,n) + getDiagonal(mat, n);
		if(n%2 != 0)
		{
			totalSum -= mat[n/2][n/2];
		}
		System.out.println(totalSum);
	}

	public static int getBoundarySum(int [][] mat, int n)
	{
		int sum =0;
		for( int i =0; i <n; i++)
		{
			sum += mat[0][i];
			sum += mat[n-1][i];
		}

		//left and right columns
		for( int i = 1; i < n-1 ; i++)
		{
			sum += mat[i][0];
			sum += mat[i][n-1];
		}
	return sum;
	}

	public static int getDiagonal( int[][] mat, int n)
	{
		int sum =0;
		//left diagonal and right diagonal
		for(int i = 1; i< n-1; i++)
		{
			sum += mat[i][i];
			sum += mat[i][n-i-1];
		}
	return sum;
	}

	public static void main(String[] args) {
		int[][] mat ={{1,2,3,10},{4,5,6,11},{7,8,9,12}, {13,14,15,16}};
		totalSum(mat);
		
	}

}
