package countWords_InTrie;
/*
 You are given the Trie class with following functions -
1. insertWord
2. removeWord
Now, you need to create one more function (named "countWords" )
which returns the number of words currently present in Trie in O(1) time complexity.
 */
public class Trie 
{
	private TrieNode root;
	private int numWords;
	
	public Trie()
	{
		root = new TrieNode('\0');
		numWords = 0;
	}
	
	public void add(String word)
	{
		if(addHelper(root,word))
		{
			numWords++;
		}
	}
	
	private boolean addHelper(TrieNode root, String word) 
	{
		if(word.length() == 0)
		{
			if(root.isTerminal) 
			{
				return false;
			}
			else 
			{
				root.isTerminal = true;
				return true;
			}
		}	
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];	
		if(child == null)
		{
			child = new TrieNode(word.charAt(0));  //creating node if not present
			root.children[childIndex] = child;  //adding into array
			root.childCount++;
		}
		 return addHelper(child,word.substring(1));
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
		if(removeHelper(root, word))
		{
			numWords--;
		}
	}

	private boolean removeHelper(TrieNode root, String word) 
	{
		if(word.length() == 0)
		{
			if(root.isTerminal) 
			{
				root.isTerminal = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];
		if(child == null)
		{
			return false;
		}
		 boolean ans = removeHelper(child, word.substring(1));	
		// We can remove child node only if it is non terminating and its number of children are 0	
		if(!child.isTerminal && child.childCount == 0)  //to remove useless node from m/m
		{
			root.children[childIndex] = null;
			root.childCount--;
		}
		return ans;
	}
	
	public int countWords() {
		return numWords;
	}
}
