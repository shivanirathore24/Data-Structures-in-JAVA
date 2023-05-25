/*The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
*/

package diameterOfBinaryTree;
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
    
    
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root)  //Time Complexity : O(N^2)
    {
		if (root == null) 
		{
			return 0;
		}
		int leftHeight = height(root.left);
	    int rightHeight = height(root.right);

	    int leftDiameter = diameterOfBinaryTree(root.left);
	    int rightDiameter = diameterOfBinaryTree(root.right);

	    int diameter = Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));

	    return diameter;
	}
   
    //Better Way
    /*
     * Time complexity : O(N) where N is number of nodes in input tree
     * Space complexity : O(H) where H is height of input tree
     */
    public static int diameterOfBinaryTreeBetter(BinaryTreeNode<Integer> root)
    {
    	Pair pair = diameterHelper(root);
    	return pair.diameter;
    }
    
    private static Pair diameterHelper(BinaryTreeNode<Integer> root)
    {
    	if(root == null)
    	{
    		Pair pair = new Pair(0,0);
    		return pair;
    	}
    	Pair leftPair = diameterHelper(root.left);
    	Pair rightPair = diameterHelper(root.right);
    	
    	int leftDiameter = leftPair.diameter;
    	int rightDiameter = rightPair.diameter;
    	/* 'dist' denotes the longest distance b/w deepest node of the left subtree
    	 *  & deepest node of the right subtree
    	 */
    	int dist = leftPair.height + rightPair.height + 1;
    	
    	int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));  	
    	int height = Math.max(leftPair.height, rightPair.height) + 1;
    	
//    	Pair pair = new Pair(diameter, height);
//    	return pair;
    	return (new Pair(diameter, height));
    }
    

    public static void main(String[] args)
    {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);
        
        System.out.println("Diameter : "+diameterOfBinaryTree(root));
        System.out.println("Diameter : "+ diameterOfBinaryTreeBetter(root));
    }
}
