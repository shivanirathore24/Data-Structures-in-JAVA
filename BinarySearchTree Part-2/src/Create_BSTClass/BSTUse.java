package Create_BSTClass;

public class BSTUse {
	public static void main(String[] args) {
		BST b = new BST();
		b.insert(5);
		b.insert(2);
		b.insert(7);
		b.insert(1);
		b.insert(3);
		b.insert(6);
		b.insert(8);
		
		b.printTree();
		
		System.out.println(b.search(5));
		b.remove(5);
		System.out.println(b.search(5));
		
		b.printTree();
		System.out.println(b.size());
		
		System.out.println();
		b.printTree();
		b.removeWay2(2);
		
		System.out.println();
		b.printTree();
		
	}
}
