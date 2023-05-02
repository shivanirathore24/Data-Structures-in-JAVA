package recursionWithString;

public class ReplacePI {
	
	 public static String replacePi(String s)
	 {
	        if(s.length()<=1){
	            return s;
	        }
	        
	        if(s.charAt(0)=='p' && s.charAt(1)=='i'){
	            //Call recursion on string of length n-2;
	            String smallOutput=replacePi(s.substring(2));
	            return "3.14"+smallOutput;
	        }
	        else{
	            //call recursion on string of length n-1;
	            String smallOutput=replacePi(s.substring(1));
	            return s.charAt(0)+smallOutput;
	        }
	    }
	 
	    public static void main(String[] args){
	        //System.out.println(replaceChar("abcxdxex",'x','y'));
	        System.out.println(replacePi("apiapipipiip"));
	    }

}
