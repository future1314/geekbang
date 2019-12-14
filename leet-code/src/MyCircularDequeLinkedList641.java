// https://leetcode-cn.com/problems/design-circular-deque
public class MyCircularDequeLinkedList641 {

    private int totalCapacity;

    private int currentCapacity;

    private Node head;

    private Node tail;

    // TODO

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDequeLinkedList641(int k) {
        this.totalCapacity = k;
        currentCapacity = 0;
        head = new Node();
        tail = new Node();
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        Node node = new Node();
        node.value = value;
        node.prev = head;
        Node oldFirst = head.next;

        if (oldFirst == null) {
            // 在空队列中添加
            node.next = tail;
            tail.prev = node;
        } else {
            node.next = oldFirst;
            oldFirst.prev = node;
        }
        head.next = node;

        currentCapacity++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        Node node = new Node();
        node.value = value;
        node.next = tail;
        Node oldLast = tail.prev;

        if (oldLast == null) {
            // 在空队列中添加
            head.next = node;
            node.prev = head;
        } else {
            oldLast.next = node;
            node.prev = oldLast;
        }
        tail.prev = node;

        currentCapacity++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (currentCapacity < 1) {
            return false;
        }

        Node node = head.next;
        if (currentCapacity == 1) {
            cleanToEmpty();
        } else {
            head.next = node.next;
            node.next.prev = head;
        }
        node = null;

        currentCapacity--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (currentCapacity < 1) {
            return false;
        }

        Node node = tail.prev;
        if (currentCapacity == 1) {
            cleanToEmpty();
        } else {
            tail.prev = node.prev;
            node.prev.next = tail;
        }
        node = null;

        currentCapacity--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (currentCapacity < 1) {
            return -1;
        }
        return head.next.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (currentCapacity < 1) {
            return -1;
        }
        return tail.prev.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return currentCapacity < 1;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return currentCapacity == totalCapacity;
    }

    private void cleanToEmpty(){
        head.next = null;
        tail.prev = null;
    }

    class Node {
        Node prev;
        Node next;
        int value;
    }
}
