/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       if(head == null || head.next == null)return null; 
        
       ListNode fast = head,slow = head;
       while(fast != null && slow != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast) {
               fast = head;
               while(fast != slow) {
                   fast = fast.next;
                   slow = slow.next;
               }
               return fast;
           }
       }
       return null; 
    }
}