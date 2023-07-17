package generic_method;

public class Print {
	
	//generic method
    public static<T> void printArray(T arr[])
    {
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args)
    {
      Integer arr[]= new Integer[5];
      for(int i=0;i<arr.length;i++)
      {
        arr[i]=i+1;
      }
      printArray(arr);

      
      String arrS[]= new String[5];
      for(int i=0;i<arrS.length;i++)
      {
        arrS[i]="shiv";
      }
      printArray(arrS);
      
      
      Vehicle v[] = new Vehicle[5];
      printArray(v);  // print array of references which points to null
      for( int i = 0; i < v.length; i++)
      {
    	  v[i]  = new Vehicle();
      }
      printArray(v); //now every reference is pointing to object created.
      
      
    }

}
