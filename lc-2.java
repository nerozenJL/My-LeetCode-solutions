class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        //ListNode lp1 = l1, lp2 = l2;
        ListNode l3 = new ListNode(l1.val + l2.val);
        if(l3.val >= 10) {
            l3.val -= 10;
            carry = 1;
        }
        ListNode lp3 = l3;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null) {
            lp3.next = new ListNode((l1 == null?0:l1.val) + (l2==null?0:l2.val));
            lp3.next.val += carry;
            if(lp3.next.val >= 10) {
                lp3.next.val -= 10;
                carry = 1;
            }else {
                carry = 0;
            }
            lp3 = lp3.next;
            l1 = (l1 == null?null:l1.next);
            l2 = (l2 == null?null:l2.next);
        }
        if(carry>0) {
            lp3.next = new ListNode(1);
        }
        return l3;
    }
}