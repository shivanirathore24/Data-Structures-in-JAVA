package questions;
/*
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
Note: Array A can contain duplicate elements as well.
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
 */
import java.util.HashMap;

public class PairSumToZero 
{
	
	public static int PairSum(int[] input, int size) 
	{
        if (size==0)
            return 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int key:input)
        {	
            if(map.containsKey(key))
        	{
            	map.put(key,map.get(key)+1);
        	}
            else
            {
                map.put(key,1);
            }   
        }

        int countPairs=0;
        for (Integer i: map.keySet())
        {
            if (map.containsKey(-i) && i!=0)
            {
                //System.out.println("Found the negative of " + i);
            	countPairs=countPairs+(map.get(i)*map.get(-i));   
                //System.out.println("Current count of pairs: "+countPairs);
                //map.remove(i);
            }
           
        }
        countPairs=countPairs/2;
        if (map.containsKey(0))
        {
            int val=map.get(0);
            countPairs=countPairs+(val*(val-1))/2;
        }
        return countPairs;
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 1, -2, 2, 3};
		System.out.println(PairSum(arr, arr.length));
	}
}
