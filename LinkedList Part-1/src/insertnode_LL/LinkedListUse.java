package insertnode_LL;

import java.util.Scanner;

/*
 You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'
 Write a function to add a node to the list with the 'data' at the specified position, 'pos.'
Note :
Assume that the Indexing for the singly linked list always starts from 0.
If the position is greater than the length of the singly linked list, you should return the same linked list without any change.
 */

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
	
	
	public static  Node<Integer> insert(Node<Integer> head, int elem, int pos)
	{
		if( pos < 0)
		{
			return head;
		}
		Node<Integer> nodeToBeInserted = new Node<Integer>(elem);
		if( pos == 0)
		{
			nodeToBeInserted.next = head;
			head = nodeToBeInserted;
			return head; // return new head 
		}
		
		else 
		{
			int count = 0;
			Node<Integer> prev = head; 
			while(count < pos-1 && prev != null)
			{
				count++;
				prev = prev.next;  //prev should point to pos-1
			}
			if(prev != null)
			{
				nodeToBeInserted.next = prev.next;
				prev.next = nodeToBeInserted;
			}
		}	//end of else	
		return head;
	}
		
		
		
		
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		//print(head);
		
//		insert(head,80, -1);
//		print(head);
		
		insert(head, 80, 0);
		print(head);
		
//		insert(head,80, 2);
//		print(head);
		
//		insert(head,80, 7 );
//		print(head);
		
	}

}
