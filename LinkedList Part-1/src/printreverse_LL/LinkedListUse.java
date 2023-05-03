package printreverse_LL;

import java.util.Scanner;


public class LinkedListUse {
	
	
	public static Node<Integer> takeInput()
	{
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while( data != -1)
		{
			Node<Integer> currentNode = new Node<Integer>(data);
			if( head == null)
			{
				head = currentNode;
				tail = currentNode;
			}
			else
			{
				tail.next = currentNode;
				tail = tail.next;  // tail = currentNode'
			}
			data = s.nextInt();
		}
		return head;
	}
	
	
	public static void print(Node<Integer> head)
	{
		Node<Integer> temp = head;
		while( temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	
	
		
public static void printReverse(Node<Integer> head)
{
	if( head == null)
	{
		return ;
	}
	printReverse(head.next);
	System.out.print(head.data+" ");
}
		
		
		
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		//print(head);
		
		System.out.println();
		
		printReverse(head);
		

	}

}
