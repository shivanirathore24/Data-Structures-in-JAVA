package arrays1;

public class Sort01 {
	
	public static void sortZeroesAndOne(int[] arr) {
    	//Your code goes here
        // int n = arr.length;
        int i =0;
        int j = 0;
          while(i<arr.length){
            if(arr[i]==1){
                i++;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }

    }
	
	public static void printArray(int [] arr)
	{
		for(int i =0; i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr [] = { 0,1,0,0, 1,1 ,0, 1,1};
		sortZeroesAndOne(arr);
		printArray(arr);
		
	}

}
