package findnode_LL;

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
	
	
public static int findNode(Node<Integer> head , int elem)
{
	int pos = 0;
	while( head != null)
	{
		//. if element present , return the position of element
		if(head.data == elem)
		{
			return pos;
		}
		head = head.next;
		pos++;
	}
	
	//or 
//	Node<Integer> curr = head;
//	while( curr != null)
//	{
//		if( curr.data == elem)
//		{
//			return  pos;
//		}
//		curr = curr.next;
//		pos++;
//	}
	
	return -1;
}
	
		
		
		
		
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		print(head);
		System.out.println();
		
		System.out.println(findNode(head,24));
		

	}

}
