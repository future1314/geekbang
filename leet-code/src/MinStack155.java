import java.util.Stack;

public class MinStack155 {
    // 155. 最小栈 https://leetcode-cn.com/problems/min-stack/

    Stack<Integer> data = new Stack();
    Stack<Integer> helper = new Stack();

    /** initialize your data structure here. */
    public MinStack155() {

    }

    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() >= x) {
            helper.push(x);
        }
    }

    public void pop() {
        int val = data.pop();
        if (val == helper.peek()) {
            helper.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
