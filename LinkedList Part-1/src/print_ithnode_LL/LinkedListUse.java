package print_ithnode_LL;

/*
 * For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.
 * NOTE : Assume that the Indexing for the singly linked list always starts from 0.
		If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
 */

public class LinkedListUse {
	
	public static Node<Integer> createLinkedList(){
	    Node<Integer> n1= new Node<>(10);
	    Node<Integer> n2= new Node<>(20);
	    Node<Integer> n3= new Node<>(30);
	    Node<Integer> n4= new Node<>(40);
	    Node<Integer> n5= new Node<>(50);
	    n1.next = n2;
	    n2.next = n3;
	    n3.next = n4;
	    n4.next = n5;
	    return n1;
	    }
	
	public static void print(Node<Integer> head)
	{
		Node<Integer> temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+ " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void printIthNode(Node<Integer> head, int i){
		int position = 0;
		Node<Integer> temp = head;
		while( temp != null)
		{
			if(position == i)
			{
				System.out.println("Element at "+i+ "th position: "+temp.data);
			}
		
		temp = temp.next;
		position++;
		}	
		
		//OR
//		while(temp != null && position < i)
//		{
//			temp = temp.next;
//			position++;
//		}
//		if( temp != null)
//		{
//			System.out.println("Element at "+i+ "th position: "+temp.data);
//		}
	}
	
	
	
	
	public static void main(String[] args) {
		Node<Integer> head = createLinkedList();
		print(head);
		int i = 3;
		printIthNode(head, i);
		
		
	}

}
