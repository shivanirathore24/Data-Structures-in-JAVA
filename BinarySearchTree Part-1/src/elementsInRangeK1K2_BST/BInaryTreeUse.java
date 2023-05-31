/*
 * Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.
In BSTs, inorder traversal prints the elements of the tree in ascending order. So, while printing the answer use inorder traversal,
which means calling to the left subtree first, then printing the data, and finally calling to the right subtree
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output 1:
6 7 8 10
 */

package elementsInRangeK1K2_BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import searchNodeInBST.BinaryTreeNode;

public class BInaryTreeUse
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
	
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root == null)
		{
			return;
		}
		if(root.data < k1){
			elementsInRangeK1K2(root.right, k1, k2);
		}
		else if(root.data >k2)
		{
			elementsInRangeK1K2(root.left, k1, k2);
		}
		else{
			// System.out.print(root.data+" ");
			// elementsInRangeK1K2(root.right, k1, k2);
			// elementsInRangeK1K2(root.left, k1, k2);
			
			//to print data in ascending order for BST : Inorder traversal
			elementsInRangeK1K2(root.left, k1, k2);
			System.out.print(root.data+" ");
			elementsInRangeK1K2(root.right, k1, k2);
		}
		
	}
	
    public static void main(String[] args)
    {
    	//BinaryTreeNode<Integer> root = takeInputLevelwise();
    	
    	//taking predefined input 
    	int inOrder[] = {1, 2, 3, 4, 5, 6, 7};  
    	int preOrder[] = {4, 2, 1, 3, 6, 5, 7};
    	BinaryTreeNode<Integer> root =  buildTreeUsingInorderPreorder(preOrder,inOrder);
    	printLevelwise(root); 	
    	
    	//elementsInRangeK1K2(root,3,6);
    	Scanner s = new Scanner(System.in);
    	int k1 = s.nextInt();
    	int k2 = s.nextInt();
    	elementsInRangeK1K2(root,k1,k2);  	
    }
}
