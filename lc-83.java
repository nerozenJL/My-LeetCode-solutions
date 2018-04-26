/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return head;
        ListNode res = head;
        Integer ln = head.val;
        while(head.next != null) {
            if(ln != null && head.next.val == ln) {
                head.next = head.next.next;
            }else{
                ln = head.next.val;
                head = head.next;
            }
        }
        return res;
    }
}