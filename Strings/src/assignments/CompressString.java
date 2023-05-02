package assignments;

public class CompressString {
	
	public static String getCompressedString(String input) {
		 String output=""+input.charAt(0);
        int count=1;
        for (int i=1;i<input.length();i++)
        {
            if (input.charAt(i) != input.charAt(i-1))
            {
                //System.out.println("Count of " + input.charAt(i-1) + " = " + count);
                if (count>1)
                {
                    output=output+Integer.toString(count);
                }
                output=output+input.charAt(i);
                count=1;
            }
            else
            {
                count=count+1;
            }                 
        }
        
        if (count>1)
        {
            output=output+Integer.toString(count);
        }
        //System.out.println(output);
        return output;
	}
	
	public static void main(String[] args) {
		
		String str = "xxxyyzz";
		String str1 = "xxxxx";
		System.out.println(getCompressedString(str));
		System.out.println(getCompressedString(str1));
		
	}

}
