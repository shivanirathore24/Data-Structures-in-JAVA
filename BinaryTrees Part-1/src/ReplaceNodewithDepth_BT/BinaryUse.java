/*12: For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
Root is at depth 0, hence the root data is updated with 0. Replicate the same further going down the 
in the depth of the given tree. The modified tree will be printed in the in-order fashion.
*/

package ReplaceNodewithDepth_BT;
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
	public static void changeToDepthTree(BinaryTreeNode<Integer> root)
	{
		changeToDepthTreeHelper(root,0);
	}
	
	private static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int depth)
	{
		if(root == null)
		{
			return;
		}
		root.data = depth;
		changeToDepthTreeHelper(root.left, depth + 1);
		changeToDepthTreeHelper(root.right, depth + 1);
	}
	
	public static void inOrder(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) 
	{
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
		printTreeDetailed(root);
		
		changeToDepthTree(root);
		System.out.print("InOrder Travesal: ");
		inOrder(root);
	}
}
