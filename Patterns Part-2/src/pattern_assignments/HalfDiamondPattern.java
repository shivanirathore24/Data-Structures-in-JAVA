package pattern_assignments;
import java.util.Scanner;

public class HalfDiamondPattern {
public static void main(String[] args) {
	
	 Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("*");
		
		//first half
		for( int i = 1; i <=n ;i++)
		{
			System.out.print("*");
			for(int j = 1; j <= i; j++)
			{
				System.out.print(j);
			}
			
			for(int k = i-1; k >= 1; k--)
			{
				System.out.print(k);
			}
			System.out.print("*");
			System.out.println();
		}
		
		//for second half
		for(int i = n; i >1 ; i--)
		{
			System.out.print("*");
			for(int j = 1; j < i; j++)
			{
				System.out.print(j);
			}
			for(int k = i-2; k>= 1 ; k--)
			{
				System.out.print(k);
			}
			System.out.print("*");
			System.out.println();
		}
		
		System.out.println("*");
		
	        
}
}
