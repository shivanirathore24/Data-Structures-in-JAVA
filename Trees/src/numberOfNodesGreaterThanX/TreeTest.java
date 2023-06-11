package numberOfNodesGreaterThanX;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTest 
{
	public static TreeNode<Integer> takeInput()
	{
		Scanner s = new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		System.out.println("Enter the root data:");
		int rootData = s.nextInt();
		if(rootData == -1)
		{
			return null;
		}
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> front = pendingNodes.remove();
			System.out.println("Enter the no. of children for: " + front.data);
			int numChild = s.nextInt();
			for(int i = 0; i < numChild; i++)
			{
				System.out.println("Enter the "+i+"th child data for: "+front.data);
				int childData = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<>(childData);
				front.children.add(childNode);
				pendingNodes.add(childNode);
			}
		}
		return root;
	}
	
	public static void printTree(TreeNode<Integer> root) {
		if(root == null)
		{
			return;
		}
		
		//printing as pre-order
		System.out.print(root.data+": ");
		for(int i = 0; i < root.children.size(); i++)
		{
			System.out.print(root.children.get(i).data+" ");
		}
		System.out.println();
		for(int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			printTree(child);
		}
	}
	
	public static int numNodeGreater(TreeNode<Integer> root,int x)
	{
		// Write your code here		
		if(root == null)
		{
			return 0;
		}

		int count = 0;
		if(root.data > x)
		{
			count++;
		}
//		for( int i = 0; i < root.children.size(); i++)
//		{
//			count += numNodeGreater(root.children.get(i), x);
//		}
		
		for(TreeNode<Integer> child : root.children) 
		{
			count = count + numNodeGreater(child,x);
		}		
		return count;
	}
	
	
	public static void main(String[] args) {
		//TreeNode<Integer> root = takeInput();
		TreeNode<Integer> root = new TreeNode<>(4);
		TreeNode<Integer> node1 = new TreeNode<>(2);
		TreeNode<Integer> node2 = new TreeNode<>(3);
		TreeNode<Integer> node3 = new TreeNode<>(1);
		TreeNode<Integer> node4 = new TreeNode<>(5);
		TreeNode<Integer> node5 = new TreeNode<>(6);
		
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		
		node2.children.add(node4);
		node2.children.add(node5);
		printTree(root);
		System.out.println("No. of nodes greater than X: "+numNodeGreater(root,3));
	}
}
