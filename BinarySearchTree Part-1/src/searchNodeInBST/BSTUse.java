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
public class BSTUse 
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
    	BinaryTreeNode<Integer> root = takeInputLevelwise();
   	  	printLevelwise(root);
   	  	
   	  	//System.out.println(searchBST(root,5));
   	  	Scanner s = new Scanner(System.in);
   	  	int k = s.nextInt();
   	  	System.out.println(searchBST(root,k));
	}

}
