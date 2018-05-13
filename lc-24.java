//非常有意义的错误，尚且不知道错在哪里了
class Solution {
    public ListNode swapPairs(ListNode head) {
        //交换
        ListNode res = head;
        while(res != null && res.next != null) {
            ListNode t = res.next;
            res.next = t.next;
            t.next = res;
            res = res.next;
        }
        return head;
    }
}

//我自己的ac方案
class Solution {
    public ListNode swapPairs(ListNode head) {
        //交换
        ListNode nh = new ListNode(0);
        ListNode res = nh;

        while(head != null && head.next != null) {
            head = swap(head);
            nh.next = head;
            nh = nh.next.next;
            head = head.next.next == null?null:head.next.next;
        }

        return res.next;
    }
    private ListNode swap(ListNode n) {
        ListNode t = n.next;
        n.next = t.next;
        t.next = n;
        return t;
    }
}


//参考答案
public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = new ListNode(0), temp = head, suf;
        //一个前置空表头
        head = pre;

        while (temp != null && temp.next != null){
            pre.next = temp.next;
            suf = temp.next.next;
            temp.next.next = temp;
            temp.next = suf;
            pre = temp;
            temp = temp.next;
        }

        return head.next;
}

