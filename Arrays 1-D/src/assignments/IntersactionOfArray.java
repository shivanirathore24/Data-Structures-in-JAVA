package arrays1;

//You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.

public class IntersactionOfArray {
	
	public static void intersectionOfArray(int[] arr1, int[] arr2)
	{
		int m = arr1.length;
		int n = arr2.length;
		
		 for(int i =0; i<m;i++)
	        {
			 for(int j =0; j<n; j++)
	            {
	                if ( arr1[i] == arr2[j])
	                {
	                    System.out.print(arr2[j]+" ");
	                    arr2[j] = Integer.MIN_VALUE;
	                    break;
	                }
	            }
	        }
	}
	public static void main(String[] args) {
		int arr1[] = {2,6,2,3,8,2};
		int arr2[] = {3,2,2};
		intersectionOfArray(arr1,arr2);
		
	}

}
