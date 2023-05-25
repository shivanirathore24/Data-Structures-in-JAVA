package buildBT_UsingInorderPostorder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse
{  
    public static void printLevelwise(BinaryTreeNode<Integer> root)
    {
    	if(root == null)
    	{
    		return;
    	}
    	Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
    	nodesToPrint.add(root);
    	while(!nodesToPrint.isEmpty()) 
    	{
    		BinaryTreeNode<Integer> front = nodesToPrint.poll();
    		System.out.print(front.data+":");
    		
    		if(front.left != null)
    		{
    			nodesToPrint.add(front.left);
    			System.out.print("L:"+front.left.data);
    		}
    		else {
    			System.out.print("L:-1");
    		}
    		
    		if(front.right != null)
    		{
    			nodesToPrint.add(front.right);
    			System.out.print(",R:"+front.right.data);
    		}
    		else {
    			System.out.print(",R:-1");
    		}
    		
    		System.out.println();
    	} // end of while
    }
    
    
    /*
     * Time complexity : O(n^2) where n is number of nodes in input tree
     * Space complexity : O(H) where H is height of input tree
     */
    public static BinaryTreeNode<Integer> buildTreeUsingInorderPostorder(int[] postOrder, int[] inOrder) {
        int postStart = 0;
        int postEnd = postOrder.length - 1;
        int inStart = 0;
        int inEnd = inOrder.length - 1;

        return buildTreeFromPostInHelper(postOrder, postStart, postEnd, inOrder, inStart, inEnd);
    }

    private static BinaryTreeNode<Integer> buildTreeFromPostInHelper(int[] postOrder, int postStart, int postEnd,
                                                           int[] inOrder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // The last element in the postorder array is the root
        int rootValue = postOrder[postEnd];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootValue);

        // Find the root index in the inorder array
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // Calculate the sizes of the left and right subtrees
        int leftSubtreeSize = rootIndex - inStart;
        int rightSubtreeSize = inEnd - rootIndex;

        // Recursively build the left and right subtrees
        root.left = buildTreeFromPostInHelper(postOrder, postStart, postStart + leftSubtreeSize - 1,
                                    inOrder, inStart, rootIndex - 1);
        root.right = buildTreeFromPostInHelper(postOrder, postEnd - rightSubtreeSize, postEnd - 1,
                                     inOrder, rootIndex + 1, inEnd);
        return root;
    }


    public static void main(String[] args)
    {
    	//BinaryTreeNode<Integer> root = takeInputLevelwise();
    	int inOrder[] = {4, 2, 5, 1, 6,3, 7};
    	int postOrder[] = {4, 5, 2, 6, 7, 3, 1};
    	BinaryTreeNode<Integer> root =  buildTreeUsingInorderPostorder(postOrder,inOrder);
    	printLevelwise(root); 	
    }
}
