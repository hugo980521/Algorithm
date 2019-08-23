package tree.trietree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by lcm on 2018/8/15 0015.
 */
public class TrieTree {
    /**
     * 内部节点类
     * @author "zhshl"
     * @date	2014-10-14
     *
     */
    private class Node{
        private int dumpli_num;////该字串的重复数目，  该属性统计重复次数的时候有用,取值为0、1、2、3、4、5……
        private HashMap<Character,Node> childs;////此处用数组实现，当然也可以map或list实现以节省空间
        private boolean isLeaf;///是否为单词节点
        private  Character cValue;
        public Node(Character c){
            dumpli_num=0;
            isLeaf=false;
            childs=new HashMap<Character,Node>();
            cValue=c;

        }
    }


    private Node root;///树根
    public TrieTree(){
        ///初始化trie 树
        root=new Node(null);
    }



    /**
     * 插入字串，用循环代替迭代实现
     * @param words
     */
    public void insert(String words){
        insert(this.root, words);
    }

    public void delete(String words){
        delete(this.root, words);
    }

    /**
     * 插入字串，用循环代替迭代实现
     * @param root
     * @param words
     */
    private void insert(Node root,String words){
        words=words.toLowerCase();////转化为小写
        char[] chrs=words.toCharArray();

        for(int i=0,length=chrs.length; i<length; i++){
            ///用相对于a字母的值作为下标索引，也隐式地记录了该字母的值
            Character cLocal=chrs[i];
            Node local=root.childs.get(cLocal);
            if(local!=null){
                ////已经存在了，该子节点prefix_num++
            }else{
                ///如果不存在
                root.childs.put(chrs[i],new Node(chrs[i]));
                local=root.childs.get(cLocal);
            }

            ///如果到了字串结尾，则做标记
            if(i==length-1){
                local.isLeaf=true;
                local.dumpli_num++;
            }
            ///root指向子节点，继续处理
            root=local;
        }

    }


    /**
     * 删除
     * @param root
     * @param words
     */
    private void delete(Node root,String words){
        words=words.toLowerCase();////转化为小写
        char[] chrs=words.toCharArray();

        List<Node> travelNodes=new ArrayList<Node>();
        travelNodes.add(root);
        for(int i=0,length=chrs.length; i<length; i++){
            Character cLocal=chrs[i];
            Node local=root.childs.get(cLocal);

            if(local!=null){
                travelNodes.add(local);
            }else {
                // 未找到单词，直接返回
                return;
            }

            if (i==length-1){
                // 不是word节点，不进行删除操作
                if(!local.isLeaf){
                   return;
                }
                local.isLeaf=false;
            }
            ///root指向子节点，继续处理
            root=local;
        }

        for(int i=travelNodes.size()-1;i>0;i--){
            Node nodeLoop=travelNodes.get(i);
            Node nodePre=travelNodes.get(i-1);

            // 不存在子节点时，删除此节点
            if( null == nodeLoop.childs || nodeLoop.childs.size() == 0){
                // 非叶子节点删除，叶子节点不能删除
                if(!nodeLoop.isLeaf){
                    nodePre.childs.remove(nodeLoop.cValue);
                }else {
                    return;
                }
            // 存在子节点直接返回
            }else {
                return;
            }
        }


    }

    /**
     * 遍历Trie树，查找所有的words以及出现次数
     * @return HashMap<String, Integer> map
     */
    public HashMap<String,Integer> getAllWords(){
//		HashMap<String, Integer> map=new HashMap<String, Integer>();

        return preTraversal(this.root, "");
    }

    /**
     * 前序遍历。。。
     * @param root		子树根节点
     * @param prefixs	查询到该节点前所遍历过的前缀
     * @return
     */
    private  HashMap<String,Integer> preTraversal(Node root,String prefixs){
        HashMap<String, Integer> map=new HashMap<String, Integer>();

        if(root!=null){

            if(root.isLeaf==true){
                ////当前即为一个单词
                map.put(prefixs, root.dumpli_num);
            }

            Set<Character> keySet= root.childs.keySet();
            if(null !=keySet){
                for(Character c:keySet){
                    if(root.childs.get(c)!=null){
                        char ch=c;
                        ////递归调用前序遍历
                        String tempStr=prefixs+ch;
                        map.putAll(preTraversal(root.childs.get(c), tempStr));
                    }
                }
            }

        }

        return map;
    }




    /**
     * 判断某字串是否在字典树中
     * @param word
     * @return true if exists ,otherwise  false
     */
    public boolean isExist(String word){
        return search(this.root, word);
    }
    /**
     * 查询某字串是否在字典树中
     * @param word
     * @return true if exists ,otherwise  false
     */
    private boolean search(Node root,String word){
        char[] chs=word.toLowerCase().toCharArray();
        for(int i=0,length=chs.length; i<length;i++){

            if(root.childs.get(chs[i])==null){
                ///如果不存在，则查找失败
                return false;
            }
            root=root.childs.get(chs[i]);
        }

        return true;
    }

    /**
     * 得到以某字串为前缀的字串集，包括字串本身！ 类似单词输入法的联想功能
     * @param prefix 字串前缀
     * @return 字串集以及出现次数，如果不存在则返回null
     */
    public HashMap<String, Integer> getWordsForPrefix(String prefix){
        return getWordsForPrefix(this.root, prefix);
    }
    /**
     * 得到以某字串为前缀的字串集，包括字串本身！
     * @param root
     * @param prefix
     * @return 字串集以及出现次数
     */
    private HashMap<String, Integer> getWordsForPrefix(Node root,String prefix){
        char[] chrs=prefix.toLowerCase().toCharArray();
        ////
        for(int i=0, length=chrs.length; i<length; i++){


            if(root.childs.get(chrs[i])==null){
                return null;
            }

            root=root.childs.get(chrs[i]);

        }
        ///结果包括该前缀本身
        ///此处利用之前的前序搜索方法进行搜索
        return preTraversal(root, prefix);
    }

}
