package main.java.com.saranya.trie;


import java.util.HashMap;

/**
 * Given a list of contacts contact[] of length n where each contact is a string
 * which exist in a phone directory and a query string s. The task is to
 * implement a search query for the phone directory. Run a search query for each
 * prefix p of the query string s (i.e. from index 1 to |s|) that prints all the
 * distinct contacts which have the same prefix as p in lexicographical
 * increasing order. Note: If there is no match between query and contacts,
 * print "0".
 *
 *
 * Example - 
 * Input: n = 3 
 * contact[] = {"gforgeeks", "geeksquiz"} 
 * s = "geek"
 * Output: 
 * Suggestions based on given g are geeksquiz gforgeeks 
 * Suggestions based on given ge are geeksquiz 
 * Suggestions based on given gee are geeksquiz
 * Suggestions based on given geek are geeksquiz
 * 
 */
public class PhoneDirectory {
	
	static TrieNode root;

	static class TrieNode {
		HashMap<Character, TrieNode> child;
		boolean isLastNode;
		public TrieNode() {
			this.child = new HashMap<>();
			for(char c = 'a'; c<='z'; c++) {
				child.put(c, null);
			}
			this.isLastNode = false;
		}
		
	}
	
	private static void insertContacts(String[] contacts) {
		root = new TrieNode();
		for(String contact: contacts) {
			insertContactIntoTrie(contact);
		}
	}
	
	private static void insertContactIntoTrie(String contact) {
		TrieNode trie = root;
		for(int i=0; i<contact.length(); i++) {
			TrieNode nextNode = trie.child.get(contact.charAt(i));
			if(nextNode == null) {
				nextNode = new TrieNode();
				trie.child.put(contact.charAt(i), nextNode);
			}
			trie = nextNode;
			
			if(i==contact.length()-1) {
				trie.isLastNode = true;
			}
		}
	}

	private static void displayContactsForQuery(String query) {
		TrieNode prevNode = root;
		String prefix = "";
		int i;
		for(i=0; i<query.length(); i++) {
			prefix += query.charAt(i);
			char lastChar = query.charAt(i);
			TrieNode currentNode = prevNode.child.get(lastChar);
			
			if(currentNode == null) {
				System.out.println("No matching found for "+prefix);
				i++;
				break;
			}
			
			System.out.println("Suggestions based on given "+prefix+" are ");
			displaySuggestionsFromTrie(currentNode, prefix);
			prevNode = currentNode;
		}
		
		for(;i<query.length(); i++) {
			prefix += query.charAt(i);
            System.out.println("No Results Found for "+ prefix);
		}
	}
	
	private static void displaySuggestionsFromTrie(TrieNode currentNode, String prefix) {
		if(currentNode.isLastNode) {
			System.out.println(prefix);
		}
		
		for(char c='a'; c<='z'; c++) {
			TrieNode nextNode = currentNode.child.get(c);
			if(nextNode != null) {
				displaySuggestionsFromTrie(nextNode, prefix+c);
			}
		}
	}

	public static void main(String[] args) {
		String contacts[] = {"gforgeeks", "geeksquiz"};
		insertContacts(contacts);
		displayContactsForQuery("xyz");
	}
}
