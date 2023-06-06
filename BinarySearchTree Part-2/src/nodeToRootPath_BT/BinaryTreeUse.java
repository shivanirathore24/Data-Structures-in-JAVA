package nodeToRootPath_BT;
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
    
    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x)
    {
    	if(root == null)
    	{
    		return null;
    	}
    	if(root.data == x) {   	
    		ArrayList<Integer> output = new ArrayList<>();
    		output.add(root.data);
    		return output;		
    	}
    	
    	ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
    	if(leftOutput != null) {
    		leftOutput.add(root.data);
    		return leftOutput;
    	}
    	
    	ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
    	if(rightOutput != null)
    	{
    		rightOutput.add(root.data);
    		return rightOutput;
    	}
    	return null;
    }

    public static void main(String[] args)
    {
    	BinaryTreeNode<Integer> root = takeInputLevelwise();
    	printLevelwise(root); 	
    	ArrayList<Integer> path = nodeToRootPath(root, 1); 
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
