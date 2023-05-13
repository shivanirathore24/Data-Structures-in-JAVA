/*
For a given Binary Tree of type integer and a number X, 
find whether a node exists in the tree with data X or not.
 */

package assignments;
import java.util.Scanner;

public class IsNodePresent 
{
	public static BinaryTreeNode<Integer> takeBinaryTreeInput(boolean isRoot, int parentData,boolean isLeft)
	{
		if(isRoot)
		{
			System.out.println("Enter root data :");
		}
		else {
			if(isLeft)
			{
				System.out.println("Enter left child of "+parentData);
			}
			else
			{
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
		BinaryTreeNode<Integer> leftChild = takeBinaryTreeInput(false, rootData ,true);
		BinaryTreeNode<Integer> rightChild = takeBinaryTreeInput(false, rootData ,false);
		root.left = leftChild;
		root.right = rightChild;
		return root;	
	}
	
	public static void printBinaryTree(BinaryTreeNode<Integer> root)
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
		
		printBinaryTree(root.left);
		printBinaryTree(root.right);
	}
	
	/*
	 Time Complexity: O(N)
	 Space Complexity : O(H)
	 where N is the number of nodes in the input tree & H is the height of tree.
	 H is equal to log(N) for balanced tree.
	 */
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) 
	{
		if (root == null)
		{
			 return false;
		}
        if (root.data == x)
        {
        	 return true;
        }
//        boolean leftSubtree = isNodePresent(root.left, x);
//        boolean rightSubtree = isNodePresent(root.right, x);
//        return leftSubtree || rightSubtree;
        return isNodePresent(root.left, x) || isNodePresent(root.right, x);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeBinaryTreeInput(true, 0, true);
		printBinaryTree(root);
		System.out.println("Enter node data you want check present or not :");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		System.out.println(isNodePresent(root,x));
	}
		
	

}
	
