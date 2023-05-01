package triangularPatterns;
import java.util.Scanner;

public class Pattern11 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int i =1;
		while(i<=n)
		{
			int j = 1;
			int p = i;
			while(j<=i)
			{
				System.out.print(p);
				p--;
				j++;
			}
			System.out.println();
			i++;
		}
		}

}
