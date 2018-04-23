/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        //造一个辅助链表头
        ListNode res = new ListNode(-1);
        while(head!=null) {
            ListNode n = new ListNode(head.val);
            n.next=res.next;
            res.next=n;
            head = head.next;
        }
        return res.next;
    }
}