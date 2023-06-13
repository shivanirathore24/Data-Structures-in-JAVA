package questions;
/*
 * You are given an array of integers that contain numbers in random order. Write a program to find and return 
 * the number which occurs the maximum times in the given input.If two or more elements contend for the 
 * maximum frequency, return the element which occurs in the array first.
 */
import java.util.HashMap;

public class MaxFrequencyNumber 
{
	public static int maxFrequencyNumber(int[] arr)
	{ 
		HashMap<Integer, Integer> map = new HashMap<>();
        for( int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }

            int max = 0;
            int maxKey = Integer.MIN_VALUE;
            for( int i = 0; i < arr.length; i++)
            {
                if(map.get(arr[i]) > max)
                {
                    max = map.get(arr[i]);
                    maxKey = arr[i];
                }                
            }
     return maxKey;

    }
	 public static void main(String[] args) {
		int arr [] = {32, 14, 14, 76, 14, 32, 32, 29};
		System.out.println(maxFrequencyNumber(arr));
		
	}
}
