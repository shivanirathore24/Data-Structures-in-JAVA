package removeLeafNodes_BT;

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
    
    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root)
    {
    	if(root == null)
    	{
    		return null;
    	}
    	if(root.left == null && root.right == null)
    	{
    		return null;
    	}
    	root.left = removeLeaves(root.left);
    	root.right = removeLeaves(root.right);
    	return root;
    }

    public static void main(String[] args)
    {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);
        
        //root1 is required when there is only node i.e root which is leaf so, after delete it returns null so we need to store null value
        BinaryTreeNode<Integer> root1 =removeLeaves(root);
        System.out.println("After Removing Leaves :");
        printTreeDetailed(root1);
    }
}
