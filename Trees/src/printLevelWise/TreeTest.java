package printLevelWise;

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
	
	public static void main(String[] args) {
		TreeNode<Integer> root = takeInput();
		printLevelWise(root);	
	}
}
