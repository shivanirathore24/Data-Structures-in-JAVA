package assignments;

public class LastIndexOfNumberInArray {
	public static int lastIndex(int a[] , int x)
	{
		if(a.length == 0)
		{
			return -1;
		}
		
		int smallArray[] = new int[a.length -1];
		for(int i =1; i<a.length; i++)
		{
			smallArray[i-1] = a[i];
		}
		int k = lastIndex(smallArray, x);
		if( k != -1)
		{
			return k+1;
		}
		else
		{
			if(a[0] == x)
			{
				return 0;
			}
			else
			{
				return -1;
			}
		}
	}
	
	public static int lastIndexBetter(int a[], int x, int si)
	{
		if(si == a.length)
		{
			return -1;
		}
		int k = lastIndexBetter(a,x,si+1);
		if( k != -1)
		{
			return k;
		}
		else {
			if(a[si] == x)
			{
				return si;
			}
			else
			{
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {3, 4, 7, 5, 9, 7, 6, 5};
		int x = 5;
		System.out.println(lastIndex(arr,5));
		System.out.println(lastIndexBetter(arr,7,0));
		System.out.println(lastIndexBetter(arr,2,0));
		System.out.println(lastIndexBetter(arr,3,0));
	}

}
