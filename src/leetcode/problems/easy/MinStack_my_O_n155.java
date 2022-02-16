package leetcode.problems.easy;

import java.util.Stack;

public class MinStack_my_O_n155 {
    Stack<Integer> stack;

    public MinStack_my_O_n155() {
        stack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);
    }
    //add stack empty checks
    public void pop() {
        if(stack.isEmpty()) System.exit(0);
        this.stack.pop();
    }
    //add stack empty checks
    public int top() {
        if(stack.isEmpty()) System.exit(0);
        return this.stack.peek();
    }
    //add stack empty checks
    public int getMin() {
        Stack<Integer> temp = new Stack();
        if(stack.isEmpty()) System.exit(0);

        int min = Integer.MAX_VALUE;
        int num =0;

        while(!stack.isEmpty()){
            num = stack.pop();
            if(num<min) min = num;
//   else
            temp.push(num);
        }

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack_my_O_n155 minStack = new MinStack_my_O_n155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
