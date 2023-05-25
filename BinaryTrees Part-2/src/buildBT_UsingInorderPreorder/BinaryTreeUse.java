package buildBT_UsingInorderPreorder;

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
    
    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
		BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(preOrder , inOrder, 0 , preOrder.length -1 , 0, inOrder.length -1);
		return root;
	}

	public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int [] preOrder , int[] inOrder, int siPre, int eiPre, int siIn, int eiIn)
	{
		if(siPre > eiPre)
		{
			return null;
		}

		int rootData = preOrder[siPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int rootIndex = -1;
		for(int i = siIn; i<= eiIn;i++)
		{
			if(inOrder[i]== rootData)
			{
				rootIndex = i;
				break;
			}
		}

		//assuming that root index actually present in inOrder

		int siPreLeft = siPre + 1;
		int eiPreLeft;
		int siPreRight;
		int eiPreRight = eiPre;
		int siInLeft = siIn;
		int eiInLeft = rootIndex - 1;
		int siInRight = rootIndex + 1;
		int eiInRight = eiIn;

		int leftSubtreeLength = eiInLeft - siInLeft +1;

		eiPreLeft = siPreLeft + leftSubtreeLength -1;
		siPreRight = eiPreLeft + 1;

		BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(preOrder, inOrder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(preOrder, inOrder, siPreRight, eiPreRight, siInRight, eiInRight);

		root.left = left;
		root.right = right;
		 return root;

	}

    public static void main(String[] args)
    {
    	//BinaryTreeNode<Integer> root = takeInputLevelwise();
    	int inOrder[] = {4, 2, 5, 1, 3};
    	int preOrder[] = {1, 2, 4, 5, 3};
    	BinaryTreeNode<Integer> root =  buildTreeUsingInorderPreorder(preOrder,inOrder);
    	printLevelwise(root); 	
    }
}
