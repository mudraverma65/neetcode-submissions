class MinStack {

    private Deque<Integer> stackEl;
    private Deque<Integer> minStack;

    public MinStack() {
        stackEl = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
       stackEl.push(val);

       if(minStack.isEmpty() || val <= minStack.peek()){
        minStack.push(val);
       }
    }
    
    public void pop() {
        if(stackEl.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stackEl.pop();
    }
    
    public int top() {
        return stackEl.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
