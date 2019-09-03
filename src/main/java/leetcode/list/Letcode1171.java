package leetcode.list;

public class Letcode1171 {
  public ListNode removeZeroSumSublists(ListNode head) {
    if (null == head) {
      return head;
    }
    ListNode preStart = null;
    ListNode start = head;
    while (null != start) {
      int sum = start.val;
      ListNode next = start.next;
      while (sum != 0) {
        if (null != next) {
          sum = sum + next.val;
          next = next.next;
        } else {
          break;
        }
      }
      if (sum == 0) {
        // 从头结点开始删除
        if (head == start) {
          preStart = null;
          head = next;

        } else {
          // 指定位置后移
          preStart.next = next;
        }
        start = next;

      } else {
        preStart = start;
        start = start.next;
      }

    }
    return head;


  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 1, -2, 0, 0};
    ListNode lstNode = new ListNode(arr[0]);
    ListNode pre = lstNode;
    for (int i = 1; i < arr.length; i++) {
      ListNode nodeTemp = new ListNode(arr[i]);
      pre.next = nodeTemp;
      pre = nodeTemp;
    }
    new Letcode1171().removeZeroSumSublists(lstNode);
  }
}
