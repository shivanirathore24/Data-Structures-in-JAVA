package patternMatching;

import java.util.ArrayList;
import java.util.Scanner;

public class TrieUse 
{
	public static void main(String[] args) {
		Trie t = new Trie();
		ArrayList<String> input = new ArrayList<String>();	
		String[] words = {"abc", "def", "ghi","cba"};
		String pattern = "hif";
		for(int i = 0; i < words.length; i++) {
			
			input.add(words[i]);
		}
		Boolean result = t.patternMatching(input, pattern);
		System.out.println(result);
		
	}

}
