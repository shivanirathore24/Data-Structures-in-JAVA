package characterPatterns;
import java.util.Scanner;

public class Pattern17 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		
		int i = 1;
		while(i<=n)
		{
			//int p = n-i+1;  
			int j =1;
			while(j<=i)
			{
				char ch = (char)('A'+n-i+j);
				System.out.print(ch);
				//System.out.print(n-i+j);  --formula
				
				//or
				//System.out.print(p);  -- intial value, printing, increment
				//p++;
				j++;
			}
			System.out.println();
			i++;
		}
		
	}

}
