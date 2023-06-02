package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import searchNodeInBST.BinaryTreeNode;

public class BSTtoLL 
{
	public static BinaryTreeNode<Integer> takeInputLevelwise()  //iterative way
    {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter root Data: ");
    	int rootData = s.nextInt();
    	if(rootData == -1)
    	{
    		return null;
    	}
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);  //creating node
    	Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
    	pendingChildren.add(root);
    	
    	while(!pendingChildren.isEmpty())
    	{
    		BinaryTreeNode<Integer> front = pendingChildren.poll();
    		System.out.println("Enter left child of "+front.data);
    		int left = s.nextInt();
    		if(left != -1)
    		{
    			BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
    			front.left = leftChild;
    			pendingChildren.add(leftChild);
    		}
    		
    		System.out.println("Enter right child of "+front.data);
    		int right = s.nextInt();
    		if(right != -1)
    		{
    			BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
    			front.right = rightChild;
    			pendingChildren.add(rightChild);
    		}
    	}//end of while
    	return root;
    }
    
	public static void printLevelwise(BinaryTreeNode<Integer> root)
    {
    	if(root == null)
    	{
    		return;
    	}
    	Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
    	nodesToPrint.add(root);
    	while(!nodesToPrint.isEmpty()) 
    	{
    		BinaryTreeNode<Integer> front = nodesToPrint.poll();
    		System.out.print(front.data+":");
    		
    		if(front.left != null)
    		{
    			nodesToPrint.add(front.left);
    			System.out.print("L:"+front.left.data);
    		}
    		else {
    			System.out.print("L:-1");
    		}
    		
    		if(front.right != null)
    		{
    			nodesToPrint.add(front.right);
    			System.out.print(",R:"+front.right.data);
    		}
    		else {
    			System.out.print(",R:-1");
    		}
    		
    		System.out.println();
    	} // end of while
    }
    
    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
		BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(preOrder , inOrder, 0 , preOrder.length -1 , 0, inOrder.length -1);
		return root;
	}

	public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int [] preOrder , int[] inOrder, int siPre, int eiPre, int siIn, int eiIn)
	{
		if(siPre > eiPre)
		{
			return null;
		}

		int rootData = preOrder[siPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int rootIndex = -1;
		for(int i = siIn; i<= eiIn;i++)
		{
			if(inOrder[i]== rootData)
			{
				rootIndex = i;
				break;
			}
		}

		//assuming that root index actually present in inOrder

		int siPreLeft = siPre + 1;
		int eiPreLeft;
		int siPreRight;
		int eiPreRight = eiPre;
		int siInLeft = siIn;
		int eiInLeft = rootIndex - 1;
		int siInRight = rootIndex + 1;
		int eiInRight = eiIn;

		int leftSubtreeLength = eiInLeft - siInLeft +1;

		eiPreLeft = siPreLeft + leftSubtreeLength -1;
		siPreRight = eiPreLeft + 1;

		BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(preOrder, inOrder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(preOrder, inOrder, siPreRight, eiPreRight, siInRight, eiInRight);

		root.left = left;
		root.right = right;
		return root;

	}
	
	//way1
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) 
	{
		 if (root == null)
           return null;
       // Stack to perform iterative in-order traversal
       Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
       BinaryTreeNode<Integer> curr = root;
       LinkedListNode<Integer> head = null;
       LinkedListNode<Integer> prev = null;

       while (curr != null || !stack.isEmpty()) 
       {
           // Reach the leftmost node of the current subtree
           while (curr != null) 
           {
               stack.push(curr);
               curr = curr.left;
           }

           curr = stack.pop();
			// Create a new node for the linked list
           LinkedListNode<Integer> newNode = new LinkedListNode<>(curr.data);
           if (head == null) 
           {
               head = newNode;
               prev = newNode;
           } else {
               prev.next = newNode;
               prev = newNode;
           }
           curr = curr.right;
       }
       return head;
	}
	
	public static void print(LinkedListNode<Integer> head)
	{
		LinkedListNode<Integer> temp = head;
		while( temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	//way2
	/*
     * Time Complexity : O(N)  where N is no. of nodes in tree
     * Space Complexity : O(H)  where H is height of tree
     * H is equal to log(N) for balance tree
     */
	public static LinkedListNode<Integer> constructLinkedList1(BinaryTreeNode<Integer> root)
	{
		return constructLinkedListHelper(root).head;
	}
    private static PairOfNodeElem constructLinkedListHelper(BinaryTreeNode<Integer> root) 
    {
		if(root == null)
		{
			PairOfNodeElem pair = new PairOfNodeElem();
			return pair;
		}
		LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);
		PairOfNodeElem leftList = constructLinkedListHelper(root.left);
		PairOfNodeElem rightList = constructLinkedListHelper(root.right);
		
		PairOfNodeElem pair = new PairOfNodeElem();
		if(leftList.tail != null)
		{
			leftList.tail.next = newNode;
		}
		newNode.next = rightList.head;
		
		if(leftList.head != null)
		{
			pair.head = leftList.head;
		}
		else {
			pair.head = newNode;
		}
		
		if(rightList.tail != null)
		{
			pair.tail = rightList.tail;
		}
		else {
			pair.tail = newNode;
		}	
		return pair;
	}

	public static void main(String[] args)
    {
    	//BinaryTreeNode<Integer> root = takeInputLevelwise();
    	
    	//taking predefined input 
    	int inOrder[] = {1, 2, 3, 4, 5, 6, 7};  
    	int preOrder[] = {4, 2, 1, 3, 6, 5, 7};
    	BinaryTreeNode<Integer> root =  buildTreeUsingInorderPreorder(preOrder,inOrder);
    	printLevelwise(root); 		
    	LinkedListNode<Integer> head =  constructLinkedList(root);
    	print(head);
    	System.out.println();
    	
    	LinkedListNode<Integer> head1 =  constructLinkedList1(root);
    	print(head1);
    }

}
