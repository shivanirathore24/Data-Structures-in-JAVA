package pattern_assignments;
import java.util.Scanner;

public class OddSquarePattern {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		// i--> currentRow , j--> currentColumn
		int i = 1;
		while(i <= n)
		{
			int valueToPrint = 2*i - 1;
			int j = 1;
			while(j <= n)
			{
				System.out.print(valueToPrint);
				valueToPrint += 2;
				
				int maxValue = 2*n - 1;
				if(valueToPrint > maxValue)
				{
					valueToPrint = 1;
				}
				j++;
			}
			System.out.println();
			i++;
		}
		
	}

}
