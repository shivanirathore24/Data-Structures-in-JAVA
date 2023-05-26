/*
 * For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum
 *  of all the node data along the path is equal to K.
Sample Input 1:
2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
k = 13
Sample Output 1:
2 3 4 4 
2 3 8
 */
package assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import buildBT_UsingInorderPreorder.BinaryTreeNode;

public class RootToLeafPathsSumToK {
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
    
    //Way-1
    public static void rootToLeafPathsSumToKWay1(BinaryTreeNode<Integer> root, int k)
    {
        List<Integer> path = new ArrayList<>();
        rootToLeafPathsSumToKHelper(root, k, path);
    }

    private static void rootToLeafPathsSumToKHelper(BinaryTreeNode<Integer> node, int k, List<Integer> path) 
    {
        if (node == null)
            return;

        path.add(node.data); // Add the current node to the path

        if (node.left == null && node.right == null && k == node.data) {
            // Leaf node with sum equal to k, print the path
            printPath(path);
        } else {
            // Recurse on the left and right subtrees
            rootToLeafPathsSumToKHelper(node.left, k - node.data, new ArrayList<>(path));
            rootToLeafPathsSumToKHelper(node.right, k - node.data, new ArrayList<>(path));
        }
    }

    private static void printPath(List<Integer> path) 
    {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    
    //Way-2
    /*
     * Time Complexity : O(N)  where N is no. of nodes in tree
     * Space Complexity : O(H)  where H is height of tree
     * H is equal to log(N) for balance tree
     */	
    public static void rootToLeafPathsSumToKWay2(BinaryTreeNode<Integer> root, int k)
    {
    	rootToLeafPathsSumToK(root, k, "",0);
    }
    private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k , String path, int currSum)
    {
    	if(root == null)
    	{
    		return;
    	}
    	if(root.left == null && root.right == null)
    	{
    		currSum += root.data;
    		if(currSum == k)
    		{
    			System.out.println(path + root.data + " ");
    		}
    	}
    	
    	rootToLeafPathsSumToK(root.left, k, (path + root.data + " "), (currSum + root.data));
    	rootToLeafPathsSumToK(root.right, k, (path + root.data + " "),(currSum + root.data));	
    }
    
    public static void main(String[] args) {
    	BinaryTreeNode<Integer> root = takeInputLevelwise();
    	printLevelwise(root);
    	System.out.println("Number of Paths :");
    	rootToLeafPathsSumToKWay1(root,13);
    	rootToLeafPathsSumToKWay2(root,13);
    	
	}

}
