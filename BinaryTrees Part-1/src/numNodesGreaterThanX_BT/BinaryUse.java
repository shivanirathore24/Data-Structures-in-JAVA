/*
 8: For a given a binary tree of integers and an integer X, 
 find and return the total number of nodes of the given binary tree 
 which are having data greater than X.
 */

package numNodesGreaterThanX_BT;

import java.util.Scanner;

public class BinaryUse {

	public static void printTreeDetailed(BinaryTreeNode<Integer> root)
	{
		if(root == null)  //base-case
		{
			return;
		}
		System.out.print(root.data+": ");
		if(root.left != null)
		{
			System.out.print("L" + root.left.data+ ", ");
		}
		if(root.right != null)
		{
			System.out.print("R"+ root.right.data);
		}
		System.out.println();
		
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}

	public static  BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft)
	{
		if(isRoot)
		{
			System.out.println("Enter root data:");
		}
		else {
			if(isLeft)
			{
				System.out.println("Enter left child of "+parentData);
			}
			else {
				System.out.println("Enter right child of "+parentData);
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1)
		{
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
		BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);
		root.left = leftChild;
		root.right = rightChild;
		
		return root;
	}
	
	/*
	 Time Complexity: O(N)
	 Space Complexity : O(H)
	 where N is the number of nodes in the input tree & H is the height of tree.
	 */
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x)
	{
		if(root == null)
		{
			return 0;
		}
//		int count = 0;
//        if (root.data > x) {
//            count++;
//        }
		int count = (root.data > x) ? 1:0;
        count += countNodesGreaterThanX(root.left, x);
        count += countNodesGreaterThanX(root.right, x);
        return count;
	}
	
	public static void main(String[] args) 
	{
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
		printTreeDetailed(root);
		int x = 5;
		System.out.println("Number of nodes Greater than "+x+ " is "+countNodesGreaterThanX(root,x));
	}

}
