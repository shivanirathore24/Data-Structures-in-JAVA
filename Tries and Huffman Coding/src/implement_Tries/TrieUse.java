package implement_Tries;

public class TrieUse 
{
	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("SHIV");
		t.add("NEER");
		t.add("SHIVANI");
		t.add("ABHI");
		
		System.out.println(t.search("ABHI"));
		t.remove("ABHI");
		System.out.println(t.search("ABHI"));
		
	}

}
