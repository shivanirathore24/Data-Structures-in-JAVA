package checkIsBST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import searchNodeInBST.BinaryTreeNode;

public class BSTUse 
{
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
	
	//way-1 TC:O(n^2)
	public static boolean isBST1(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return true;
		}
		
		int leftMax = maximum(root.left);
		if(leftMax >= root.data) {
			return false;
		}
		
		int rightMin = minimum(root.right);
		if(rightMin < root.data)
		{
			return false;
		}
		
		boolean isLeftBST = isBST1(root.left);
		boolean isRightBST = isBST1(root.right);
		return isLeftBST && isRightBST;
	}
	
    private static int minimum(BinaryTreeNode<Integer> root) 
    {
		if(root == null)
		{
			return Integer.MAX_VALUE;
		}
		int leftmin = minimum(root.left);
		int rightmin = minimum(root.right);
		return Math.min(root.data, Math.min(leftmin, rightmin));
	}

	private static int maximum(BinaryTreeNode<Integer> root) 
	{
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int leftmax = maximum(root.left);
		int rightmax = maximum(root.right);
		return Math.max(root.data, Math.max(leftmax, rightmax));
	}
	
	//way2 TC: O(n)
	public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		
		IsBSTReturn leftAns = isBST2(root.left);
		IsBSTReturn rightAns = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		
		if(leftAns.max >= root.data)
		{
			isBST = false;
		}
		
		if(rightAns.min < root.data)
		{
			isBST = false;
		}
		
		if(!leftAns.isBST)
		{
			isBST = false;
		}
		
		if(!rightAns.isBST)
		{
			isBST = false;
		}
		IsBSTReturn ans = new IsBSTReturn(min,max,isBST);
		return ans;
	}
	
	//way3 TC:O(n)
	public static boolean isBST3(BinaryTreeNode<Integer> root, int minRange,int maxRange)
	{
		if(root == null)
		{
			return true;
		}
		
		if(root.data <minRange || root.data > maxRange)
		{
			return false;
		}
		
		boolean isLeftWithinRange = isBST3(root.left, minRange, root.data -1);
		boolean isRightWithinRange = isBST3(root.right, root.data, maxRange);
		return isLeftWithinRange && isRightWithinRange;
	}

	public static void main(String[] args)
    {
    	//BinaryTreeNode<Integer> root = takeInputLevelwise();
    	
    	//taking predefined BST input 
    	int inOrder[] = {1, 2, 3, 4, 5, 6, 7};  
    	int preOrder[] = {4, 2, 1, 3, 6, 5, 7};
    	BinaryTreeNode<Integer> root =  buildTreeUsingInorderPreorder(preOrder,inOrder);
    	printLevelwise(root); 	
    	System.out.println(isBST1(root));
    	System.out.println();
    	
    	//taking predefined non BST input
    	int inOrder2[] = {1, 2, 3, 4, 8, 6, 7};  
    	int preOrder2[] = {4, 2, 1, 3, 6, 8, 7};
    	BinaryTreeNode<Integer> root2 =  buildTreeUsingInorderPreorder(preOrder2,inOrder2);
    	printLevelwise(root2); 	
    	System.out.println(isBST1(root2)); 
    	
    	//way2
    	IsBSTReturn ans1 = isBST2(root);
    	System.out.println(ans1.min+" "+ans1.max+" "+ans1.isBST); 
    	IsBSTReturn ans2 = isBST2(root2);
    	System.out.println(ans2.min+" "+ans2.max+" "+ans2.isBST);
    	
    	//way3
    	System.out.println(isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    	System.out.println(isBST3(root2, Integer.MIN_VALUE, Integer.MAX_VALUE));	
    }
}
