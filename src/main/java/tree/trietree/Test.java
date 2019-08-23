package tree.trietree;

import java.util.HashMap;

/**
 * Created by lcm on 2018/8/15 0015.
 */
public class Test {
    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        trie.insert("I");
        trie.insert("Love");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("China");
        trie.insert("xiaoliang");
        trie.insert("xiaoliang");
        trie.insert("man");
        trie.insert("handsome");
        trie.insert("love");
        trie.insert("chinaha");
        trie.insert("her");
        trie.insert("know");

        HashMap<String, Integer> map = trie.getAllWords();

        for (String key : map.keySet()) {
            System.out.println(key + " 出现: " + map.get(key) + "次");
        }


        map = trie.getWordsForPrefix("chin");

        System.out.println("\n\n包含chin（包括本身）前缀的单词及出现次数：");
        for (String key : map.keySet()) {
            System.out.println(key + " 出现: " + map.get(key) + "次");
        }

        if (trie.isExist("xiaoming") == false) {
            System.out.println("\n\n字典树中不存在：xiaoming ");
        }



        TrieTree trieDelete = new TrieTree();
        trieDelete.insert("app");
        trieDelete.insert("apple");

        trieDelete.delete("apple");
        trieDelete.delete("app");

        System.out.println("good");

    }



}
