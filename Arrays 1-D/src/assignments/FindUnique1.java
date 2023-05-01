package arrays1;


public class FindUnique1 {
	public static int findUnique(int[] arr){
		int val = 0;
	    
	    for (int i = 0; i < arr.length; i++) {
	        int count = 0;
	        for(int j=0;j<arr.length;j++){
	          if(arr[i]==arr[j]){
	            count++;
	          }
	        }
	        if(count==1){
	          val = arr[i];
	          break;
	        }
	    }
	    return val;
	}
	
	
	public static void main(String[] args) {
		int [] arr = {6,6,2,5,8,8,5};
		System.out.println(findUnique(arr));
		
	}

}

