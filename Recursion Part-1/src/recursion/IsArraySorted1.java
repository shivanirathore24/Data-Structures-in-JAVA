package recursion;

public class IsArraySorted1 {
	public static boolean isSorted(int a[]){
        if(a.length==1){
            return true;
        }
        if(a[0]>a[1]){
            return false;
        }
        int smallArray[]=new int[a.length-1];
        for(int i=1;i<a.length;i++){
            smallArray[i-1]=a[i];
        }
        boolean isSmallArraySorted=isSorted(smallArray);
        return isSmallArraySorted;
    }
    public static void main(String[] args){
    	int arr1[] = {1,2,3,4,5};
    	int arr2[] = {1,2,4,3,5};
        System.out.println(isSorted(arr1));
        System.out.println(isSorted(arr2));
    }
}