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


//注意，这里的循环并不只有收尾循环，而是任意一个部分的循环

//经典解法，用快慢指针
/*public boolean hasCycle(ListNode head) {
       if(head == null || head.next == null)return false; 
       ListNode fast = head,slow = fast;
       while(fast != null && fast.next != null) {
           if(fast.next != slow) {
               slow = slow.next;
               fast = fast.next.next;
           }else return true;
       } 
       return false; 
}*/




//不使用额外空间，破坏链表的存储，使遍历过的结点都指向头结点

public class Solution {
    public boolean hasCycle(ListNode head) {
       ListNode first = head;
       while(head != null) {
           if(head.next == first) return true;
           else {
               ListNode temp = head;
               head = head.next;
               temp.next = first;
           }
       } 
       return false; 
    }
}