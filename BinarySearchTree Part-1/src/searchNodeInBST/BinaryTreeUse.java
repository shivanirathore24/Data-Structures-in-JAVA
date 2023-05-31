/*
 * Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, 
 * if node with data k is present, return false otherwise.
 * Note: Assume that BST contains all unique elements.
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
true
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
false
 */

package searchNodeInBST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * A binary search tree is a rooted binary tree in which the nodes are arranged in strict total order in which 
 * the nodes with keys greater or equal to than any particular node is stored on the right sub-trees and the ones 
 * less than are stored on the left sub-tree satisfying the binary search property.
 */
public class BinaryTreeUse
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

	public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder)
	{
		BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(preOrder , inOrder, 0 , preOrder.length -1 , 0, inOrder.length -1);
		return root;
	}

	public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int [] preOrder , int[] inOrder, int siPre, int eiPre, int siIn, int eiIn)
	{
		if (siPre > eiPre) {
			return null;
		}

		int rootData = preOrder[siPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int rootIndex = -1;
		for (int i = siIn; i <= eiIn; i++) {
			if (inOrder[i] == rootData) {
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

		int leftSubtreeLength = eiInLeft - siInLeft + 1;

		eiPreLeft = siPreLeft + leftSubtreeLength - 1;
		siPreRight = eiPreLeft + 1;

		BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(preOrder, inOrder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(preOrder, inOrder, siPreRight, eiPreRight, siInRight, eiInRight);

		root.left = left;
		root.right = right;
		return root;

	}

	public static boolean searchBST(BinaryTreeNode<Integer> root, int k)
    {
    	if(root == null)
    	{
    		return false;
    	}
    	
    	if(root.data == k) {
    		return true;
    	}
    	
    	if(k < root.data)
    	{
    		return searchBST(root.left, k);
    	}
    	return searchBST(root.right, k);
    }
    
    public static void main(String[] args) 
    {
    	//please take Binary Search tree to get correct result
    	//BinaryTreeNode<Integer> root = takeInputLevelwise();

		//taking predefined BST input
		int inOrder[] = {1, 2, 3, 4, 5, 6, 7};
		int preOrder[] = {4, 2, 1, 3, 6, 5, 7};
		BinaryTreeNode<Integer> root =  buildTreeUsingInorderPreorder(preOrder,inOrder);
		printLevelwise(root);
   	  	//System.out.println(searchBST(root,5));
   	  	Scanner s = new Scanner(System.in);
   	  	int k = s.nextInt();
   	  	System.out.println(searchBST(root,k));
	}

}
