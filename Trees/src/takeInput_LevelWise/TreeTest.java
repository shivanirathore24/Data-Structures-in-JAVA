package takeInput_LevelWise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTest 
{
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
	
	public static void main(String[] args) {
		TreeNode<Integer> root = takeInput();
		printTree(root);	
	}
}
