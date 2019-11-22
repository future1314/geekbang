/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        mergeToList(list, l1);
        mergeToList(list, l2);

        Integer[] nums = list.toArray(new Integer[list.size()]);
        Arrays.sort(nums);

        ListNode result = getListNode(nums);

        return result;
    }

    public void mergeToList(List<Integer> list, ListNode l){
        while (l != null){
            int val = l.val;
            list.add(val);
            l = l.next;
        }
    }

    public ListNode getListNode(Integer[] nums){
        ListNode listNode = null;
        ListNode currentNode = null;

        for(int num : nums){
            if(listNode == null){
                listNode = new ListNode(num);
                currentNode = listNode;
            }else {
                ListNode next = new ListNode(num);
                currentNode.next = next;
                currentNode = next;
            }
        }

        return listNode;
    }
}
