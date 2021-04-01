package com.lzz.mylibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author lzz
 * @time 21-2-1 下午5:59
 */
public class TreeLinkNode {
    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<TreeNode> nodeList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new TreeNode(array[i]));
        }
        creatTree(nodeList);
        System.out.println("pre = ");
        preGet(nodeList.get(0));
        System.out.println("\nmiddle = ");
        middleGet(nodeList.get(0));
        System.out.println("\nnext = ");
        nextGet(nodeList.get(0));
        System.out.println();
        TreeLinkNode treeNode = new TreeLinkNode();
        for (int j = 0; j < array.length; j++) {
            TreeNode node = treeNode.GetNext(nodeList.get(j));
            if (node != null) {
                System.out.println("next = " + node.val);
            }
        }


    }

    private static void preGet(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.print("  " + treeNode.val);
        preGet(treeNode.left);
        preGet(treeNode.right);
    }

    private static void middleGet(TreeNode treeNode) {
        if (treeNode == null)
            return;
        middleGet(treeNode.left);
        System.out.print("  " + treeNode.val);
        middleGet(treeNode.right);
    }

    private static void nextGet(TreeNode treeNode) {
        if (treeNode == null)
            return;
        nextGet(treeNode.left);
        nextGet(treeNode.right);
        System.out.print("  " + treeNode.val);
    }

    private static void creatTree(List<TreeNode> nodeList) {
        for (int i = 0; i < array.length / 2 - 1; i++) {
            nodeList.get(i).left = nodeList.get(i * 2 + 1);
            nodeList.get(i * 2 + 1).next = nodeList.get(i);
            nodeList.get(i).right = nodeList.get(i * 2 + 2);
            nodeList.get(i * 2 + 2).next = nodeList.get(i);
        }
        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        nodeList.get(lastParentIndex * 2 + 1).next = nodeList.get(lastParentIndex);
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
            nodeList.get(lastParentIndex * 2 + 2).next = nodeList.get(lastParentIndex);
        }
    }

    public TreeNode GetNext(TreeNode pNode) {
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            while (pNode.next != null) {
                TreeNode parent = pNode.next;
                if (parent.left == pNode) {
                    pNode = parent;
                    return pNode;
                }
            }
        }
        return null;
    }

    public static class TreeNode {

        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode next = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
