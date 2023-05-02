package assignments;

public class HighestOccurringCharacter {
	
	public static char highestOccuringChar(String str) 
	{
		int n = str.length();
		 int frequency[] = new int[256];

		 for( int i =0; i <n; i++)
		 {
			 char currchar = str.charAt(i);
			 frequency[currchar]++;
		 }

		 int maxCount = 0;
		 char maxchar = str.charAt(0);

		 for( int i = 0; i < n; i++)
		 {
			 char currchar = str.charAt(i);
			 if(frequency[currchar] > maxCount)
			 {
				 maxCount = frequency[currchar];
				 maxchar = currchar;
			 }
		 }
		 return maxchar;	 
	}
	
	public static void main(String[] args) {
		String str = "abcdeapapqarr";
		System.out.println(highestOccuringChar(str));
		
	
}
}
