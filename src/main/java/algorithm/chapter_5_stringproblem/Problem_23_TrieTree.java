package algorithm.chapter_5_stringproblem;

import java.util.HashMap;

public class Problem_23_TrieTree {

	public static class TrieNode {
		public int path;
		public int end;
		public HashMap<Character,TrieNode>  map;

		public TrieNode() {
			path = 0;
			end = 0;
			map = new HashMap<Character,TrieNode>();
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
;
				if (node.map.get(chs[i]) == null) {
					node.map.put(chs[i],new TrieNode());
				}
				node = node.map.get(chs[i]);
				node.path++;
			}
			node.end++;
		}

		public void delete(String word) {
			if (search(word)) {
				char[] chs = word.toCharArray();
				TrieNode node = root;

				for (int i = 0; i < chs.length; i++) {
					if (node.map.get(chs[i]).path-- == 1) {
						node.map.remove(chs[i]);
						return;
					}
					node = node.map.get(chs[i]);
				}
				node.end--;
			}
		}

		public boolean search(String word) {
			if (word == null) {
				return false;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				if (node.map.get(chs[i]) == null) {
					return false;
				}
				node = node.map.get(chs[i]);
			}
			return node.end != 0;
		}

		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			for (int i = 0; i < chs.length; i++) {
				if (node.map.get(chs[i]) == null) {
					return 0;
				}
				node = node.map.get(chs[i]);
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
