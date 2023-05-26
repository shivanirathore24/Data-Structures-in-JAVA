/*
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
The root will remain the same. So you just need to insert nodes in the given Binary Tree.

Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1

Sample Output 1:
10 
10 30 
20 30 60 
20 50 60 
40 50 
40 
*/

package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import buildBT_UsingInorderPreorder.BinaryTreeNode;

public class InsertDuplicateNode {
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
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) 
    {
		if(root == null)
		{
			return;
		}
		BinaryTreeNode<Integer> duplicateNode = new BinaryTreeNode<>(root.data);
		BinaryTreeNode<Integer> rootLeft = root.left;

		root.left = duplicateNode;
		duplicateNode.left = rootLeft;

		insertDuplicateNode(rootLeft);
		insertDuplicateNode(root.right);
	}
    
    public static void main(String[] args) 
    {
    	BinaryTreeNode<Integer> root = takeInputLevelwise();
    	printLevelwise(root);
    	System.out.println();
    	System.out.println("After inserting duplicate at left: ");
    	insertDuplicateNode(root);
    	printLevelwise(root);
}
}
