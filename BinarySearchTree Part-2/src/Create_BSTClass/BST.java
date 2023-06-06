package Create_BSTClass;
/*
Implement the BST class which includes following functions -
1. insert -
Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
2. search
Given an element, find if that is present in BST or not. Return true or false.
3. delete/remove -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -
Print the BST in in the following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.
 */
public class BST {
	private BinaryTreeNode<Integer> root;
	private int size;
	
	public int size()
	{
		return size;
	}
	
	/*
	 * Time Complexity : O(H) [ for all operations ]
	 * Space Complexity : O(N)
	 * where N is the number of nodes in the input BST
	 * and H is the height of the input BST
	 */
	public boolean search(int data)
	{
		return searchHelper(root, data);
	}
	
	private static boolean searchHelper(BinaryTreeNode<Integer> root, int data) 
	{	
		if(root==null){
			return false;
		}
		if(root.data==data){
			return true;
		}
		else if(root.data<data){
			return searchHelper(root.right, data);
		}
		else{
			return searchHelper(root.left, data);
		}
	}

	public void insert(int data)
	{
		root = insertHelper(root, data);
		size++;
	}
	
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) 
	{
		if(root == null)
		{
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
			return newNode;
		}
		
		if(root.data >= data){
			root.left = insertHelper(root.left, data);
		}
		else {
			root.right = insertHelper(root.right, data);
		}
		return root;
	}

	//Way-1
	public void remove(int data)
	{
		root = removeHelper(root, data);
		size--;
	}
	
	private BinaryTreeNode<Integer> removeHelper(BinaryTreeNode<Integer> root, int data) 
	{
		if(root == null){
			return null;
		}
		if(data < root.data) {
			root.left = removeHelper(root.left, data);
			return root;
		}
		else if( data > root.data) {
			root.right = removeHelper(root.right, data);
			return root;
		}
		else 
		{
			if(root.left == null && root.right == null){
				return null;
			}
			else if(root.left == null)
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.left;
			}
			else 
			{
				BinaryTreeNode<Integer> minNode = root.right;
				while(minNode.left != null)
				{
					minNode = minNode.left;
				}
				root.data = minNode.data;
				root.right = removeHelper(root.right, minNode.data);
				return root;
			} //end of else
		}//end of else
	}

	//Way-2
	public boolean removeWay2(int data)
	{
		BSTRemoveReturn output = removeWay2Helper(root, data);
		root = output.root;
		if(output.deleted)
		{
			size--;
		}
		return output.deleted;
	}
	
	private static BSTRemoveReturn removeWay2Helper(BinaryTreeNode<Integer> root, int data) 
	{
		if(root == null)
		{
			return new BSTRemoveReturn(null, false);
		}
		if(root.data < data)
		{
			BSTRemoveReturn outputRight = removeWay2Helper(root.right, data);
			root.right = outputRight.root;
			outputRight.root = root;
			return outputRight;	
		}
		if(root.data > data)
		{
			BSTRemoveReturn outputLeft = removeWay2Helper(root.left, data);
			root.left = outputLeft.root;
			outputLeft.root = root;
			return outputLeft;
		}
		
		//when root == data 
		
		// root has 0 children
		if(root.left == null && root.right == null) {
			return new BSTRemoveReturn(null, true);
		}
		
		//root has 1 child
		if(root.left != null && root.right == null)  //left child only
		{
			return new BSTRemoveReturn(root.left, true);
		}
		if(root.left == null && root.right != null)  //right child only
		{
			return new BSTRemoveReturn(root.right, true);
		}
		
		//root has 2 children
		int rightMin = minimum(root.right);
		root.data = rightMin;
		BSTRemoveReturn outputRight = removeWay2Helper(root.right, rightMin);
		root.right = outputRight.root;
		return new BSTRemoveReturn(root, true);
	}
	
	private static int minimum(BinaryTreeNode<Integer> root) 
	{
		if(root == null)
		{
			return Integer.MAX_VALUE;
		}
		int minLeft = minimum(root.left);
		int minRight = minimum(root.right);
		return Math.min(root.data, Math.min(minLeft, minRight));	
	}


	public void printTree()
	{
		printTreeHelper(root);
	}

	private static void printTreeHelper(BinaryTreeNode<Integer> root) 
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data+":");
		if(root.left != null){
			System.out.print("L:"+root.left.data+",");
		}
		
		if(root.right != null) {
			System.out.print("R:"+ root.right.data);
		}
		
		System.out.println();
		printTreeHelper(root.left);
		printTreeHelper(root.right);
	}
	
	

}
