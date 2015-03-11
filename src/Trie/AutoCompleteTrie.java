/**
 * Write a class that receives in the constructor a vector of strings representing 
 * a browser history (URLs), and a method for "auto-complete":
 * The method that receives a string representing a partial URL 
 * typed by the user and returns a vector of all possible completions of this partial URL (prefix).
 * http://shirleyisnotageek.blogspot.com/2015/02/auto-complete-method.html
 * @author shirleyyoung
 */
package Trie;
import java.util.*;
import java.util.Map.Entry;
public class AutoCompleteTrie {
	protected final Map<Character, AutoCompleteTrie> children;
	protected String value;
	protected boolean isWord = false;
	/**
	 * constructor, initialize a new ACT with empty string as the root
	 * @param value
	 */
	private AutoCompleteTrie(String value) {
		this.value = value;
		children = new HashMap<Character, AutoCompleteTrie> ();
	}
	public AutoCompleteTrie() {
		this("");
	}
	/**
	 * insert a word, this will construct a root to leave path
	 * with the key of each node a character in the word, 
	 * value the prefix of the word till the key character
	 * @param word
	 */
	public void insert (String word) {
		if (word == null)
			throw new IllegalArgumentException("Null string!");
		//this is a reference to the current object: 
		//the object whose method or constructor is being called
		AutoCompleteTrie node = this;
		for (char c : word.toCharArray()) {
			//System.out.println(c + ": " + node.value);
			if (!node.children.containsKey(c))
				node.add(c);
			node = node.children.get(c);
			
		}
		//System.out.println();
		node.isWord = true;
	}
	/**
	 * add a child of the node
	 * the child will have the key the input character
	 * and the value the value of the node + key character
	 * @param c
	 */
	private void add(char c) {
		String val; 
		val = this.value + c;
		children.put(c, new AutoCompleteTrie(val));
	}
	
	/**
	 * search if a word exists in the trie
	 * @param word
	 * @return
	 */
	public boolean find(String word) {
		AutoCompleteTrie node = this;
		for (char c : word.toCharArray()) {
			if (!node.children.containsKey(c)) 
				return false;
			node = node.children.get(c);
		}
		return node.value.equals(word);
	}
	
	/**
	 * input prefix return all possible strings 
	 * with the same prefix in the trie
	 * find the node of the prefix in the trie
	 * call allChildren method and return the list
	 * @param prefix
	 * @return
	 */
	public Collection<String> autoComplete(String prefix) {
		AutoCompleteTrie node = this;
		for (char c : prefix.toCharArray()) {
			if (!node.children.containsKey(c))
				return Collections.emptyList();
			node = node.children.get(c);
		}
		return node.allChildren();
	}
	/**
	 * generate the list of all children of the current node/object
	 * @return
	 */
	private Collection<String> allChildren() {
		List<String> rst = new ArrayList<String> ();
		//if the prefix is also a previous input word, add it to the list
		if (this.isWord) {
			rst.add(this.value);
		}
		//add all children
		for (Entry<Character, AutoCompleteTrie> entry : children.entrySet()) {
			AutoCompleteTrie child = entry.getValue();
			Collection<String> childPrefixes = child.allChildren();
			rst.addAll(childPrefixes);
		}
		return rst;
	}
}
