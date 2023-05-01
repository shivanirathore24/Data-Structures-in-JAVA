package pattern_assignments;
import java.util.Scanner;

public class TriangleNumberPattern {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int i = 1;
		
		while(i<=n)
		{
			int spaces = 1;
			while(spaces<= n-i)
			{
				System.out.print(" ");
				spaces++;
			}
			
			int inc = 1;
			int num = i;
			while(inc<=i)
			{
				System.out.print(num);
				num++;
				inc++;
			}
//			int dec = i -1;
//			num = 2*i -2;
//			while(dec>=1)
//			{
//				System.out.print(num);
//				num--;
//				dec--;
//			}
			
			//or 
			
			int dec = 1;
			num = 2*i - 2;
			while(dec<= i-1)
			{
				System.out.print(num);
				num--;
				dec++;
			}
			System.out.println();
			i++;
		}
	}

}
