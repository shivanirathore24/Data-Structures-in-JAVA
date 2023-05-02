package assignments;

public class removeConsecutiveDuplicates {
	
	public static String removeConsecutiveDuplicate(String str) {
		//Your code goes here
		String outputString=Character.toString(str.charAt(0));
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i)!=str.charAt(i-1))
            outputString+=Character.toString(str.charAt(i));
        }
        str=outputString;
        return str;
	}
	
	
	public static void main(String[] args) {
		String str = "aabbcccddee";
	System.out.println(removeConsecutiveDuplicate(str));
		
		
	}

}
