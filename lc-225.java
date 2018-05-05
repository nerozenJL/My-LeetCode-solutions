class MyStack {

    /** Initialize your data structure here. */
    private Queue<Integer> q,s;
    public MyStack() {
        this.q = new LinkedList();
        this.s = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(!q.isEmpty())q.offer(x);
        else s.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q.isEmpty()) {
            while(q.size()>1) {
                s.offer(q.poll());
            }
            return q.poll();
        }else{
            while(s.size()>1) {
                q.offer(s.poll());
            }
            return s.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if(!q.isEmpty()) {
            while(q.size()>1) {
                s.offer(q.poll());
            }
            s.offer(q.peek());
            return q.poll();
        }else{
            while(s.size()>1) {
                q.offer(s.poll());
            }
            q.offer(s.peek());
            return s.poll();
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return s.isEmpty() && q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */