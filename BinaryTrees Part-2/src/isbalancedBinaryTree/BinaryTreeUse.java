package isbalancedBinaryTree;

import java.util.Scanner;

public class BinaryTreeUse
{
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data");
        }
        else{
            if(isLeft){
              System.out.println("Enter left child of "+ parentData);
            }
            else{
              System.out.println("Enter right child of"+ parentData);
            }
        }
        Scanner s= new Scanner(System.in);
        int rootData = s.nextInt();

        if(rootData==-1){
            return null;
        }

        BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild= takeTreeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rightChild= takeTreeInputBetter(false, rootData, false);
        root.left= leftChild;
        root.right= rightChild;
        return root;
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
    
    public static int height(BinaryTreeNode<Integer> root)
    {
    	if(root == null)
    	{
    		return 0;
    	}
    	int leftHeight = height(root.left);
    	int rightHeight = height(root.right);
    	return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static boolean isBalanced(BinaryTreeNode<Integer> root)  // Time Complexity - O(n^2)
    {
    	if(root == null)
    	{
    		return true;
    	}	
    	int leftHeight = height(root.left);
    	int rightHeight = height(root.right);
    	if(Math.abs(leftHeight - rightHeight) > 1)
    	{
    		return false;
    	}
    	
    	boolean isLeftBalanced = isBalanced(root.left);
    	boolean isRightBalanced = isBalanced(root.right);
    	
    	return isLeftBalanced && isRightBalanced;	
    }
    
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) // Time Complexity - O(n)
    {
    	if(root == null)
    	{
    		int height = 0;
    		boolean isBal = true;
    		BalancedTreeReturn ans = new BalancedTreeReturn();
    		ans.height = height;
    		ans.isBalanced = isBal;
    		return ans;
    	}
    	
    	BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
    	BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
    	boolean isBal = true;
    	int height = 1 + Math.max(leftOutput.height, rightOutput.height);
    	
    	if(Math.abs(leftOutput.height - rightOutput.height) > 1)	
    	{
    		isBal = false;
    	}
    	
    	if(!leftOutput.isBalanced || !rightOutput.isBalanced)
    	{
    		isBal = false;
    	}
    	
    	BalancedTreeReturn ans = new BalancedTreeReturn();
    	ans.height =height;
    	ans.isBalanced = isBal;
    	return ans;
    }
    

    public static void main(String[] args)
    {

        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);
        
        System.out.println("Is balanced ? : "+ isBalanced(root));
        System.out.println("Is balanced ? : "+ isBalancedBetter(root).isBalanced);
        
        

    }
}
