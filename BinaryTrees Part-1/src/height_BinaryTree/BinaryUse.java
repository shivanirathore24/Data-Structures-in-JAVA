// 9: Height of BinaryTree
 /* For eg:     10
             /      \
            20      30
          /    \
         40    50

Height of the given tree is 3. 
Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.
*/

package height_BinaryTree;
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
	public static int height(BinaryTreeNode<Integer> root)
	{
		if(root == null)  //base case
		{
			return 0;
		}
		int leftHeight = height(root.left);  //recursive call
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;  //small calculation
	}
	
	public static void main(String[] args) 
	{
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
		printTreeDetailed(root);
		System.out.println("Height of tree : "+height(root));
	}

}
