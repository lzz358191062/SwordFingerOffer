package com.lzz.mylibrary;


import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 *
 * @author lzz
 * @time 21-2-2 上午11:49
 */
public class PopAndPushWithStack {


    static int[] data = {1, 2, 3, 4, 5, 6, 7};
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        PopAndPushWithStack obj = new PopAndPushWithStack();
        obj.push();
        for (int i = 0; i < data.length; i++) {
            try {
                System.out.println("pop = " + obj.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void push() {
        if (!stack1.isEmpty()) {
            stack1.clear();
        }
        for (int i = 0; i < data.length; i++) {
            stack1.push(data[i]);
        }
    }

    public int pop() throws Exception {
        if (stack2.isEmpty()) {
            for (int i = 0; i < data.length; i++) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return stack2.pop();
    }
}
