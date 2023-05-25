package binarytree_final;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import buildBT_UsingInorderPreorder.BinaryTreeNode;

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

    public static BinaryTreeNode<Integer> takeTreeInput(){
        System.out.println("Enter root data");
        Scanner s= new Scanner(System.in);
        int rootData = s.nextInt();

        if(rootData==-1){
            return null;
        }

        BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild= takeTreeInput();
        BinaryTreeNode<Integer> rightChild= takeTreeInput();
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
    
    
    /*
    * Time complexity : O(N) 
    * Space complexity : O(N) 
    * where N is number of nodes in input tree
    */
    public static BinaryTreeNode<Integer> takeInputLevelwise()  //iterative way
    {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter root Data: ");
    	int rootData = s.nextInt();
    	if(rootData == -1)
    	{
    		return null;
    	}
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);  //creating node
    	Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
    	pendingChildren.add(root);
    	
    	while(!pendingChildren.isEmpty())
    	{
    		BinaryTreeNode<Integer> front = pendingChildren.poll();
    		System.out.println("Enter left child of "+front.data);
    		int left = s.nextInt();
    		if(left != -1)
    		{
    			BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
    			front.left = leftChild;
    			pendingChildren.add(leftChild);
    		}
    		
    		System.out.println("Enter right child of "+front.data);
    		int right = s.nextInt();
    		if(right != -1)
    		{
    			BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
    			front.right = rightChild;
    			pendingChildren.add(rightChild);
    		}
    	}//end of while
    	return root;
    }
    
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

    public static int numNodes(BinaryTreeNode<Integer> root){
        if(root==null) return 0;
        int leftNodeCount= numNodes(root.left);
        int rightNodeCount= numNodes(root.right);
        return 1+leftNodeCount+rightNodeCount;
    }
    
    public static int largest(BinaryTreeNode<Integer> root){
        if(root==null){
            return -1;
        }
        int largestLeft= largest(root.left);
        int largestRight= largest(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }
    
    /*
     * Time complexity : O(N) where N is number of nodes in input tree
     * Space complexity : O(H) where H is height of input tree
     */
    public static int height(BinaryTreeNode<Integer> root)
	{
		if(root == null)  //base case
		{
			return 0;
		}
		int leftHeight = height(root.left);  //recursive call
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;  //small calculation
	}
    
    public static int numLeaves(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        if(root.left==null &&root.right==null){
            return 1;
        }
        return numLeaves(root.left)+numLeaves(root.right);
      }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
            return;
        }

        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right, k-1);
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
    
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root)  // Time Complexity - O(n)
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
    
   
    /*
    * Time complexity : O(n^2) where n is number of nodes in input tree
    * Space complexity : O(H) where H is height of input tree
    */
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
 
    public static void main(String[] args){
//        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
//        printTreeDetailed(root);
    	
        BinaryTreeNode<Integer> root = takeInputLevelwise();
  	  	printLevelwise(root);
 
  	  	System.out.println("Number of nodes :"+numNodes(root));
        System.out.println("Largest Node is : " + largest(root));
        System.out.println("Height of tree : "+height(root));
        System.out.println("Number of Leaves : "+numLeaves(root));
        System.out.print("Print at depth K : ");
        printAtDepthK(root,2);
        System.out.println();
      
	    System.out.println("Is balanced ? : "+ isBalanced(root));
	    System.out.println("Is balanced ? : "+ isBalancedBetter(root).isBalanced);
        
        //root1 is required when there is only node i.e root which is leaf so,  after delete it returns null so we need to store null value
        BinaryTreeNode<Integer> root2 =removeLeaves(root);
        System.out.println("After Removing Leaves :");
        printTreeDetailed(root2);
        
//      int inOrder[] = {4, 2, 5, 1, 3};
//    	int preOrder[] = {1, 2, 4, 5, 3};
//    	BinaryTreeNode<Integer> root3 =  buildTreeUsingInorderPreorder(preOrder,inOrder);
//    	printLevelwise(root3);
        
    	 int inOrder[] = {4, 2, 5, 1, 6, 3, 7};
     	 int postOrder[] = {4, 5, 2, 6, 7, 3, 1};
     	 BinaryTreeNode<Integer> root3 =  buildTreeUsingInorderPostorder(postOrder,inOrder);
     	 printLevelwise(root3);

    }
}
