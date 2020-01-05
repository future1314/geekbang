public class ReverseLinkedList206 {
    // 206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/

    /*
    解
            1 -> 2 -> 3 -> null
    null <- 1 <- 2 <- 3
    下一个元素的指针，指向前一个元素
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

