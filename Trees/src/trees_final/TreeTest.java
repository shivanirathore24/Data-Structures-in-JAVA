package trees_final;

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
	
	public static void printTree1(TreeNode<Integer> root) {  //preOrder
		if(root == null)
		{
			return;
		}
		
		//printing as pre-order
		System.out.print(root.data+" ");
		for(int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			printTree1(child);
		}
	}
	
	//better way
	public static void printTree2(TreeNode<Integer> root) {
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
			printTree2(child);
		}
	}
	
	public static void printLevelWise(TreeNode<Integer> root)
	{ 
		if (root == null)
            return;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> current = queue.poll();
                System.out.print(current.data + " ");

                for (int j = 0; j < current.children.size(); j++) {
                    queue.offer(current.children.get(j));
                }
            }

            System.out.println();
        }
	}
	
	public static int numberOfNodes(TreeNode<Integer> root)
	{
		int count = 1;
		for(int i = 0; i< root.children.size(); i++)
		{
			int childCount = numberOfNodes(root.children.get(i));
			count += childCount;
		}
		return count;
	}
	
	public static int sumOfAllNodes(TreeNode<Integer> root)
	{
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		int sum = 0;
		for(int i = 0; i < root.children.size(); i++)
		{
//			int childSum = sumOfAllNodes(root.children.get(i));
//			sum += childSum;
			sum += sumOfAllNodes(root.children.get(i));
		}
		return root.data + sum;
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
	

	/*
     * Time complexity : O(N) where N is number of nodes in input tree
     * Space complexity : O(H) where H is height of input tree
     */
	public static int getHeight(TreeNode<Integer> root) {
		if(root == null)
		{
			return 0;
		}
		int ans = 0;
		for(TreeNode<Integer> child : root.children)
		{
			int childHeight = getHeight(child);
			//ans = Math.max(ans, childHeight);
			
			//or
			if(childHeight > ans)
			{
				ans = childHeight;
			}	
		}
		return ans + 1;
	}
	
	public static int countLeafNodes(TreeNode<Integer> root) {
		if(root == null)
		{
			return 0;
		}
		
		if(root.children.size() == 0) {
			return 1;
		}
		
		int count = 0;
		for(TreeNode<Integer> child : root.children) {
			count += countLeafNodes(child);
		}
		return count;
	}
	
	public static void printPostOrderTraversal(TreeNode<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		
		for(TreeNode<Integer> child: root.children) {
			printPostOrderTraversal(child);
		}
		System.out.print(root.data+" ");
	}
	
	
	public static void main(String[] args) {
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
		
		//TreeNode<Integer> root = takeInput();
		//printTree1(root);   //preorder
		printTree2(root);
		//printLevelWise(root);
		
		System.out.println("Number of nodes: "+numberOfNodes(root));
		System.out.println("Sum of nodes: "+sumOfAllNodes(root));
		System.out.println("No. of nodes greater than X: "+numNodeGreater(root,3));
		System.out.println("Height of tree: "+getHeight(root));
		System.out.println("Count leaf nodes: "+ countLeafNodes(root));
		
		System.out.println("Post-Order Traversal: ");
		printPostOrderTraversal(root);
		
	}

}
