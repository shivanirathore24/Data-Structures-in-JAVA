package printTree;

public class TreeTest {
	
	public static void printTree1(TreeNode<Integer> root) {
		if(root == null)
		{
			return;
		}
		
		//printing as pre-order
		System.out.print(root.data+" ");
		for(int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			printTree1(child);
		}
	}
	
	//better way
	public static void printTree2(TreeNode<Integer> root) {
		if(root == null)
		{
			return;
		}
		
		//printing as pre-order
		System.out.print(root.data+": ");
		for(int i = 0; i < root.children.size(); i++)
		{
			System.out.print(root.children.get(i).data+" ");
		}
		System.out.println();
		for(int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			printTree2(child);
		}
	}
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(4);
		TreeNode<Integer> node1 = new TreeNode<>(2);
		TreeNode<Integer> node2 = new TreeNode<>(3);
		TreeNode<Integer> node3 = new TreeNode<>(1);
		TreeNode<Integer> node4 = new TreeNode<>(5);
		TreeNode<Integer> node5 = new TreeNode<>(6);
		
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		
		node2.children.add(node4);
		node2.children.add(node5);
		
		printTree1(root);
		System.out.println();
		printTree2(root);
	}

}
