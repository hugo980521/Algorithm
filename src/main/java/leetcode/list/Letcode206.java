package leetcode.list;

public class Letcode206 {

  /**
   * 反转一个单链表。
   *
   * 示例:
   *
   * 输入: 1->2->3->4->5->NULL
   * 输出: 5->4->3->2->1->NULL
   * 进阶:
   * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {

    if(null == head ){
      return head;
    }
    ListNode newHead=new ListNode(-1) ;

    ListNode temp=head;
    while(null != temp){
      ListNode localNext=temp.next;

      ListNode pre=newHead.next;
      newHead.next=temp;
      temp.next=pre;

      temp=localNext;
    }
    return newHead.next;

  }


  /**
   * 反转一个单链表。(递归方式)
   *
   * 示例:
   *
   * 输入: 1->2->3->4->5->NULL
   * 输出: 5->4->3->2->1->NULL
   * 进阶:
   * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
   *
   * @param head
   * @return
   */
  public ListNode reverseListRecursive(ListNode head) {

    if(null == head || null ==head.next ){
      return head;
    }
    ListNode newHead=reverseListRecursive(head.next);
    head.next.next=head;
    head.next=null;
    return newHead;
  }
}