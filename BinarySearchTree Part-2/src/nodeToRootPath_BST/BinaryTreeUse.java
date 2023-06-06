package nodeToRootPath_BST;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse 
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
	
    public static ArrayList<Integer> nodeToRootPathBST(BinaryTreeNode<Integer> root, int x)
    {
    	if(root == null)
    	{
    		return null;
    	}
    	if(root.data == x) 
    	{   	
    		ArrayList<Integer> output = new ArrayList<>();
    		output.add(root.data);
    		return output;		
    	}
    	else if( x < root.data) 
    	{
    		ArrayList<Integer> leftOutput = nodeToRootPathBST(root.left, x);
        	if(leftOutput != null) 
        	{
        		leftOutput.add(root.data);
        		return leftOutput;
        	}
    	}
    	else {
    		ArrayList<Integer> rightOutput = nodeToRootPathBST(root.right, x);
        	if(rightOutput != null)
        	{
        		rightOutput.add(root.data);
        		return rightOutput;
        	}
    	}
    	return null;
    }

    public static void main(String[] args)
    {
    	//BinaryTreeNode<Integer> root = takeInputLevelwise();
    	
    	//taking predefined input 
    	int inOrder[] = {1, 2, 3, 4, 5, 6, 7};  
    	int preOrder[] = {4, 2, 1, 3, 6, 5, 7};
    	BinaryTreeNode<Integer> root =  buildTreeUsingInorderPreorder(preOrder,inOrder);
    	printLevelwise(root);
    	ArrayList<Integer> path = nodeToRootPathBST(root, 1); 
    	if(path == null)
    	{
    		System.out.println("Not found !");
    	}
    	else 
    	{
    		for(int i : path)
    		{
    			System.out.println(i);
    		}
    	}//end of else
    }
}
