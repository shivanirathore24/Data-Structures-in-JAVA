package takeinput_LL_O_n2;

import java.util.Scanner;

public class LinkedListUse {
	
	
	
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
	

	  public static Node<Integer> takeInput(){
	        Scanner s= new Scanner(System.in);
	        int data = s.nextInt();
	        Node<Integer> head = null;
	        while(data != -1)
	        {
	          Node<Integer> currentNode= new Node<Integer>(data);
	          if(head==null){
	            head=currentNode;
	          }else{
	            Node<Integer> tail = head;
	            while(tail.next != null){
	                tail= tail.next;
	            }
	            tail.next= currentNode;
	          }
	          data=s.nextInt();
	        }
	        return head;
	  }

	

		
	
	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		print(head);
		
	
		
	}

}
