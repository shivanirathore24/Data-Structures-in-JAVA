package assignments;

public class QuickSort {
	
	public static void quickSort(int[] input) {
		quickSort(input, 0, input.length - 1);
	}
		public static void quickSort(int[] input, int startIndex, int endInedx) {
			 if( startIndex >= endInedx)
			 {
				 return;
			 }

			 int pivotIndex = partition(input, startIndex, endInedx);
			 quickSort(input, startIndex, pivotIndex-1);
			 quickSort(input, pivotIndex+1, endInedx);
		}

		public static int partition( int input[], int startIndex, int endInedx)
		{
			int pivotElement = input[startIndex];
			int smallerNumCount = 0;

			for(int i = startIndex +1; i <= endInedx ; i++)
			{
				if(input[i] < pivotElement)
				{
					smallerNumCount++;
				}
			}

			int temp = input[startIndex + smallerNumCount];
			input[startIndex + smallerNumCount] = pivotElement;
			input[startIndex] = temp;

			int i = startIndex;
			int j = endInedx;
			while( i < j)
			{
				if( input[i]  < pivotElement)
				{
					i++;
				}
				else if ( input[j] >=  pivotElement)
				{
					j--;
				}
				else
				{
					 temp = input[i];
					input[i] = input[j];
					input[j] = temp;
					i++;
					j--;
				}
			}
			return startIndex + smallerNumCount;
		}
		
		public static void main(String[] args) {
			 int input[] = {10, 4, 5, 9, 8, 6, 12, 11, 7};
			 quickSort(input);
			 for( int i =0; i < input.length ; i++)
			 {
				 System.out.print(input[i]+ " ");
			 }
		}
	



}
