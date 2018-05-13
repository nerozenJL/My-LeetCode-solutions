class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        int j = 1;
        ListNode fast = head, slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            i++;
            j++;
            if(fast.next == null) {
                break;
            }else{
                fast = fast.next;
                j++;
            }
        }
        //得到链表长度，以及慢指针所在的位置
        //如果n在慢指针前面，则从头指针开始遍历，反之则从慢指针开始遍历
        if(j-n+1 > i) {
            //从慢指针开始遍历
            while(i++ < j-n) { //这里本来是j-n+1
                slow = slow.next;
            }
            System.out.println(slow.val);
            //删除操作
            ListNode t = slow.next;
            slow.next = slow.next==null?null:slow.next.next;
            t = null;
            
            return head;
        }else {
            int k = 0;
            ListNode nhead = new ListNode(-1);
            nhead.next = head;
            ListNode hp = nhead;
            
            while(k++ < j-n) nhead = nhead.next;  //j-n+1
            ListNode t = nhead.next;
            nhead.next = (nhead.next == null?null:nhead.next.next);
            t = null;
            
            return hp.next;
        }
        
    }
}