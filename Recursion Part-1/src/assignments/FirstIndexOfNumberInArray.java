package assignments;

/*Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.
First index means, the index of first occurrence of x in the input array.
Do this recursively. Indexing in the array starts from 0.*/ 

public class FirstIndexOfNumberInArray {
	
	public static int firstIndex(int a[] , int x)
	{
		if(a.length == 0)
		{
			return -1;
		}
		if(a[0] == x)
		{
			return 0;
		}
		int smallArray[] = new int[a.length -1];
		for(int i =1; i<a.length; i++)
		{
			smallArray[i-1] = a[i];
		}
		int fi = firstIndex(smallArray, x);
		if( fi == -1)
		{
			return -1;
		}
		else
		{
			return 1 + fi;
		}
	}
	
	public static int firstIndexBetter(int a[], int x, int si)
	{
		if(si == a.length)
		{
			return -1;
		}
		
		if(a[si] == x)
			
		{
			return si;
		}
		int fi = firstIndexBetter(a,x,si+1);
		return fi;
	}
	
	public static void main(String[] args) {
		int arr[] = {3, 4, 7, 5, 9, 7, 6, 5};
		int x = 5;
		System.out.println(firstIndex(arr,5));
		System.out.println(firstIndexBetter(arr,7,0));
	}

}
