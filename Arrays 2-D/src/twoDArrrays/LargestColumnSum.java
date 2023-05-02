package twoDArrrays;

import java.util.Scanner;

public class LargestColumnSum {
	
	public static int[][] takeInput(){
	Scanner s = new Scanner(System.in);
	System.out.println("Enter no. of rows:");
	int rows = s.nextInt();
	System.out.println("Enter no. of cols:");
	int cols = s.nextInt();
	
	int [][] arr = new int[rows][cols];
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				System.out.println("Enter element at "+i+"th row "+j+"th column:");
				arr[i][j] = s.nextInt();
				
			}
		}
	return arr;
	}
	
	public static void print2DArray(int [][] arr)
	{
		int rows= arr.length;
		int cols = arr[0].length;
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static int largestCol(int[][] arr) {
		int rows= arr.length;
		int cols = arr[0].length;
		
		int largest = Integer.MIN_VALUE;
		for(int j =0; j<cols; j++)
		{
			int sum =0;
			for(int i =0; i<rows; i++) {
				sum = sum + arr[i][j];
			}
			if(sum > largest)
			{
				largest = sum;
			}
		}
		return largest;
	}
	
	public static void main(String[] args) {
		int [][] arr= takeInput();
		print2DArray(arr);
		int largeColSum = largestCol(arr);
		System.out.println(largeColSum);
	}

}
