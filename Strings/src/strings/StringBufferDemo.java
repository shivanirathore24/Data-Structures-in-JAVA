package strings;

public class StringBufferDemo {
	 public static void main(String args[]) {
	        StringBuffer str=new StringBuffer("abc");
	        str.setCharAt(0,'d');
	        str.append("def");
	        System.out.println(str+" "+str.length());
	        
	        String s="d";
	        for(int i=0;i<5;i++){
	            s=s+'z';
	        }
	}

}
