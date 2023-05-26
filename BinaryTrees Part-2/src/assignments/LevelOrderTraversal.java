/*
 * For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line.
 *  Elements on every level will be printed in a linear fashion and a single space will separate them.
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
Sample Output 1:
10 
20 30 
40 50 60 
 */

package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import buildBT_UsingInorderPreorder.BinaryTreeNode;

public class LevelOrderTraversal 
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
    
    
    /*
     * Time Complexity : O(N)  where N is no. of nodes in tree
     * Space Complexity : O(N)  
     */
    public static void traversalLevelWiseWay1(BinaryTreeNode<Integer> root) 
    {
		if (root == null)
			return;

	    Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
	    queue.offer(root); // Enqueue the root node

	    while (!queue.isEmpty()) 
	    {
		    int levelSize = queue.size(); // Number of nodes in the current level
		    
		    for (int i = 0; i < levelSize; i++)
		    {
	            BinaryTreeNode<Integer> node = queue.poll(); // Dequeue the front node
	            System.out.print(node.data + " "); // Print the data
	
	            // Enqueue the left and right child nodes if they exist
	            if (node.left != null)
	                queue.offer(node.left);
	            if (node.right != null)
	                queue.offer(node.right);
	        }
	        System.out.println(); // Print a new line after each level
	    }// end of while
	}
    
    public static void traversalLevelWiseWay2(BinaryTreeNode<Integer> root)
    {
    	if(root == null)
    	{
    		return;
    	}
    	Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
    	pendingNodes.add(root);
    	pendingNodes.add(null);
    	
    	while(!pendingNodes.isEmpty())
    	{
    		BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
    		if(frontNode == null)
    		{
    			System.out.println();
    			if(!pendingNodes.isEmpty())
    			{
    				pendingNodes.add(null);
    			}
    		}
    		else 
    		{
    			System.out.print(frontNode.data+" ");
    			
    			if(frontNode.left != null)
    			{
    				pendingNodes.add(frontNode.left);
    			}
    			if(frontNode.right != null)
    			{
    				pendingNodes.add(frontNode.right);
    			}
    		}	
    	} //end of while  	
    }
    
    public static void main(String[] args) {
    	BinaryTreeNode<Integer> root = takeInputLevelwise();
    	printLevelwise(root);
    	System.out.println();
    	traversalLevelWiseWay1(root);
    	traversalLevelWiseWay2(root);
    	
	}
}
