/*
You are given a Binary Tree of type integer, a target node, and an integer value K.
Print the data of all nodes that have a distance K from the target node. 
The order in which they would be printed will not matter.
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3 1
Sample Output 1:
9
6
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
3 3
Sample Output 2:
4
5
 */
package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import buildBT_UsingInorderPreorder.BinaryTreeNode;

public class PrintNodeAtDistKFromNode 
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
     * Space Complexity : O(H)  where H is height of tree
     * H is equal to log(N) for balance tree
     */
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k)
    {
    	nodesAtDistanceKHelper(root, node, k);
    }
    
    private static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> root, int target, int k) 
    {
    	if(root == null)
    	{
    		return -1;
    	}
    	
    	if(root.data == target)
    	{
    		printDepthK(root,k);
    		return 0;
    	}
    	
    	int leftD = nodesAtDistanceKHelper(root.left, target, k);
    	if(leftD != -1)
    	{
    		if(leftD +1 == k) {
    			System.out.println(root.data);
    		}
    		else {
    			printDepthK(root.right, k-leftD-2);
    		}
    		return 1 + leftD;	
    	}
    	
    	int rightD = nodesAtDistanceKHelper(root.right, target, k);
    	if(rightD != -1)
    	{
    		if(rightD +1 == k) {
    			System.out.println(root.data);
    		}
    		else {
    			printDepthK(root.left, k-rightD-2);
    		}
    		return 1 + rightD;	
    	}
    	
		return -1;
	}

	private static void printDepthK(BinaryTreeNode<Integer> root, int k) 
	{
		if(root == null)
		{
			return;
		}
		if( k == 0)
		{
			System.out.println(root.data);
			return;
		}
		printDepthK(root.left, k-1);
		printDepthK(root.right, k-1);	
	}

	public static void main(String[] args) {
    	BinaryTreeNode<Integer> root = takeInputLevelwise();
    	printLevelwise(root);
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter value of K: ");
    	int k = s.nextInt();
    	System.out.println("Enter the target node: ");
    	int node = s.nextInt();
    	nodesAtDistanceK(root, node, k); 	
	}

}
