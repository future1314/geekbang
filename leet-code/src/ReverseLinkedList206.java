public class ReverseLinkedList206 {
    // 206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/

    /*
    解
            1 -> 2 -> 3 -> null
    null <- 1 <- 2 <- 3
    下一个元素的指针，指向前一个元素：
    1. 获得下一个元素 next
    2. 下一个元素的指针指向前一个元素
    3. 前一个元素 = 当前的head
    4. 将head更新为next，继续循环
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

