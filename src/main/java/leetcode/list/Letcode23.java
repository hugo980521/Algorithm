package leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
public class Letcode23 {
  public ListNode mergeKLists(ListNode[] lists) {
    if(null==lists || lists.length==0){
      return null;
    }
    List<ListNode> temp=new ArrayList<>();
    for(ListNode node:lists){
      temp.add(node);
    }

    while(temp.size()>1){
      List<ListNode> local=new ArrayList<>();
      int index=temp.size()-1;
      while(index>0){
        local.add(mergeTwoLists(temp.get(index),temp.get(index-1)));
        index=index-2;
      }
      if(index==0){
        local.add(temp.get(0));
      }
      temp=local;
    }

    return temp.get(0);

  }


  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // 各有一个空时返回不空的
    if(null ==l1 && null== l2 ){
      return null;
    }

    if(null ==l1 && null!=l2){
      return l2;
    }
    if(null !=l1 && null==l2){
      return l1;
    }
    // 都不为空时分别合并
    ListNode newHead=new ListNode(-1);
    ListNode pre=newHead;
    while(null !=l1 && null !=l2){
      if(l1.val<=l2.val){
        pre.next=l1;
        pre=l1;
        l1=l1.next;
      }else{
        pre.next=l2;
        pre=l2;
        l2=l2.next;
      }
    }
    if(null!=l1){
      pre.next=l1;
    }
    if(null!=l2){
      pre.next=l2;
    }
    return newHead.next;

  }
}
