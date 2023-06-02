/*
 Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
Note: You don't need to return or print, just change the data of each node.
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25 
 */
package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import searchNodeInBST.BinaryTreeNode;

public class ReplaceWithSumOfGreaterNodes 
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
	
	/*
     * Time Complexity : O(N)  where N is no. of nodes in tree
     * Space Complexity : O(H)  where H is height of tree
     * H is equal to log(N) for balance tree
     */
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root)
	{
		int sum = 0;
		replacewithLargerNodesSum(root,sum);
		
	}
    private static int replacewithLargerNodesSum(BinaryTreeNode<Integer> root, int sum)
    {
    	if(root == null)
    	{
    		return sum;
    	}
    	
    	sum = replacewithLargerNodesSum(root.right, sum);
    	sum += root.data;
    	root.data = sum;
    	sum = replacewithLargerNodesSum(root.left, sum);
    	return sum;	
	}
    
    //way2
    public static void replaceWithLargerNodesSum2(BinaryTreeNode<Integer> root) 
    {
		// Write your code here
		if (root == null)
        return;

		// Perform reverse in-order traversal
	    Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
	    BinaryTreeNode<Integer> curr = root;
	    int sum = 0;

	    while (curr != null || !stack.isEmpty())
	    {
	        // Reach the rightmost node of the current subtree
	        while (curr != null)
	        {
	            stack.push(curr);
	            curr = curr.right;
	        }

	        curr = stack.pop();

	        // Update the node's data with the sum
	        sum += curr.data;
	        curr.data = sum;

	        curr = curr.left;
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
    	replaceWithLargerNodesSum(root);
    	System.out.println("After replacing : ");
    	printLevelwise(root);
    	
//    	replaceWithLargerNodesSum2(root);
//    	System.out.println("After replacing : ");
//    	printLevelwise(root);
    }

}
