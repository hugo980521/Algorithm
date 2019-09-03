package leetcode.list;

public class Letcode21MergeList {
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
