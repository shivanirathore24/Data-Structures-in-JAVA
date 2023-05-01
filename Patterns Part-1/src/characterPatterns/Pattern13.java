package characterPatterns;
import java.util.Scanner;

public class Pattern13 {
//character pattern
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int i =1;
		while(i<=n)
		{
			int j = 1;
			while(j<=n) {
				char jthchar = (char)('A'+j-1);
				System.out.print(jthchar);
				j = j + 1;
			}
		System.out.println();
		i = i + 1;
		}
	}
}
