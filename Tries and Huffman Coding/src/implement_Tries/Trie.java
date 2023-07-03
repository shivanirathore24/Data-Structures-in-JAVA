package implement_Tries;

public class Trie 
{
	private TrieNode root;
	public Trie()
	{
		root = new TrieNode('\0');
	}
	
	public void add(String word)
	{
		addHelper(root,word);
	}
	
	private void addHelper(TrieNode root, String word) 
	{
		if(word.length() == 0)
		{
			root.isTerminal = true;
			return;
		}
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];	
		if(child == null)
		{
			child = new TrieNode(word.charAt(0));  //creating node if not present
			root.children[childIndex] = child;  //adding into array
			root.childCount++;
		}
		addHelper(child,word.substring(1));
	}

	
	public boolean search(String word)
	{
		return searchHelper(root, word);
	}
	
	private boolean searchHelper(TrieNode root, String word) 
	{
		if(word.length() == 0)
		{
			return root.isTerminal;
		}
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];
		if(child == null)
		{
			return false;
		}
		return searchHelper(child, word.substring(1));
	}

	
	public void remove(String word)
	{
		removeHelper(root, word);
	}

	private void removeHelper(TrieNode root, String word) 
	{
		if(word.length() == 0)
		{
			root.isTerminal = false;
			return;
		}
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];
		if(child == null)
		{
			return;
		}
		removeHelper(child, word.substring(1));	
		// We can remove child node only if it is non terminating and its number of children are 0	
		if(!child.isTerminal && child.childCount == 0)  //to remove useless node from m/m
		{
			root.children[childIndex] = null;
			root.childCount--;
		}
	}
}
