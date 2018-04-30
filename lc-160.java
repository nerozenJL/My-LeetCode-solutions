/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)return null;
        int alen = 0, blen = 0;
        ListNode ca = headA, cb = headB;
        while(ca != null || cb != null) {
            if(ca != null) {
                alen++;
                ca = ca.next;
            }
            if(cb != null) {
                blen++;
                cb = cb.next;
            }
        }
        ca = headA;
        cb = headB;
        if(alen > blen) {
            while(alen > blen) {
                //让a链表先走，使得起步时步数一致
                alen--;
                ca = ca.next;
            }
            
        }else if(alen < blen){
            while(alen < blen) {
                //让b链表先走，使得起步时步数一致
                blen--;
                cb = cb.next;
            }
        }
        while(ca != null && cb != null) {
                if(ca == cb) return ca;
                ca = ca.next;
                cb = cb.next;
        }
        return null;
    }
}