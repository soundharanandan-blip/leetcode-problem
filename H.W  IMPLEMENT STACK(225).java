import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        // Add the new element to the back of the queue
        queue.add(x);
        
        // Rotate the queue to bring the newly added element to the front
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    // Removes the element on top of the stack and returns it.
    public int pop() {
        return queue.remove();
    }
    
    // Get the top element.
    public int top() {
        return queue.peek();
    }
    
    // Returns whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
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
   
