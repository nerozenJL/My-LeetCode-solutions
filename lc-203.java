/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
* 不够简洁
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)return head;
        
        ListNode prev = head, now = head.next;
        while(now != null) {
            if(now.val == val) {
                prev.next = now.next;
                now.next = null;
                now = prev.next;
            }else {
                prev = prev.next;
                now = prev.next;
            }
        }
        if(head.val == val)return head.next;
        else return head;
    }
}