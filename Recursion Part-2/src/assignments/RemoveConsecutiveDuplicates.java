package assignments;

public class RemoveConsecutiveDuplicates {
	
	public static String removeConsecutiveDuplicates(String s) 
	{
		if (s == null || s.length() <= 1) {
        return s;
    }
    
    if (s.charAt(0) == s.charAt(1)) {
    	String smallOutput = removeConsecutiveDuplicates(s.substring(1));
    	return smallOutput;
    } 
    
    String smallOutput = removeConsecutiveDuplicates(s.substring(1));
    return s.charAt(0) + smallOutput;
	}
	
	public static void main(String[] args) {
		System.out.println(removeConsecutiveDuplicates("aaabbbcdeef"));
	}
}
