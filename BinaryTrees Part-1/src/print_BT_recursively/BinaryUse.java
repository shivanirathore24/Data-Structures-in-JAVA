// 2: Print BinaryTree Recursively

package print_BT_recursively;
public class BinaryUse {
	
	public static void printTree1(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		System.out.println(root.data);
		printTree1(root.left);
		printTree1(root.right);
		
//		if(root.left != null)   // this logic will fail if root == null
//		{
//			printTree1(root.left);
//		}
//		if(root.right != null)
//		{
//			printTree1(root.right);
//		}
	}
	
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
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		
		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
		root.left = rootLeft;
		root.right = rootRight;
		
		BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
		rootLeft.right = twoRight;
		rootRight.left = threeLeft;
		
		//printTree1(root);
		printTreeDetailed(root);
	}

}
