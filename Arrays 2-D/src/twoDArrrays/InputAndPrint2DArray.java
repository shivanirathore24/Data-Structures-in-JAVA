package twoDArrrays;

import java.util.Scanner;

public class InputAndPrint2DArray {
	public static void main(String[] args) {
		   Scanner s=new Scanner(System.in);
	       System.out.println("Enter the number of rows");
	       int rows=s.nextInt();
	       System.out.println("Enter numbe rof cols");
	       int cols=s.nextInt();
	       
	       int[][]arr=new int[rows][cols];
	       
	       //taking input row wise
	       for(int i=0;i<rows;i++){
	           for(int j=0;j<cols;j++){
	               System.out.println("Enter the element at "+i+"th row "+j+"th column");
	               arr[i][j]=s.nextInt();
	           }
	       }
	       
	       //printing 2d-array
	       for(int i=0;i<rows;i++){
	           for(int j=0;j<cols;j++){
	               System.out.print(arr[i][j]+" ");
	           }
	           System.out.println();
	           
	           
	       }
	}

}
