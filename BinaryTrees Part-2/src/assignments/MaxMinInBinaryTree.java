/*
 * For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
Return the output as an object of Pair class.
Note:
All the node data will be unique and hence there will always exist a minimum and maximum node data.
 */

package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import buildBT_UsingInorderPreorder.BinaryTreeNode;

public class MaxMinInBinaryTree {
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
    
    /*
     * Time Complexity : O(N)  where N is no. of nodes in tree
     * Space Complexity : O(H)  where H is height of tree
     * H is equal to log(N) for balance tree
     */
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if (root == null) {
        return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Pair<Integer, Integer> leftPair = getMinAndMax(root.left);
		Pair<Integer, Integer> rightPair = getMinAndMax(root.right);

        int minimum = Math.min(root.data, Math.min(leftPair.minimum, rightPair.minimum));
        int maximum = Math.max(root.data,Math.max(leftPair.maximum, rightPair.maximum));

        return new Pair<>(minimum, maximum);
    }
    
    public static void main(String[] args) {
    	BinaryTreeNode<Integer> root = takeInputLevelwise();
    	printLevelwise(root);
    	Pair<Integer, Integer> pair = getMinAndMax(root);
    	System.out.println("Minimum :" + pair.minimum);
    	System.out.println("Maximum :" + pair.maximum);  	
	}

}
