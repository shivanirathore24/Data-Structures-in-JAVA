package triangularPatterns;
import java.util.Scanner;

public class Pattern7 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int p = 1;
		int i = 1;
		while( i<=n) {
			int j = 1;
			while(j<=i)
			{
				System.out.print(p);
				p++;
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
