// 11: Print element at depth K

package printNodesAtDepthK;
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
	
	public static void printAtDepthK(BinaryTreeNode<Integer> root, int k)
	{
		if(root == null)
		{
			return;
		}
		if(k == 0)
		{
			System.out.print(root.data+" ");
			return;
		}
		printAtDepthK(root.left, k-1);
		printAtDepthK(root.right, k-1);	
	}

	public static void main(String[] args) 
	{
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
		printTreeDetailed(root);
		
		System.out.print("Print Element at depth K :");
		printAtDepthK(root,2);	
	}
}
