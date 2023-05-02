package assignments;

/*
 For a given two-dimensional integer array/list of size (N x M), you need to find out which row or column has the largest sum(sum of all the elements in a row/column) amongst all the rows and columns.
 If there are more than one rows/columns with maximum sum, consider the row/column that comes first. And if ith row and jth column has the same largest sum, consider the ith row as answer.
 */

public class LargestRowColumn {
	
	public static void findLargest(int mat[][]){
		//Your code goes here
		int rows= mat.length;
		int largestSum = Integer.MIN_VALUE;
		boolean isRow = true;
		int idx = 0;

		if ( rows == 0)
		{
			System.out.println("row "+ idx + " "+largestSum);
		}
		int cols = mat[0].length;

		//traverse row 
		for(int i =0; i < rows ; i++)
		{
			int rowSum = 0;
			for ( int j =0; j< cols; j++)
			{
				rowSum += mat[i][j];
			}

			if(rowSum > largestSum)
			{
				largestSum = rowSum;
				 idx = i;
			}
		}

		//traverse column
		for( int j =0; j< cols; j++)
		{
			int colSum =0;
			for( int i = 0; i < rows; i++)
			{
				colSum += mat[i][j];
			}
			if(colSum > largestSum)
			{
				largestSum = colSum;
				idx = j;
				isRow = false;
			}
		}

		if(isRow)
		{
			System.out.println("row "+ idx + " "+largestSum);
		}
		else{
			System.out.println("column "+ idx + " "+largestSum);
		}	
	}
		
	public static void main(String[] args) {
		int[][] mat ={{1,2,3,4},{4,2,1,1},{2,3,4,5}};
		findLargest(mat);
	}

}
