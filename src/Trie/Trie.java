package Trie;
import java.util.*;
//import java.util.Map.Entry;
public class Trie {
	private String value;
	private final Map<Character, Trie> children;
	private boolean isWord = false;
	private Trie(String val){
		value = val;
		children = new HashMap<Character, Trie>();
	}
	public Trie(){
		this("");
	}
	
	public void insert(String s){
		if(s == null){
			System.out.println("Null string!");
			return;
		}
		Trie node = this;
		for(char c : s.toCharArray()){
			if(!node.children.containsKey(c))
				node.add(c);
			node = node.children.get(c);
		}
		node.isWord = true;
	}
	private void add(char c){
		children.put(c, new Trie(value + c));
	}
	
	public boolean contains(String s){
		Trie node = this;
		for(char c : s.toCharArray()){
			if(!node.children.containsKey(c))
				return false;
			node = node.children.get(c);
		}
		return node.value.equals(s);
	}
	public Collection<String> suffixes(String prefix){
		Trie node = this;
		for(char c : prefix.toCharArray()){
			if(!node.children.containsKey(c))
				return Collections.emptyList();
			node = node.children.get(c);
		}
		return node.allChildren();
	}
	private Collection<String> allChildren(){
		List<String> rst = new ArrayList<String>();
		if(isWord)
			rst.add(value);
		for(Trie child : children.values()){
			rst.addAll(child.allChildren());
		}
		return rst;
	}
}
