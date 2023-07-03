package patternMatching;

public class TrieNode 
{
	char data;
	boolean isTerminal;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data)
	{
		this.data = data;
		this.isTerminal = false;
		this.children = new TrieNode[26];
		int childCount = 0;
		
	}
}
