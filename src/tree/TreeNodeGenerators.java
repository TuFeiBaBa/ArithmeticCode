package tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import queue.Queue;

import static util.Print.print;

/**
 * @author tufei
 * @date 2018/1/3.
 */

public class TreeNodeGenerators {
    /**
     * 生成指定长度的二叉树
     *
     * @param length
     * @return
     */
    public static BinaryTreeNode fill(int length) {
        if (length <= 0) {
            return null;
        }
        Queue<BinaryTreeNode<Integer>> queue = new Queue<>();
        BinaryTreeNode<Integer> head = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> last = head;
        last.setData(1);
        queue.enQueue(last);
        for (int i = 2; i < length + 1; i++) {
            BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<>();
            treeNode.setData(i);
            BinaryTreeNode<Integer> front = queue.front();
            if (front.getLeft() == null) {
                front.setLeft(treeNode);
            } else {
                front.setRight(treeNode);
                queue.deQueue();
            }
            queue.enQueue(treeNode);
        }
        return head;
    }

    /**
     * 按给定的数据集合，生成一个恰好能存储这些数据的链表
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> BinaryTreeNode<T> fill(List<T> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        BinaryTreeNode<T> head = new BinaryTreeNode<>();
        BinaryTreeNode<T> last = head;
        last.setData(list.get(0));
        queue.enQueue(last);
        for (int i = 1; i < list.size(); i++) {
            BinaryTreeNode<T> treeNode = new BinaryTreeNode<>();
            treeNode.setData(list.get(i));
            BinaryTreeNode<T> front = queue.front();
            if (front.getLeft() == null) {
                front.setLeft(treeNode);
            } else {
                front.setRight(treeNode);
                queue.deQueue();
            }
            queue.enQueue(treeNode);
        }
        return head;
    }

    public static void main(String[] args) {
        BinaryTreeNode treeNode1 = TreeNodeGenerators.fill(0);
        print("生成的二叉树treeNode1的长度为：" + (treeNode1 == null ? 0 : treeNode1.size()));
        print(treeNode1);
        BinaryTreeNode treeNode2 = TreeNodeGenerators.fill(10);
        print("生成的二叉树treeNode2的长度为：" + (treeNode2 == null ? 0 : treeNode2.size()));
        print(treeNode2);
        BinaryTreeNode<Object> treeNode3 = TreeNodeGenerators.fill(Collections.emptyList());
        print("生成的二叉树treeNode3的长度为：" + (treeNode3 == null ? 0 : treeNode3.size()));
        print(treeNode3);
        BinaryTreeNode<Integer> treeNode4 = TreeNodeGenerators.fill(Arrays.asList(1, 2, 3, 4, 5));
        print("生成的二叉树treeNode4的长度为：" + (treeNode4 == null ? 0 : treeNode4.size()));
        print(treeNode4);
    }
}
