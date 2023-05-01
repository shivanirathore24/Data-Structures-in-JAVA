package characterPatterns;
import java.util.Scanner;

public class Pattern18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        
        int i = 1;
        while (i <= n) {
            int j = 1;
            char p = (char)('A' + n - i);
           
            while (j<=i) {
                System.out.print(p);
                p = (char)(p+1);
                j++;
            }
            System.out.println();
            i++;
        }
	}

}
