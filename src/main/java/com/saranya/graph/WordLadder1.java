package main.java.com.saranya.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two distinct words startWord and targetWord, and a list denoting
 * wordList of unique words of equal lengths. Find the length of the shortest
 * transformation sequence from startWord to targetWord. Keep the following
 * conditions in mind:
 * 
 * A word can only consist of lowercase characters. Only one letter can be
 * changed in each transformation. Each transformed word must exist in the
 * wordList including the targetWord. startWord may or may not be part of the
 * wordList The second part of this problem can be found here.
 * 
 * Note: If no possible way to transform sequence from startWord to targetWord
 * return 0
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * wordList = {"des","der","dfr","dgt","dfs"} 
 * startWord = "der",
 * targetWord= "dfs", 
 * Output: 3 
 * Explanation: The length of the smallest transformation sequence from "der" to "dfs" is 3 i,e "der" -> "dfr" -> "dfs".
 *
 */
class WordPair {
	String first;
	int second;
	public WordPair(String first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class WordLadder1 {

	public static void main(String[] args) {
		String startWord = "toon", targetWord = "plea";
        String[] wordList = {"poon", "plee", "same", "poie","plea","plie","poin"};
        System.out.println(findLadderSteps(startWord, targetWord, wordList));
	}

	private static int findLadderSteps(String startWord, String targetWord, String[] wordList) {
		Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
		Queue<WordPair> wordLadder = new LinkedList<>();
		wordLadder.add(new WordPair(startWord, 1));
		
		while(!wordLadder.isEmpty()) {
			String word = wordLadder.peek().first;
			int steps = wordLadder.peek().second;
			wordLadder.remove();
			
			if(word.equals(targetWord)) {
				return steps;
			}
			wordSet.remove(word);
			for(int i=0; i<word.length(); i++) {
				for(char ch='a'; ch<='z'; ch++) {
					char[] replacedArray = word.toCharArray();
					replacedArray[i]=ch;
					String replacedString = new String(replacedArray);
					
					if(wordSet.contains(replacedString)) {
						wordLadder.add(new WordPair(replacedString, steps+1));
					}
				}
			}
		}
		return 0;
	}
}
