package arrays;

import java.util.Scanner;

public class ArrayWithFunction {
	
	public static void printArray(int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	 public static int[] takeInput(){
	        Scanner s=new Scanner(System.in);
	        int n=s.nextInt();
	        int[]arr=new int[n];
	        for(int i=0;i<n;i++){
	            System.out.println("Enter element at "+i+"th index");
	            arr[i]=s.nextInt();
	        }
	        return arr;
	        
	    }
	
	public static void incrementArray( int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			arr[i] = arr[i] + 1;
		}
	}
	public static void main(String[] args) {
		int [] arr = takeInput();
		incrementArray(arr);
		printArray(arr);
	
	}

}
