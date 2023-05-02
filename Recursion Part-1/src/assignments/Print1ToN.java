package assignments;

/*Given the number 'n', write a code to print numbers from 1 to n in increasing order recursively.*/

public class Print1ToN {
	 public static void print1ton(int n){
	        if(n==0){
	            return;
	        }
	        //System.out.println(n);  //dec order
	        print1ton(n-1);
	        System.out.println(n);   //inc order
	        
	    }
	    public static void main(String[] args){
	        //System.out.println(fact(5));
	        //System.out.println(sumn(4));
	        print1ton(5);
	    }

}
