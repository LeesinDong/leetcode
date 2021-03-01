class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        // 分别 1.stack push 2minStack push
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            // ************************* 不小，就再把原来的小的再放一遍
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        // ************************ 因为每次会把最小的重新放一边，所以不论minStack上面 是最小的，还是不是最小的，都应该弹出来
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
