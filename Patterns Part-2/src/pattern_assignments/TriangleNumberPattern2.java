package pattern_assignments;
import java.util.Scanner;

public class TriangleNumberPattern2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int i =1;
		while(i<=n)
		{
			int spaces =1 ;
			while(spaces<= n-i)
			{
				System.out.print(" ");
				spaces++;
			}
			
			int j = 1;
			int num =i;
			while(j<=i)
			{
				System.out.print(num);
				num++;
				j++;
			}
			
			j =1;
			num = 2*i -2;
			while(j<= i-1)
			{
				System.out.print(num);
				num--;
				j++;
			}
			System.out.println();
			i++;
		}
	}

}


/*

Sample Input 2:
4
Sample Output 2:
   1
  232
 34543
4567654

 */
