package starPattern;
import java.util.Scanner;

public class StarPattern2 {
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	
	int i = 1;
	while(i<=n)
	{
		int spaces = 1;
		while(spaces<= n-i)
		{
			System.out.print(' ');
			spaces++;
		}
		
		int j = 1;
		while(j<= 2*i-1)
		{
			System.out.print('*');
			j++;
		}
			
	System.out.println();
	i++;
	}

}
}
