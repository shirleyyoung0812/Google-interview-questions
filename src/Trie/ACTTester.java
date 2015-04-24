package Trie;

import java.util.Collection;

public class ACTTester {

	public static void main(String[] args) {
		Trie root = new Trie();
		root.insert("taylor expansion");
		root.insert("taylor swift");
		root.insert("taylor kinney");
		root.insert("taylor swift blank space");
		root.insert("trie");
		root.insert("this java");
		root.insert("t test");
		Collection<String> rst = root.suffixes("taylor");
		for (String s : rst) {
			System.out.println(s);
		}
		//System.out.println(root.find("taylor"));
	}

}
