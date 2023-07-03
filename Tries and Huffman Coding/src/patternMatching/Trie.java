package patternMatching;
/*
 * Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not.
 * Return true if the pattern is present and false otherwise.
Sample Input 1 :
abc def ghi cba
de
Sample Output 1 :
true
Sample Input 2 :
abc def ghi hg
hi
Sample Output 2 :
true
Sample Input 3 :
abc def ghi hg
hif
Sample Output 3 :
false
 */
import java.util.ArrayList;

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
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];	
		if(child == null)
		{
			child = new TrieNode(word.charAt(0));  //creating node if not present
			root.children[childIndex] = child;  //adding into array
			root.childCount++;
		}
		 return addHelper(child,word.substring(1));
	}

	/*
	 * Time Complexity : O(N * M)
	 * Space Complexity : O(N * M)
	 * where N is the number of words in the Trie and M is the is average word length
	 */
	public boolean patternMatching(ArrayList<String> input, String pattern)
	{
		for(int i = 0; i < input.size(); i++)
		{
			String string = input.get(i);
			Trie suffixTrie = new Trie();
			for(int j = 0; j < string.length(); j++)
			{
				suffixTrie.add(string.substring(j));
			}
			if(suffixTrie.search(pattern))
			{
				return true;
			}
		}
		return false;
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
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
