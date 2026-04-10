package characterPatterns;

import java.util.Scanner;

public class CharacterPattern5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        // Method 1: Using formula
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                char ch = (char) ('A' + n - i + j - 1);
                System.out.print(ch);
                j++;
            }
            System.out.println();
            i++;
        }

        // Method 2: Using variable (increment)
        i = 1;
        while (i <= n) {
            int j = 1;
            char p = (char) ('A' + n - i);
            while (j <= i) {
                System.out.print(p);
                p = (char) (p + 1);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}