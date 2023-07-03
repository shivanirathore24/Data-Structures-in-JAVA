package palindromPair;

import java.util.ArrayList;
import java.util.Scanner;

public class TrieUse 
{
	public static void main(String[] args) {
		Trie t = new Trie();
		ArrayList<String> input = new ArrayList<String>();	
		String[] words = {"abc", "def", "ghi","cba"};
		//String[] words = {"abc", "def"};
		for(int i = 0; i < words.length; i++) {
			
			input.add(words[i]);
		}
		Boolean result = t.isPalindromePair(input);
		System.out.println(result);
		
	}

}
