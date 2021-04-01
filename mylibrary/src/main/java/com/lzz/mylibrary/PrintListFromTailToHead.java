package com.lzz.mylibrary;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 要逆序打印链表 1->2->3（3,2,1)
 * <p>
 * 1->2->3
 * 空 -
 *
 * @author lzz
 * @time 21-1-27 上午9:59
 */
public class PrintListFromTailToHead {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(printListFromTailToHead(listNode1));
        System.out.println(printListFromTailToHeadStack(listNode1));
        System.out.println(printListFromTailToHeadList(listNode1));
        System.out.println(buildListFromTailToHead());
        System.out.println(buildListFromHeadToTail());

    }

    /**
     * 递归打印
     *
     * @author lzz
     * @time 21-1-27 上午10:27
     */
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode1) {
        ArrayList<Integer> ar = new ArrayList();
        if (listNode1 != null) {
            ar.addAll(printListFromTailToHead(listNode1.next));
            ar.add(listNode1.val);
        }
        return ar;
    }

    /**
     * 栈打印
     *
     * @author lzz
     * @time 21-1-27 上午10:27
     */
    private static ArrayList<Integer> printListFromTailToHeadStack(ListNode listNode1) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode1 != null) {
            stack.push(listNode1);
            listNode1 = listNode1.next;
        }
        ArrayList<Integer> ar = new ArrayList();
        while (!stack.empty()) {
            ar.add(stack.pop().val);
        }
        return ar;
    }

    /**
     * 头插法构建逆序链表打印
     *
     * @author lzz
     * @time 21-1-27 上午10:27
     */
    private static ArrayList<Integer> printListFromTailToHeadList(ListNode listNode1) {

        ListNode head = new ListNode(-1);
        while (listNode1 != null) {
            // 记录旧链表的下一个节点
            ListNode tmp = listNode1.next;
            // listNode1节点插入新链表的头节点后面
            listNode1.next = head.next;
            head.next = listNode1;
            // 旧链表下一个节点
            listNode1 = tmp;
        }
        ArrayList<Integer> ar = new ArrayList();
        while (head.next != null) {
            ar.add(head.next.val);
            head = head.next;
        }

        return ar;
    }

    /**
     * 头插法构建逆序链表
     *
     * @author lzz
     * @time 21-1-27 上午10:27
     */
    private static ArrayList<Integer> buildListFromTailToHead() {
        String[] source = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        ListNode head = new ListNode(-1);
        for (int i = 0; i < source.length; i++) {
            ListNode item = new ListNode(Integer.parseInt(source[i]));
            item.next = head.next;
            head.next = item;
        }

        ArrayList<Integer> ar = new ArrayList();
        while (head.next != null) {
            ar.add(head.next.val);
            head = head.next;
        }

        return ar;
    }

    /**
     * 尾插法构建逆序链表
     *
     * @author lzz
     * @time 21-1-27 上午10:27
     */
    private static ArrayList<Integer> buildListFromHeadToTail() {
        String[] source = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        ListNode head = new ListNode(-1);
        ListNode current = null;
        for (int i = 0; i < source.length; i++) {
            ListNode item = new ListNode(Integer.parseInt(source[i]));
            if (i == 0) {
                head.next = item;
            } else {
                current.next = item;
            }
            current = item;
        }

        ArrayList<Integer> ar = new ArrayList();
        while (head.next != null) {
            ar.add(head.next.val);
            head = head.next;
        }

        return ar;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
