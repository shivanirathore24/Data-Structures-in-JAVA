package create_binarytree_node;

public class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	
	public BinaryTreeNode( T data)
	{
		this.data = data;
	}
}
