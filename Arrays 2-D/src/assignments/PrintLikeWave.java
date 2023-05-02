package assignments;

public class PrintLikeWave {
	
	public static void wavePrint(int mat[][]){
		int rows = mat.length;
		if(rows == 0)
		{
			return;
		}
		
		int cols = mat[0].length;
		for( int j =0; j < cols; j++)
		{
			if(j%2 == 0)
			{//for even cols -- print top to bottom
				for( int i = 0; i < rows; i++)
				{
					System.out.print(mat[i][j]+ " ");
				}
			}
			else
			{//for odd cols -- print bottom to top
				for( int i = rows - 1; i >= 0; i--)
				{
					System.out.print(mat[i][j]+ " ");
				}
			}
		}// end of for loop
	}
	
	public static void main(String[] args) {
		int[][] mat ={{1,2,3,10},{4,5,6,11},{7,8,9,12}, {13,14,15,16}};
		wavePrint(mat);
	}

}
