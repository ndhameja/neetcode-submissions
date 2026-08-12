class MinStack {
    Stack<Integer> inputStack;
    Stack<Integer> minStack;
    Integer min = Integer.MAX_VALUE;
    public MinStack() {
        inputStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty())
            min=val;
        else
            min=Math.min(val,minStack.peek());
            inputStack.push(val);
            minStack.push(min);
    }
    
    public void pop() {
        inputStack.pop();  
        minStack.pop();
    }
    
    public int top() {
        return inputStack.peek();
    }
    
    public int getMin() {
       return  minStack.peek();
    }
}
