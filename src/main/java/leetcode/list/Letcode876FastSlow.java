package leetcode.list;

public class Letcode876FastSlow {
  public ListNode middleNode(ListNode head) {
    if(null == head || null == head.next){
      return head;
    }
    ListNode slow=head;
    ListNode fast=head;
    while(null !=fast){
      fast=fast.next;
      if(null!=fast){
        slow=slow.next;
        fast=fast.next;
      }
    }
    return slow;
  }
}
