package deletenode_LL;

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
	
	public static Node<Integer> delete(Node<Integer> head, int pos)
	{
		if(head == null)
		{
			return head;
		}
		
		if( pos < 0)
		{
			return head;
		}
		
		if( pos == 0)  //edge case
		{
			return head.next;
		}
		
		int count = 0;
		Node<Integer> prev =head;
		while(count < pos -1 && prev != null)
		{
			prev = prev.next;
			count++;
		}
		
		if( prev == null || prev.next == null)
		{
			return head;
		}
		prev.next = prev.next.next;
	
		return head;
	}
 
		
		
		
		
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		print(head);
		
		System.out.println();
		
//		delete(head,-1);
//		print(head);
		
//		delete(head,0);  //not working
//		print(head);
		
//		delete(head,1);
//		print(head);
		
//		delete(head,2);
//		print(head);
		
//		delete(head,10);
//		print(head);
	}

}
